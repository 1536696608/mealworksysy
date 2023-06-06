package io.renren.modules.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Data
public class RestaurantsExcel {
    @Excel(name = "餐厅号")
    private Integer restaurantId;
    @Excel(name = "餐厅名")
    private String name;
    @Excel(name = "地址")
    private String address;
    @Excel(name = "电话")
    private String phone;
    @Excel(name = "餐厅图片")
    private String url;

}