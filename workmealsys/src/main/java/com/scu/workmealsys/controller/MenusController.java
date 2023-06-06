package com.scu.workmealsys.controller;

import java.util.List;

import com.scu.workmealsys.dto.EmployeePageDto;
import com.scu.workmealsys.dto.MenuPageDto;
import com.scu.workmealsys.entity.Employees;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Menus;
import com.scu.workmealsys.service.MenusService;

 /**
 * ;(menus)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/menus")
public class MenusController{
    @Autowired
    private MenusService menusService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param menuId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{menuid}")
    public ResponseEntity<Menus> queryById(Integer menuId){
        return ResponseEntity.ok(menusService.queryById(menuId));
    }
     @ApiOperation("分页查询")
     @PostMapping ("/recomment")
     public ResponseEntity<PageImpl<Menus>> paginQuery(@RequestBody MenuPageDto qury){
         System.out.println(qury.getMenus().getMenuId());


         PageRequest pageRequest = PageRequest.of(qury.getPage(), qury.getSize());
         //1.分页参数
         long current = pageRequest.getPageNumber();
         long size = pageRequest.getPageSize();
//        long current = 1;
//        long size = 1;
         //2.分页查询
         /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
         com.baomidou.mybatisplus.extension.plugins.pagination.Page<Menus> pageResult = menusService.paginQuery(qury.getMenus(), current,size);
         //3. 分页结果组装
         List<Menus> dataList = pageResult.getRecords();
         long total = pageResult.getTotal();
//        PageImpl<Employees> retPage = new PageImpl<Employees>(dataList,pageRequest,total);
         PageImpl<Menus> retPage = new PageImpl<Menus>(dataList);
         return ResponseEntity.ok(retPage);
     }
    /** 
     * 分页查询
     *
     * @param menus 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<PageImpl<Menus>> paginQuery(Menus menus, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Menus> pageResult = menusService.paginQuery(menus, current,size);
        //3. 分页结果组装
        List<Menus> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Menus> retPage = new PageImpl<Menus>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
    }
    
    /** 
     * 新增数据
     *
     * @param menus 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Menus> add(Menus menus){
        return ResponseEntity.ok(menusService.insert(menus));
    }
    
    /** 
     * 更新数据
     *
     * @param menus 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Menus> edit(Menus menus){
        return ResponseEntity.ok(menusService.update(menus));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer menuId){
        return ResponseEntity.ok(menusService.deleteById(menuId));
    }
}