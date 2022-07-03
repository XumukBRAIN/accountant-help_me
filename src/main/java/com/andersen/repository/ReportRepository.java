package com.andersen.repository;

import com.andersen.dto.ReportDto;
import com.andersen.model.Track;
import org.hibernate.Session;

public interface ReportRepository {

    ReportDto getReport(Long id);

}
