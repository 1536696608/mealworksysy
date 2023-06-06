package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.entity.Menus;

 /**
 * ;(menus)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
public interface MenusService{
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param menuId 主键
     * @return 实例对象
     */
    Menus queryById(Integer menuId);
    
    /**
     * 分页查询
     *
     * @param menus 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Menus> paginQuery(Menus menus, long current, long size);
    /** 
     * 新增数据
     *
     * @param menus 实例对象
     * @return 实例对象
     */
    Menus insert(Menus menus);
    /** 
     * 更新数据
     *
     * @param menus 实例对象
     * @return 实例对象
     */
    Menus update(Menus menus);
    /** 
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer menuId);
}