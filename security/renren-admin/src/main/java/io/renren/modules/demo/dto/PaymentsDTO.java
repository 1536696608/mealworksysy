package io.renren.modules.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 订单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-01
 */
@Data
@ApiModel(value = "订单管理")
public class PaymentsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "订单编号")
	private Long id;

	@ApiModelProperty(value = "订单号")
	private String userOrder;

	@ApiModelProperty(value = "订单日期")
	private Date paymentDate;

	@ApiModelProperty(value = "总支付")
	private BigDecimal amount;

	@ApiModelProperty(value = "用户ID")
	private Long userId;

	@ApiModelProperty(value = "是否出餐")
	private Integer complete;


}