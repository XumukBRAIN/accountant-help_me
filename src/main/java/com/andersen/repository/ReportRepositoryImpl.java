package com.andersen.repository;

import com.andersen.dto.ReportDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReportRepositoryImpl implements ReportRepository{

    private SessionFactory sessionFactory;

    @Override
    public ReportDto getReport(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("select r from Report r", ReportDto.class)
                    .getSingleResult();
        }
    }
}
