package io.renren.modules.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 工人管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Data
public class EmployeeExcel {
    @Excel(name = "员工ID")
    private Long id;
    @Excel(name = "员工名")
    private String name;
    @Excel(name = "部门")
    private String department;
    @Excel(name = "职位")
    private String position;

}