package com.ad.web.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
public class WorkStationDetail {
    private String regionName;
    private int totalUsed;
    private int totalFree;
    private int totalActive;
    private int totalInactive;
    List<WorkStationInfo> workStationInfoList;

    public int getTotalActive() {
        return totalActive;
    }

    public void setTotalActive(int totalActive) {
        this.totalActive = totalActive;
    }

    public int getTotalFree() {
        return totalFree;
    }

    public void setTotalFree(int totalFree) {
        this.totalFree = totalFree;
    }

    public int getTotalUsed() {
        return totalUsed;
    }

    public void setTotalUsed(int totalUsed) {
        this.totalUsed = totalUsed;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getTotalInactive() {
        return totalInactive;
    }

    public void setTotalInactive(int totalInactive) {
        this.totalInactive = totalInactive;
    }

    public List<WorkStationInfo> getWorkStationInfoList() {
        return workStationInfoList;
    }

    public void setWorkStationInfoList(List<WorkStationInfo> workStationInfoList) {
        this.workStationInfoList = workStationInfoList;
    }
}

