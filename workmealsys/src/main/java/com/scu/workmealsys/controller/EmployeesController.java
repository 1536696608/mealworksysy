package com.scu.workmealsys.controller;

import java.util.List;

import com.scu.workmealsys.dto.EmployeePageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.calcite.linq4j.function.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Employees;
import com.scu.workmealsys.service.EmployeesService;

 /**
 * ;(employees)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/employees")
public class EmployeesController{
    @Autowired
    private EmployeesService employeesService;
//     @GetMapping("/id/{employeeId1}")
//     public String queryById1(Integer employeeId1){
//
//         return "OK";
//     }
    /** 
     * 通过ID查询单条数据 
     *
     * @param employeeId 主键
     * @return 实例对象
     */

    @ApiOperation("通过ID查询单条数据")
    @GetMapping("/id/{employeeId}")
    public ResponseEntity<Employees> queryById(@PathVariable("employeeId") Integer employeeId){
        System.out.println(employeeId);
        return ResponseEntity.ok(employeesService.queryById(employeeId));
    }
    
    /** 
     * 分页查询
     *
//     * @param employees 筛选条件
//     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping ("/page")
    public ResponseEntity<PageImpl<Employees>> paginQuery(@RequestBody EmployeePageDto qury){
        System.out.println(qury.getPage());


        PageRequest pageRequest = PageRequest.of(qury.getPage(), 5);
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
//        long current = 1;
//        long size = 1;
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Employees> pageResult = employeesService.paginQuery(qury.getQuery(), current,size);
        //3. 分页结果组装
        List<Employees> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
//        PageImpl<Employees> retPage = new PageImpl<Employees>(dataList,pageRequest,total);
        PageImpl<Employees> retPage = new PageImpl<Employees>(dataList);
        return ResponseEntity.ok(retPage);
    }
    
    /** 
     * 新增数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping("/update")
    public ResponseEntity<Employees> add(@RequestBody Employees employees){
        System.out.println(employees.getEmployeeId());
        return ResponseEntity.ok(employeesService.insert(employees));
    }
    
    /** 
     * 更新数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Employees> edit(Employees employees){
        return ResponseEntity.ok(employeesService.update(employees));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer employeeId){
        return ResponseEntity.ok(employeesService.deleteById(employeeId));
    }
}