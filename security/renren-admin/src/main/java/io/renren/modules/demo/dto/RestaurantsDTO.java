package io.renren.modules.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Data
@ApiModel(value = "")
public class RestaurantsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "餐厅号")
	private Integer restaurantId;

	@ApiModelProperty(value = "餐厅名")
	private String name;

	@ApiModelProperty(value = "地址")
	private String address;

	@ApiModelProperty(value = "电话")
	private String phone;

	@ApiModelProperty(value = "餐厅图片")
	private String url;


}