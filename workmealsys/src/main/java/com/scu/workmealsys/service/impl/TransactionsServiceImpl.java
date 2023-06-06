package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Transactions;
import com.scu.workmealsys.mapper.TransactionsMapper;
import com.scu.workmealsys.service.TransactionsService;
 /**
 * ;(transactions)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
@Service
public class TransactionsServiceImpl implements TransactionsService{
    @Autowired
    private TransactionsMapper transactionsMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param transactionId 主键
     * @return 实例对象
     */
    public Transactions queryById(Integer transactionId){
        return transactionsMapper.selectById(transactionId);
    }
    
    /**
     * 分页查询
     *
     * @param transactions 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Transactions> paginQuery(Transactions transactions, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Transactions> queryWrapper = new LambdaQueryWrapper<>();
        //2. 执行分页查询
        Page<Transactions> pagin = new Page<>(current , size , true);
        IPage<Transactions> selectResult = transactionsMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param transactions 实例对象
     * @return 实例对象
     */
    public Transactions insert(Transactions transactions){
        transactionsMapper.insert(transactions);
        return transactions;
    }
    
    /** 
     * 更新数据
     *
     * @param transactions 实例对象
     * @return 实例对象
     */
    public Transactions update(Transactions transactions){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Transactions> chainWrapper = new LambdaUpdateChainWrapper<Transactions>(transactionsMapper);
        //2. 设置主键，并更新
        chainWrapper.set(Transactions::getTransactionId, transactions.getTransactionId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(transactions.getTransactionId());
        }else{
            return transactions;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param transactionId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer transactionId){
        int total = transactionsMapper.deleteById(transactionId);
        return total > 0;
    }
}