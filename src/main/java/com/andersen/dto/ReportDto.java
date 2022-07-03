package com.andersen.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReportDto {

    private String color;

    List<SingleReport> singleReports;

}
