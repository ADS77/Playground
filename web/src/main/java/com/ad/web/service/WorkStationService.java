package com.ad.web.service;

import com.ad.web.model.WorkStationDetail;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WorkStationService {

    public List<WorkStationDetail> getWokStationDetail();

    public byte[] generateReport(List<WorkStationDetail> workStationDetails);

}
