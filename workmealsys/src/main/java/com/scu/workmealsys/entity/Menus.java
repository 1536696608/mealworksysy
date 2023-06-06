package com.scu.workmealsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

 /**
 * ;
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
@ApiModel(value = "",description = "")
@TableName("menus")
public class Menus implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId
    private Integer menuId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer restaurantId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String dishName ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Double price ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String url ;

    /**  */
    public Integer getMenuId(){
        return this.menuId;
    }
    /**  */
    public void setMenuId(Integer menuId){
        this.menuId=menuId;
    }
    /**  */
    public Integer getRestaurantId(){
        return this.restaurantId;
    }
    /**  */
    public void setRestaurantId(Integer restaurantId){
        this.restaurantId=restaurantId;
    }
    /**  */
    public String getDishName(){
        return this.dishName;
    }
    /**  */
    public void setDishName(String dishName){
        this.dishName=dishName;
    }
    /**  */
    public Double getPrice(){
        return this.price;
    }
    /**  */
    public void setPrice(Double price){
        this.price=price;
    }
    /**  */
    public String getUrl(){
        return this.url;
    }
    /**  */
    public void setUrl(String url){
        this.url=url;
    }
}