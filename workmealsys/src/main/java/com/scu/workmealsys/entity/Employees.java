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
@TableName("employees")
public class Employees implements Serializable,Cloneable{
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    @TableId
    private Integer employeeId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String name ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String department ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String position ;

    /**  */
    public Integer getEmployeeId(){
        return this.employeeId;
    }
    /**  */
    public void setEmployeeId(Integer employeeId){
        this.employeeId=employeeId;
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
    public String getDepartment(){
        return this.department;
    }
    /**  */
    public void setDepartment(String department){
        this.department=department;
    }
    /**  */
    public String getPosition(){
        return this.position;
    }
    /**  */
    public void setPosition(String position){
        this.position=position;
    }
}