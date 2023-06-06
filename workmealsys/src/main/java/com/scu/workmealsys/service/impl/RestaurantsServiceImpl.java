package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Restaurants;
import com.scu.workmealsys.mapper.RestaurantsMapper;
import com.scu.workmealsys.service.RestaurantsService;
 /**
 * ;(restaurants)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
@Service
public class RestaurantsServiceImpl implements RestaurantsService{
    @Autowired
    private RestaurantsMapper restaurantsMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param restaurantId 主键
     * @return 实例对象
     */
    public Restaurants queryById(Integer restaurantId){
        return restaurantsMapper.selectById(restaurantId);
    }
    
    /**
     * 分页查询
     *
     * @param restaurants 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Restaurants> paginQuery(Restaurants restaurants, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Restaurants> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(restaurants.getName())){
            queryWrapper.eq(Restaurants::getName, restaurants.getName());
        }
        if(StrUtil.isNotBlank(restaurants.getAddress())){
            queryWrapper.eq(Restaurants::getAddress, restaurants.getAddress());
        }
        if(StrUtil.isNotBlank(restaurants.getPhone())){
            queryWrapper.eq(Restaurants::getPhone, restaurants.getPhone());
        }
        if(StrUtil.isNotBlank(restaurants.getUrl())){
            queryWrapper.eq(Restaurants::getUrl, restaurants.getUrl());
        }
        //2. 执行分页查询
        Page<Restaurants> pagin = new Page<>(current , size , true);
        IPage<Restaurants> selectResult = restaurantsMapper.selectPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param restaurants 实例对象
     * @return 实例对象
     */
    public Restaurants insert(Restaurants restaurants){
        restaurantsMapper.insert(restaurants);
        return restaurants;
    }
    
    /** 
     * 更新数据
     *
     * @param restaurants 实例对象
     * @return 实例对象
     */
    public Restaurants update(Restaurants restaurants){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Restaurants> chainWrapper = new LambdaUpdateChainWrapper<Restaurants>(restaurantsMapper);
        if(StrUtil.isNotBlank(restaurants.getName())){
            chainWrapper.eq(Restaurants::getName, restaurants.getName());
        }
        if(StrUtil.isNotBlank(restaurants.getAddress())){
            chainWrapper.eq(Restaurants::getAddress, restaurants.getAddress());
        }
        if(StrUtil.isNotBlank(restaurants.getPhone())){
            chainWrapper.eq(Restaurants::getPhone, restaurants.getPhone());
        }
        if(StrUtil.isNotBlank(restaurants.getUrl())){
            chainWrapper.eq(Restaurants::getUrl, restaurants.getUrl());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Restaurants::getRestaurantId, restaurants.getRestaurantId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(restaurants.getRestaurantId());
        }else{
            return restaurants;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param restaurantId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer restaurantId){
        int total = restaurantsMapper.deleteById(restaurantId);
        return total > 0;
    }
}