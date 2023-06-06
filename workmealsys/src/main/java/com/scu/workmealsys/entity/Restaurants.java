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
@TableName("restaurants")
public class Restaurants implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId
    private Integer restaurantId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String name ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String address ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String phone ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String url ;

    /**  */
    public Integer getRestaurantId(){
        return this.restaurantId;
    }
    /**  */
    public void setRestaurantId(Integer restaurantId){
        this.restaurantId=restaurantId;
    }
    /**  */
    public String getName(){
        return this.name;
    }
    /**  */
    public void setName(String name){
        this.name=name;
    }
    /**  */
    public String getAddress(){
        return this.address;
    }
    /**  */
    public void setAddress(String address){
        this.address=address;
    }
    /**  */
    public String getPhone(){
        return this.phone;
    }
    /**  */
    public void setPhone(String phone){
        this.phone=phone;
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