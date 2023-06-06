package com.scu.workmealsys.dto;

import com.scu.workmealsys.entity.Employees;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePageDto implements Serializable {

    private Employees query;
    private Integer page;
}
