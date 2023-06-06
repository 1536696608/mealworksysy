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
public class MenusDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "菜单编号")
	private Integer menuId;

	@ApiModelProperty(value = "餐厅编号")
	private Integer restaurantId;

	@ApiModelProperty(value = "菜名")
	private String dishName;

	@ApiModelProperty(value = "价格（元）")
	private BigDecimal price;

	@ApiModelProperty(value = "图片地址")
	private String url;


}