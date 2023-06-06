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
@TableName("users")
public class Users implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId
    private Integer userId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String username ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String password ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String email ;

    /**  */
    public Integer getUserId(){
        return this.userId;
    }
    /**  */
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    /**  */
    public String getUsername(){
        return this.username;
    }
    /**  */
    public void setUsername(String username){
        this.username=username;
    }
    /**  */
    public String getPassword(){
        return this.password;
    }
    /**  */
    public void setPassword(String password){
        this.password=password;
    }
    /**  */
    public String getEmail(){
        return this.email;
    }
    /**  */
    public void setEmail(String email){
        this.email=email;
    }
}