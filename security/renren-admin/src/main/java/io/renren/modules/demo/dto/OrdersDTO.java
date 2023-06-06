package io.renren.modules.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Data
@ApiModel(value = "")
public class OrdersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "点餐号")
	private Integer orderId;

	@ApiModelProperty(value = "用户ID")
	private Integer userId;

	@ApiModelProperty(value = "菜单编号")
	private Integer menuId;

	@ApiModelProperty(value = "餐厅编号")
	private Integer restaurantId;

	@ApiModelProperty(value = "点餐日期")
	private Date orderDate;

	@ApiModelProperty(value = "数量")
	private Integer quantity;

	@ApiModelProperty(value = "用户点餐订单号")
	private String userOrder;

	@ApiModelProperty(value = "单价")
	private BigDecimal price;


}