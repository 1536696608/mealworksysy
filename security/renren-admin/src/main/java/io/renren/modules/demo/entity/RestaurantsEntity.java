package io.renren.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Data
@TableName("restaurants")
public class RestaurantsEntity {

    /**
     * 餐厅号
     */
	private Integer restaurantId;
    /**
     * 餐厅名
     */
	private String name;
    /**
     * 地址
     */
	private String address;
    /**
     * 电话
     */
	private String phone;
    /**
     * 餐厅图片
     */
	private String url;
}