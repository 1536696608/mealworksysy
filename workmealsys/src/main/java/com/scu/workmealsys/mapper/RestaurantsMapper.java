package com.scu.workmealsys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.scu.workmealsys.entity.Restaurants;

 /**
 * ;(restaurants)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
@Mapper
public interface RestaurantsMapper  extends BaseMapper<Restaurants>{
    /** 
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<Restaurants> selectByPage(IPage<Restaurants> page , @Param(Constants.WRAPPER) Wrapper<Restaurants> wrapper);
}