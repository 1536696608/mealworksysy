package io.renren.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 员工管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Data
@TableName("employees")
public class EmployeesEntity {

    /**
     * 员工编号
     */
	private Integer employeeId;
    /**
     * 姓名
     */
	private String name;
    /**
     * 部门
     */
	private String department;
    /**
     * 职位
     */
	private String position;
}