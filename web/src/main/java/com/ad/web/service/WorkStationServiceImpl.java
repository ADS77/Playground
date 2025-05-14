package com.ad.web.service;

import com.ad.web.model.BindStatus;
import com.ad.web.model.LicenseStatus;
import com.ad.web.model.WorkStationDetail;
import com.ad.web.model.WorkStationInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class WorkStationServiceImpl implements WorkStationService {
    @Override
    public List<WorkStationDetail> getWokStationDetail() {
        List<WorkStationDetail> workStationDetailList = new ArrayList<>();
        WorkStationDetail wd1 = getWsDetailByName("Dhaka");
        WorkStationDetail wd2 = getWsDetailByName("Khulna");
        workStationDetailList.add(wd2);
        workStationDetailList.add(wd1);
        return workStationDetailList;
    }

    @Override
    public byte[] generateReport(List<WorkStationDetail> workStationDetails) {

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Workstations Report");
            int rowNum = 0;
            CellStyle headerStyle = createHeaderStyle(workbook);

            // Grand Total Variables
            int grandTotalUsed = 0;
            int grandTotalFree = 0;
            int grandTotalActive = 0;
            int grandTotalInactive = 0;

            for (WorkStationDetail region : workStationDetails) {
                // Add Region Summary
                Row regionHeaderRow = sheet.createRow(rowNum++);
                regionHeaderRow.createCell(0).setCellValue("Region: " + region.getRegionName());

                Row regionTotalRow = sheet.createRow(rowNum++);
                regionTotalRow.createCell(1).setCellValue("Total Used: " + region.getTotalUsed());
                regionTotalRow.createCell(2).setCellValue("Total Free: " + region.getTotalFree());
                regionTotalRow.createCell(3).setCellValue("Total Active: " + region.getTotalActive());
                regionTotalRow.createCell(4).setCellValue("Total Inactive: " + region.getTotalInactive());

                // Add Headers
                String[] headers = {"WorkStation ID", "District", "Upozila", "License Status", "Bind Status", "Bind Date"};
                Row headerRow = sheet.createRow(rowNum++);
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                    cell.setCellStyle(headerStyle);
                }

                // Add Workstation Details
                for (WorkStationInfo ws : region.getWorkStationInfoList()) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(ws.getWorkStationId() != null ? ws.getWorkStationId() : "N/A");
                    row.createCell(1).setCellValue(ws.getDistrictName() != null ? ws.getDistrictName() : "N/A");
                    row.createCell(2).setCellValue(ws.getUpozilaName() != null ? ws.getUpozilaName() : "N/A");
                    row.createCell(3).setCellValue(ws.getLicenseStatus() != null ? ws.getLicenseStatus().toString() : "N/A");
                    row.createCell(4).setCellValue(ws.getBindStatus() != null ? ws.getBindStatus().toString() : "N/A");
                    row.createCell(5).setCellValue(ws.getBindDate() != null ? ws.getBindDate() : "N/A");
                }

                rowNum++; // Empty row after each region

                // Update Grand Totals
                grandTotalUsed += region.getTotalUsed();
                grandTotalFree += region.getTotalFree();
                grandTotalActive += region.getTotalActive();
                grandTotalInactive += region.getTotalInactive();
            }

            // Add Grand Total Row
            Row grandTotalRow = sheet.createRow(rowNum++);
            grandTotalRow.createCell(0).setCellValue("Grand Totals:");
            grandTotalRow.createCell(1).setCellValue("Total Used: " + grandTotalUsed);
            grandTotalRow.createCell(2).setCellValue("Total Free: " + grandTotalFree);
            grandTotalRow.createCell(3).setCellValue("Total Active: " + grandTotalActive);
            grandTotalRow.createCell(4).setCellValue("Total Inactive: " + grandTotalInactive);

            // Auto-size Columns
            for (int i = 0; i < 6; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write to ByteArrayOutputStream
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                workbook.write(out);
                return out.toByteArray();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while generating Excel file", e);
        }
    }

    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    private WorkStationDetail getWsDetailByName(String region){
        WorkStationDetail workStationDetail = new WorkStationDetail();
        List<WorkStationInfo> workStationInfoList = new ArrayList<>();
        WorkStationInfo ws1 = createWsInfo("dsfgdf", LicenseStatus.ACTIVE, BindStatus.FREE);
        WorkStationInfo ws2 = createWsInfo("sdfgvfsv", LicenseStatus.INACTIVE, BindStatus.USED);
        WorkStationInfo ws3 = createWsInfo("26656", LicenseStatus.ACTIVE, BindStatus.USED);

        workStationInfoList.add(ws1);
        workStationInfoList.add(ws2);
        workStationInfoList.add(ws3);
        workStationDetail.setRegionName(region);
        workStationDetail.setWorkStationInfoList(workStationInfoList);
        int totalUsed = 0;
        int totalFree = 0;
        int totalActive = 0;
        int totalInactive = 0;
        for(WorkStationInfo wi : workStationInfoList){
            if(wi.getLicenseStatus().equals(LicenseStatus.ACTIVE)) totalActive++;
            else totalInactive++;
            if(wi.getBindStatus().equals(BindStatus.USED)) totalUsed++;
            else totalFree++;
        }
        workStationDetail.setTotalActive(totalActive);
        workStationDetail.setTotalFree(totalFree);
        workStationDetail.setTotalUsed(totalUsed);
        workStationDetail.setTotalInactive(totalInactive);
        return workStationDetail;
    }

    private WorkStationInfo createWsInfo(String workStationId, LicenseStatus licenseStatus, BindStatus bindStatus){
        WorkStationInfo workStationInfo = new WorkStationInfo();
        workStationInfo.setWorkStationId(workStationId);
        workStationInfo.setLicenseStatus(licenseStatus);
        workStationInfo.setBindStatus(bindStatus);
        return workStationInfo;
    }
}
