package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Menus;
import com.scu.workmealsys.mapper.MenusMapper;
import com.scu.workmealsys.service.MenusService;
 /**
 * ;(menus)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-22
 */
@Service
public class MenusServiceImpl implements MenusService{
    @Autowired
    private MenusMapper menusMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param menuId 主键
     * @return 实例对象
     */
    public Menus queryById(Integer menuId){
        return menusMapper.selectById(menuId);
    }
    
    /**
     * 分页查询
     *
     * @param menus 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Menus> paginQuery(Menus menus, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Menus> queryWrapper = new LambdaQueryWrapper<>();
        if(menus.getMenuId() != null){
            queryWrapper.eq(Menus::getMenuId, menus.getMenuId());
        }
        if(menus.getRestaurantId() != null){
            queryWrapper.eq(Menus::getRestaurantId, menus.getRestaurantId());
        }
        if(StrUtil.isNotBlank(menus.getDishName())){
            queryWrapper.eq(Menus::getDishName, menus.getDishName());
        }
        if(StrUtil.isNotBlank(menus.getUrl())){
            queryWrapper.eq(Menus::getUrl, menus.getUrl());
        }
        //2. 执行分页查询
        Page<Menus> pagin = new Page<>(current , size , true);
        IPage<Menus> selectResult = menusMapper.selectPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param menus 实例对象
     * @return 实例对象
     */
    public Menus insert(Menus menus){
        menusMapper.insert(menus);
        return menus;
    }
    
    /** 
     * 更新数据
     *
     * @param menus 实例对象
     * @return 实例对象
     */
    public Menus update(Menus menus){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Menus> chainWrapper = new LambdaUpdateChainWrapper<Menus>(menusMapper);
        if(StrUtil.isNotBlank(menus.getDishName())){
            chainWrapper.eq(Menus::getDishName, menus.getDishName());
        }
        if(StrUtil.isNotBlank(menus.getUrl())){
            chainWrapper.eq(Menus::getUrl, menus.getUrl());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Menus::getMenuId, menus.getMenuId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(menus.getMenuId());
        }else{
            return menus;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer menuId){
        int total = menusMapper.deleteById(menuId);
        return total > 0;
    }
}