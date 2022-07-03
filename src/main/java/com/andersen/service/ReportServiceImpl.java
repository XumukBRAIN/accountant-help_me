package com.andersen.service;

import com.andersen.dto.ReportDto;
import com.andersen.repository.ReportRepository;

public class ReportServiceImpl implements ReportService{

    private ReportRepository reportRepository;

    @Override
    public ReportDto getReport(Long id) {
        return reportRepository.getReport(id);
    }

}
