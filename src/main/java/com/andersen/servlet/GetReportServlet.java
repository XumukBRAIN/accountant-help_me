package com.andersen.servlet;

import com.andersen.dto.ReportDto;
import com.andersen.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Long.parseLong;


@WebServlet("/report")
public class GetReportServlet extends HttpServlet {
    
    private ReportService reportService;
    private ObjectMapper objectMapper;
    @Override
    public void init(ServletConfig config) throws ServletException {
        reportService = (ReportService) config.getServletContext().
                getAttribute("reportService");
        objectMapper = (ObjectMapper) config.getServletContext().
                getAttribute("objectMapper");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        if ((id = getId(req, "reportId")) == null) {
            return;
        }
        try (PrintWriter writer = resp.getWriter()) {
            ReportDto responseObj = reportService.getReport(id);
            objectMapper.writeValue(writer, responseObj);
        }
    }

    private Long getId(HttpServletRequest req, String parameterName) {
        String textId = null;
        if ((textId = req.getParameter(parameterName)) == null) {
            return null;
        } else {
            return parseLong(textId);
        }
    }

}
