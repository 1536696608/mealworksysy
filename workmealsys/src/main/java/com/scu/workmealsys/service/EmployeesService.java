package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.entity.Employees;

 /**
 * ;(employees)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
public interface EmployeesService{
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employees queryById(Integer employeeId);
    
    /**
     * 分页查询
     *
     * @param employees 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Employees> paginQuery(Employees employees, long current, long size);
    /** 
     * 新增数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    Employees insert(Employees employees);
    /** 
     * 更新数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    Employees update(Employees employees);
    /** 
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);
}