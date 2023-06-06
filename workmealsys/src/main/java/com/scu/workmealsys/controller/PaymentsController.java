package com.scu.workmealsys.controller;

import java.util.List;

import com.scu.workmealsys.dto.PaymentsReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Payments;
import com.scu.workmealsys.service.PaymentsService;

 /**
 * ;(payments)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/payments")
public class PaymentsController{
    @Autowired
    private PaymentsService paymentsService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param paymentId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{paymentid}")
    public ResponseEntity<Payments> queryById(Long paymentId){
        return ResponseEntity.ok(paymentsService.queryById(paymentId));
    }

     @ApiOperation("分页查询")
     @PostMapping("/mine")
     public ResponseEntity<PageImpl<Payments>> getPayments(@RequestBody PaymentsReqDto dto){
         //1.分页参数
         long current = dto.getCurrent();
         long size = dto.getSize();
         Payments payment = new Payments();
         payment.setUserId(Long.valueOf(dto.getUserId()) );
         //2.分页查询
         /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
         com.baomidou.mybatisplus.extension.plugins.pagination.Page<Payments> pageResult = paymentsService.paginQuery(payment, current,size);
         //3. 分页结果组装
         List<Payments> dataList = pageResult.getRecords();
         long total = pageResult.getTotal();
         PageImpl<Payments> retPage = new PageImpl<Payments>(dataList);
         return ResponseEntity.ok(retPage);
     }
    
    /** 
     * 分页查询
     *
     * @param payments 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<PageImpl<Payments>> paginQuery(Payments payments, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Payments> pageResult = paymentsService.paginQuery(payments, current,size);
        //3. 分页结果组装
        List<Payments> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Payments> retPage = new PageImpl<Payments>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
    }
    
    /** 
     * 新增数据
     *
     * @param payments 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Payments> add(Payments payments){
        return ResponseEntity.ok(paymentsService.insert(payments));
    }
    
    /** 
     * 更新数据
     *
     * @param payments 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Payments> edit(Payments payments){
        return ResponseEntity.ok(paymentsService.update(payments));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param paymentId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer paymentId){
        return ResponseEntity.ok(paymentsService.deleteById(paymentId));
    }
}