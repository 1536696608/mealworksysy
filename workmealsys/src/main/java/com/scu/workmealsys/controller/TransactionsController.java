package com.scu.workmealsys.controller;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Transactions;
import com.scu.workmealsys.service.TransactionsService;

 /**
 * ;(transactions)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/transactions")
public class TransactionsController{
    @Autowired
    private TransactionsService transactionsService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param transactionId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{transactionid}")
    public ResponseEntity<Transactions> queryById(Integer transactionId){
        return ResponseEntity.ok(transactionsService.queryById(transactionId));
    }
    
    /** 
     * 分页查询
     *
     * @param transactions 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<PageImpl<Transactions>> paginQuery(Transactions transactions, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Transactions> pageResult = transactionsService.paginQuery(transactions, current,size);
        //3. 分页结果组装
        List<Transactions> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Transactions> retPage = new PageImpl<Transactions>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
    }
    
    /** 
     * 新增数据
     *
     * @param transactions 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Transactions> add(Transactions transactions){
        return ResponseEntity.ok(transactionsService.insert(transactions));
    }
    
    /** 
     * 更新数据
     *
     * @param transactions 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Transactions> edit(Transactions transactions){
        return ResponseEntity.ok(transactionsService.update(transactions));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param transactionId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer transactionId){
        return ResponseEntity.ok(transactionsService.deleteById(transactionId));
    }
}