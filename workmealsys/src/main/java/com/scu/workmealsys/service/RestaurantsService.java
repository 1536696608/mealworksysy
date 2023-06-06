package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.entity.Restaurants;

 /**
 * ;(restaurants)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
public interface RestaurantsService{
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param restaurantId 主键
     * @return 实例对象
     */
    Restaurants queryById(Integer restaurantId);
    
    /**
     * 分页查询
     *
     * @param restaurants 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Restaurants> paginQuery(Restaurants restaurants, long current, long size);
    /** 
     * 新增数据
     *
     * @param restaurants 实例对象
     * @return 实例对象
     */
    Restaurants insert(Restaurants restaurants);
    /** 
     * 更新数据
     *
     * @param restaurants 实例对象
     * @return 实例对象
     */
    Restaurants update(Restaurants restaurants);
    /** 
     * 通过主键删除数据
     *
     * @param restaurantId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer restaurantId);
}