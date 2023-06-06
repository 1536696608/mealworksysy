package com.scu.workmealsys.controller;

import java.util.List;

import com.scu.workmealsys.dto.OrderPageReqDto;
import com.scu.workmealsys.dto.OrderReqDto;
import com.scu.workmealsys.entity.Payments;
import com.scu.workmealsys.service.PaymentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Orders;
import com.scu.workmealsys.service.OrdersService;

 /**
 * ;(orders)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-23
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/orders")
public class OrdersController{
    @Autowired
    private PaymentsService paymentsService;
    @Autowired
    private OrdersService ordersService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{orderid}")
    public ResponseEntity<Orders> queryById(Integer orderId){
        return ResponseEntity.ok(ordersService.queryById(orderId));
    }
     @ApiOperation("通过用户名和订单号获取详情")
     @PostMapping("/mine")
     public ResponseEntity<PageImpl<Orders>> getOrders(@RequestBody OrderPageReqDto dto){
         //1.分页参数
         long current =dto.getCurrent();
         long size = dto.getSize();
         Orders orders = new Orders();
         orders.setUserOrder(dto.getPayId());
         orders.setUserId(dto.getUserId());
         //2.分页查询
         /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
         com.baomidou.mybatisplus.extension.plugins.pagination.Page<Orders> pageResult = ordersService.paginQuery(orders, current,size);
         //3. 分页结果组装
         List<Orders> dataList = pageResult.getRecords();
         long total = pageResult.getTotal();
         PageImpl<Orders> retPage = new PageImpl<Orders>(dataList);
         return ResponseEntity.ok(retPage);
     }
    /** 
     * 分页查询
     *
     * @param orders 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<PageImpl<Orders>> paginQuery(Orders orders, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Orders> pageResult = ordersService.paginQuery(orders, current,size);
        //3. 分页结果组装
        List<Orders> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Orders> retPage = new PageImpl<Orders>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
    }
    
    /** 
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Orders> add(Orders orders){
        return ResponseEntity.ok(ordersService.insert(orders));
    }
    
    /** 
     * 更新数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Orders> edit(Orders orders){
        return ResponseEntity.ok(ordersService.update(orders));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer orderId){
        return ResponseEntity.ok(ordersService.deleteById(orderId));
    }

     @ApiOperation("添加订单")
     @PostMapping("/add")
     public int addOrderDto(@RequestBody List<OrderReqDto> orderDtos){
//        Orders span = new Orders();
//        ordersService.insert(order);
        Payments payment = new Payments();
        double total_price = 0;
        String order_user = orderDtos.get(0).getUser_order();
        Integer userId = orderDtos.get(0).getUserId();
        payment.setUserOrder(order_user);
        for(int i = 0;i < orderDtos.size();i++){
            Orders order = new Orders();
            order.setUserId(orderDtos.get(i).getUserId());
            order.setMenuId(orderDtos.get(i).getMenuId());
            order.setRestaurantId(orderDtos.get(i).getRestaurantId());
            order.setUserOrder(orderDtos.get(i).getUser_order());
            order.setQuantity(orderDtos.get(i).getQuantity());
            order.setPrice(orderDtos.get(i).getPrice());
            total_price += orderDtos.get(i).getPrice();
            System.out.println(orderDtos.get(i).getUser_order());
            ordersService.insert(order);
         }
//        payment.setPaymentId(100000L);
        payment.setAmount(total_price);
        payment.setUserId(Long.valueOf(userId));
        payment.setComplete(0);
        paymentsService.insert(payment);
        return  1;
     }
}