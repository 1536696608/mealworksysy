package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.benmanes.caffeine.cache.Cache;
import com.scu.workmealsys.cache.EmployeesCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Employees;
import com.scu.workmealsys.mapper.EmployeesMapper;
import com.scu.workmealsys.service.EmployeesService;
//import com.scu.workmealsys.cache.EmployeesCache;
import java.util.HashMap;

/**
 * ;(employees)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
@Service
public class EmployeesServiceImpl implements EmployeesService{
    private HashMap<Integer, Employees> userInfoMap = new HashMap<>();
    @Autowired
    private Cache<String, Object> employeesCache;
    @Autowired
    private EmployeesMapper employeesMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    public Employees queryById(Integer employeeId){
        //先查缓存
        employeesCache.getIfPresent(String.valueOf(employeeId));
        Employees employee = (Employees) employeesCache.asMap().get(String.valueOf(employeeId));
        if(employee != null){
            return employee;
        }
        //如果缓存没有
        Employees employee2 =  employeesMapper.selectById(employeeId);
        employeesCache.put(String.valueOf(employeeId),employee2);
        return employee2;
    }
    
    /**
     * 分页查询
     *
     * @param employees 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Employees> paginQuery(Employees employees, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Employees> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(employees.getName())){
            queryWrapper.eq(Employees::getName, employees.getName());
        }
        if(StrUtil.isNotBlank(employees.getDepartment())){
            queryWrapper.eq(Employees::getDepartment, employees.getDepartment());
        }
        if(StrUtil.isNotBlank(employees.getPosition())){
            queryWrapper.eq(Employees::getPosition, employees.getPosition());
        }
        //2. 执行分页查询
        Page<Employees> pagin = new Page<>(current , size , true);
        System.out.println(pagin.getPages());
        IPage<Employees> selectResult = employeesMapper.selectPage(pagin , queryWrapper);
        System.out.println(3);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    public Employees insert(Employees employees){
        employeesMapper.insert(employees);
        return employees;
    }
    
    /** 
     * 更新数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    public Employees update(Employees employees){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Employees> chainWrapper = new LambdaUpdateChainWrapper<Employees>(employeesMapper);
        if(StrUtil.isNotBlank(employees.getName())){
            chainWrapper.eq(Employees::getName, employees.getName());
        }
        if(StrUtil.isNotBlank(employees.getDepartment())){
            chainWrapper.eq(Employees::getDepartment, employees.getDepartment());
        }
        if(StrUtil.isNotBlank(employees.getPosition())){
            chainWrapper.eq(Employees::getPosition, employees.getPosition());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Employees::getEmployeeId, employees.getEmployeeId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(employees.getEmployeeId());
        }else{
            return employees;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer employeeId){
        int total = employeesMapper.deleteById(employeeId);
        return total > 0;
    }
}