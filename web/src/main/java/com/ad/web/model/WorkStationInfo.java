package com.ad.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WorkStationInfo {
    private String regionName;
    private String districtName;
    private String upozilaName;
    private String workStationId;
    private LicenseStatus licenseStatus;
    private BindStatus bindStatus;
    private String bindDate;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getUpozilaName() {
        return upozilaName;
    }

    public void setUpozilaName(String upozilaName) {
        this.upozilaName = upozilaName;
    }

    public String getWorkStationId() {
        return workStationId;
    }

    public void setWorkStationId(String workStationId) {
        this.workStationId = workStationId;
    }

    public LicenseStatus getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(LicenseStatus licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public BindStatus getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(BindStatus bindStatus) {
        this.bindStatus = bindStatus;
    }

    public String getBindDate() {
        return bindDate;
    }

    public void setBindDate(String bindDate) {
        this.bindDate = bindDate;
    }
}
