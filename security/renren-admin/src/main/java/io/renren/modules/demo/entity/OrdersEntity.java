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
@TableName("orders")
public class OrdersEntity {

    /**
     * 点餐号
     */
	private Integer orderId;
    /**
     * 用户ID
     */
	private Integer userId;
    /**
     * 菜单编号
     */
	private Integer menuId;
    /**
     * 餐厅编号
     */
	private Integer restaurantId;
    /**
     * 点餐日期
     */
	private Date orderDate;
    /**
     * 数量
     */
	private Integer quantity;
    /**
     * 用户点餐订单号
     */
	private String userOrder;
    /**
     * 单价
     */
	private BigDecimal price;
}