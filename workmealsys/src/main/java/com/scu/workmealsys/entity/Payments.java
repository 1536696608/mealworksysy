package com.scu.workmealsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

 /**
 * ;
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
@ApiModel(value = "",description = "")
@TableName("tb_payments")
public class Payments implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId(type = IdType.AUTO)
    @Column(name = "id")
    private Long paymentId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String userOrder ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Date paymentDate ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private Double amount ;

    @ApiModelProperty(name = "",notes = "null")
    private Long userId;
    @ApiModelProperty(name = "",notes = "null")
    private Integer complete;

    /**  */
    public Long getPaymentId(){
        return this.paymentId;
    }
    /**  */
    public void setPaymentId(Long paymentId){
        this.paymentId=paymentId;
    }
    /**  */
    public String getUserOrder(){
        return this.userOrder;
    }
    /**  */
    public void setUserOrder(String userOrder){
        this.userOrder=userOrder;
    }
    /**  */
    public Date getPaymentDate(){
        return this.paymentDate;
    }
    /**  */
    public void setPaymentDate(Date paymentDate){
        this.paymentDate=paymentDate;
    }
    /**  */
    public Double getAmount(){
        return this.amount;
    }
    /**  */
    public void setAmount(Double amount){
        this.amount=amount;
    }
     public Long getUserId(){
         return this.userId;
     }
     /**  */
     public void setUserId(Long userId){
         this.userId=userId;
     }
     /**  */
     public Integer getComplete(){
         return this.complete;
     }
     /**  */
     public void setComplete(Integer complete){
         this.complete=complete;
     }
}