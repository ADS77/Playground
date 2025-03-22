package com.ad.web.controller;

import com.ad.web.model.WorkStationDetail;
import com.ad.web.service.WorkStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api")
@Slf4j
public class WorkStationController {
    private final WorkStationService workStationService;


    public WorkStationController(WorkStationService workStationService) {
        this.workStationService = workStationService;

    }

    @GetMapping("/get-wsdetail")
    public List<WorkStationDetail> getWorkStationDetail(){
        List<WorkStationDetail> resposne = workStationService.getWokStationDetail();
        byte[] xlsx = workStationService.generateReport(resposne);
        try (FileOutputStream fos = new FileOutputStream("Workstation_Report.xlsx")) {
            fos.write(xlsx);
            System.out.println("Excel report generated: Workstation_Report.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposne;
    }

}
