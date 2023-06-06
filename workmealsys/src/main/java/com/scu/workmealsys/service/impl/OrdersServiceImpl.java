package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.scu.workmealsys.dto.OrderReqDto;
import com.scu.workmealsys.entity.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Orders;
import com.scu.workmealsys.mapper.OrdersMapper;
import com.scu.workmealsys.service.OrdersService;

import java.util.List;

/**
 * ;(orders)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersMapper ordersMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param orderId 主键
     * @return 实例对象
     */
    public Orders queryById(Integer orderId){
        return ordersMapper.selectById(orderId);
    }
    
    /**
     * 分页查询
     *
     * @param orders 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Orders> paginQuery(Orders orders, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        if(orders.getUserId() != null){
            queryWrapper.eq(Orders::getUserId, orders.getUserId());
        }
        if(orders.getUserOrder() != null){
            queryWrapper.eq(Orders::getUserOrder, orders.getUserOrder());
        }
        //2. 执行分页查询
        Page<Orders> pagin = new Page<>(current , size , true);
        IPage<Orders> selectResult = ordersMapper.selectPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    public Orders insert(Orders orders){
        ordersMapper.insert(orders);
        return orders;
    }
    
    /** 
     * 更新数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    public Orders update(Orders orders){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Orders> chainWrapper = new LambdaUpdateChainWrapper<Orders>(ordersMapper);
        //2. 设置主键，并更新
        chainWrapper.set(Orders::getOrderId, orders.getOrderId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(orders.getOrderId());
        }else{
            return orders;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer orderId){
        int total = ordersMapper.deleteById(orderId);
        return total > 0;
    }

    public int addOrder(List<OrderReqDto> orders){
        return 1;
    }
}