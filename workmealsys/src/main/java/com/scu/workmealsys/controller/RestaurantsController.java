package com.scu.workmealsys.controller;

import java.util.List;

import com.scu.workmealsys.dto.MenuPageDto;
import com.scu.workmealsys.dto.RestaurantPageDto;
import com.scu.workmealsys.entity.Menus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Restaurants;
import com.scu.workmealsys.service.RestaurantsService;

 /**
 * ;(restaurants)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/restaurants")
public class RestaurantsController{
    @Autowired
    private RestaurantsService restaurantsService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param restaurantId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{restaurantid}")
    public ResponseEntity<Restaurants> queryById(Integer restaurantId){
        return ResponseEntity.ok(restaurantsService.queryById(restaurantId));
    }

     @ApiOperation("分页查询")
     @PostMapping ("/reslist")
     public ResponseEntity<PageImpl<Restaurants>> paginQuery(@RequestBody RestaurantPageDto qury, HttpServletRequest request){
         System.out.println(request.getSession());


         PageRequest pageRequest = PageRequest.of(qury.getPage(), qury.getSize());
         //1.分页参数
         long current = pageRequest.getPageNumber();
         long size = pageRequest.getPageSize();
//        long current = 1;
//        long size = 1;
         //2.分页查询
         /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
         com.baomidou.mybatisplus.extension.plugins.pagination.Page<Restaurants> pageResult = restaurantsService.paginQuery(qury.getRestaurants(), current,size);
         //3. 分页结果组装
         List<Restaurants> dataList = pageResult.getRecords();
         long total = pageResult.getTotal();
         PageImpl<Restaurants> retPage = new PageImpl<Restaurants>(dataList);
         return ResponseEntity.ok(retPage);
     }
    /** 
     * 分页查询
     *
     * @param restaurants 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<PageImpl<Restaurants>> paginQuer(Restaurants restaurants, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Restaurants> pageResult = restaurantsService.paginQuery(restaurants, current,size);
        //3. 分页结果组装
        List<Restaurants> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Restaurants> retPage = new PageImpl<Restaurants>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
    }
    
    /** 
     * 新增数据
     *
     * @param restaurants 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Restaurants> add(Restaurants restaurants){
        return ResponseEntity.ok(restaurantsService.insert(restaurants));
    }
    
    /** 
     * 更新数据
     *
     * @param restaurants 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Restaurants> edit(Restaurants restaurants){
        return ResponseEntity.ok(restaurantsService.update(restaurants));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param restaurantId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer restaurantId){
        return ResponseEntity.ok(restaurantsService.deleteById(restaurantId));
    }
}