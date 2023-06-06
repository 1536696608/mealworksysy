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
 * @date : 2023-5-17
 */
@ApiModel(value = "",description = "")
@TableName("transactions")

public class Transactions implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId
    private Integer transactionId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer userId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Integer restaurantId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Date orderDate ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Double totalAmount ;

    /**  */
    public Integer getTransactionId(){
        return this.transactionId;
    }
    /**  */
    public void setTransactionId(Integer transactionId){
        this.transactionId=transactionId;
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
    public Integer getRestaurantId(){
        return this.restaurantId;
    }
    /**  */
    public void setRestaurantId(Integer restaurantId){
        this.restaurantId=restaurantId;
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
    public Double getTotalAmount(){
        return this.totalAmount;
    }
    /**  */
    public void setTotalAmount(Double totalAmount){
        this.totalAmount=totalAmount;
    }
}