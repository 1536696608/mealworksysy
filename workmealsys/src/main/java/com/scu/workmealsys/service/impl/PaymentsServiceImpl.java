package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Payments;
import com.scu.workmealsys.mapper.PaymentsMapper;
import com.scu.workmealsys.service.PaymentsService;
 /**
 * ;(payments)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
@Service
public class PaymentsServiceImpl implements PaymentsService{
    @Autowired
    private PaymentsMapper paymentsMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param paymentId 主键
     * @return 实例对象
     */
    public Payments queryById(Long paymentId){
        return paymentsMapper.selectById(paymentId);
    }
    
    /**
     * 分页查询
     *
     * @param payments 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Payments> paginQuery(Payments payments, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Payments> queryWrapper = new LambdaQueryWrapper<>();
        if(payments.getUserId() != null){
            queryWrapper.eq(Payments::getUserId,payments.getUserId());
        }
        //2. 执行分页查询
        Page<Payments> pagin = new Page<>(current , size , true);
        IPage<Payments> selectResult = paymentsMapper.selectPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param payments 实例对象
     * @return 实例对象
     */
    public Payments insert(Payments payments){
        paymentsMapper.insert(payments);
        return payments;
    }
    
    /** 
     * 更新数据
     *
     * @param payments 实例对象
     * @return 实例对象
     */
    public Payments update(Payments payments){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Payments> chainWrapper = new LambdaUpdateChainWrapper<Payments>(paymentsMapper);
        //2. 设置主键，并更新
        chainWrapper.set(Payments::getPaymentId, payments.getPaymentId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(payments.getPaymentId());
        }else{
            return payments;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param paymentId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer paymentId){
        int total = paymentsMapper.deleteById(paymentId);
        return total > 0;
    }
}