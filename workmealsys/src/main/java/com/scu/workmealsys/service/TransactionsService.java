package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.entity.Transactions;

 /**
 * ;(transactions)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
public interface TransactionsService{
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param transactionId 主键
     * @return 实例对象
     */
    Transactions queryById(Integer transactionId);
    
    /**
     * 分页查询
     *
     * @param transactions 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Transactions> paginQuery(Transactions transactions, long current, long size);
    /** 
     * 新增数据
     *
     * @param transactions 实例对象
     * @return 实例对象
     */
    Transactions insert(Transactions transactions);
    /** 
     * 更新数据
     *
     * @param transactions 实例对象
     * @return 实例对象
     */
    Transactions update(Transactions transactions);
    /** 
     * 通过主键删除数据
     *
     * @param transactionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer transactionId);
}