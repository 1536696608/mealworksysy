package io.renren.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Data
@TableName("menus")
public class MenusEntity {

    /**
     * 菜单编号
     */
	private Integer menuId;
    /**
     * 餐厅编号
     */
	private Integer restaurantId;
    /**
     * 菜名
     */
	private String dishName;
    /**
     * 价格（元）
     */
	private BigDecimal price;
    /**
     * 图片地址
     */
	private String url;
}