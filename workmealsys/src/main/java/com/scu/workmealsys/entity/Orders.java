package com.scu.workmealsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

 /**
 * ;
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
@ApiModel(value = "",description = "")
@TableName("orders")
public class Orders implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId(type = IdType.AUTO)
    private Integer orderId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer userId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer menuId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Date orderDate ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer quantity ;
    /** 用户点餐订单 */
    @ApiModelProperty(name = "用户点餐订单",notes = "")
    private String userOrder ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer restaurantId ;
     @ApiModelProperty(name = "",notes = "null")
     private Double price ;
    /**  */
    public Integer getOrderId(){
        return this.orderId;
    }
    /**  */
    public void setOrderId(Integer orderId){
        this.orderId=orderId;
    }
    /**  */
    public Integer getUserId(){
        return this.userId;
    }
    /**  */
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    /**  */
    public Integer getMenuId(){
        return this.menuId;
    }
    /**  */
    public void setMenuId(Integer menuId){
        this.menuId=menuId;
    }
    /**  */
    public Date getOrderDate(){
        return this.orderDate;
    }
    /**  */
    public void setOrderDate(Date orderDate){
        this.orderDate=orderDate;
    }
    /**  */
    public Integer getQuantity(){
        return this.quantity;
    }
    /**  */
    public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }
    /** 用户点餐订单 */
    public String getUserOrder(){
        return this.userOrder;
    }
    /** 用户点餐订单 */
    public void setUserOrder(String userOrder){
        this.userOrder=userOrder;
    }
    /**  */
    public Integer getRestaurantId(){
        return this.restaurantId;
    }
    /**  */
    public void setRestaurantId(Integer restaurantId){
        this.restaurantId=restaurantId;
    }

     public Double getPrice(){
         return this.price;
     }
     /**  */
     public void setPrice(Double price){
         this.price=price;
     }
}