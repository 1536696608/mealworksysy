package io.renren.modules.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
public class OrdersExcel {
    @Excel(name = "点餐号")
    private Integer orderId;
    @Excel(name = "用户ID")
    private Integer userId;
    @Excel(name = "菜单编号")
    private Integer menuId;
    @Excel(name = "餐厅编号")
    private Integer restaurantId;
    @Excel(name = "点餐日期")
    private Date orderDate;
    @Excel(name = "数量")
    private Integer quantity;
    @Excel(name = "用户点餐订单号")
    private String userOrder;
    @Excel(name = "单价")
    private BigDecimal price;

}