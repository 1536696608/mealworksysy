package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.dto.OrderReqDto;
import com.scu.workmealsys.entity.Orders;

import java.util.List;

/**
 * ;(orders)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
public interface OrdersService{
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Orders queryById(Integer orderId);
    
    /**
     * 分页查询
     *
     * @param orders 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Orders> paginQuery(Orders orders, long current, long size);
    /** 
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders insert(Orders orders);
    /** 
     * 更新数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders update(Orders orders);
    /** 
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderId);

    int addOrder(List<OrderReqDto> orders);
}