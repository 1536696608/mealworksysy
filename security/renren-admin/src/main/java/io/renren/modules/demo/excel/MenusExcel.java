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
public class MenusExcel {
    @Excel(name = "菜单编号")
    private Integer menuId;
    @Excel(name = "餐厅编号")
    private Integer restaurantId;
    @Excel(name = "菜名")
    private String dishName;
    @Excel(name = "价格（元）")
    private BigDecimal price;
    @Excel(name = "图片地址")
    private String url;

}