package io.renren.modules.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 员工管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Data
@ApiModel(value = "员工管理")
public class EmployeesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "员工编号")
	private Integer employeeId;

	@ApiModelProperty(value = "姓名")
	private String name;

	@ApiModelProperty(value = "部门")
	private String department;

	@ApiModelProperty(value = "职位")
	private String position;


}