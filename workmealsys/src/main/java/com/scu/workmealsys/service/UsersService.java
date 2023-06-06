package com.scu.workmealsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scu.workmealsys.dto.Result;
import com.scu.workmealsys.entity.Users;
import jakarta.servlet.http.HttpSession;

/**
 * ;(users)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
public interface UsersService{
    //是否登录
     Result<Users> isLogin(HttpSession session);
     /**
      * 用户注册
      *
      * @param user 用户对象
      * @return 注册结果
      */
     Result<Users> register(Users user,Integer workId);

     /**
      * 用户登录
      *
      * @param user 用户对象
      * @return 登录结果
      */
     Result<Users> login(Users user);


    /** 
     * 通过ID查询单条数据 
     *
     * @param userId 主键
     * @return 实例对象
     */
    Users queryById(Integer userId);
    
    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Users> paginQuery(Users users, long current, long size);
    int updateById(Users users);
    /** 
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */

    Users insert(Users users);
    /** 
     * 更新数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);
    /** 
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);
}