package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.entity.Payments;

 /**
 * ;(payments)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
public interface PaymentsService{
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param paymentId 主键
     * @return 实例对象
     */
    Payments queryById(Long paymentId);
    
    /**
     * 分页查询
     *
     * @param payments 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Payments> paginQuery(Payments payments, long current, long size);
    /** 
     * 新增数据
     *
     * @param payments 实例对象
     * @return 实例对象
     */
    Payments insert(Payments payments);
    /** 
     * 更新数据
     *
     * @param payments 实例对象
     * @return 实例对象
     */
    Payments update(Payments payments);
    /** 
     * 通过主键删除数据
     *
     * @param paymentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer paymentId);
}