package com.scu.workmealsys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.scu.workmealsys.controller.UsersController;
import com.scu.workmealsys.dto.Result;
import com.scu.workmealsys.entity.Employees;
import com.scu.workmealsys.mapper.EmployeesMapper;
import com.scu.workmealsys.service.EmployeesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.scu.workmealsys.entity.Users;
import com.scu.workmealsys.mapper.UsersMapper;
import com.scu.workmealsys.service.UsersService;
 /**
 * ;(users)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private EmployeesMapper employeesMapper;
    /** 
     * 通过ID查询单条数据 
     *
     * @param userId 主键
     * @return 实例对象
     */
    public Users queryById(Integer userId){
        return usersMapper.selectById(userId);
    }
     /**
      * 用户注册
      *
      * @param user 用户对象
      * @return 注册结果
      */
     public Result<Users> register(Users user,Integer workId){
         Result<Users> result = new Result<>();
         Employees employees = employeesMapper.selectById(workId);
         System.out.println(workId);
         if(employees == null){
             result.setResultFailed("工号错误！");
            return result;
         }
         user.setUsername(employees.getName());
         Users isuser = usersMapper.selectById(user.getUserId());
         if(isuser != null){
             result.setResultFailed("该用户名已存在！");
             return result;
         }
         usersMapper.insert(user);
         result.setResultSuccess("注册用户成功！", user);
         return result;
     }

     /**
      * 用户登录
      *
      * @param user 用户对象
      * @return 登录结果
      */
     public Result<Users> login(Users user){
         Result<Users> result = new Result<>();
         Users isuser = usersMapper.selectById(user.getUserId());
         if(isuser == null){
             result.setResultFailed("该用户名不存在！");
             return result;
         }
         else if(!user.getPassword().equals(isuser.getPassword())){
             result.setResultFailed("用户名或者密码错误");
             return result;
         }
         result.setResultSuccess("登录用户成功！", isuser);
         return result;
     }
     //是否登录
     public Result<Users> isLogin(HttpSession session){
         Result<Users> result = new Result<>();
         Users us = (Users) session.getAttribute(UsersController.SESSION_NAME);
         if(us == null){
             result.setResultFailed("用户未登录！");
             return result;
         }
         // 登录了则去数据库取出信息进行比对
         Users getUser = usersMapper.selectById(us.getUserId());
         // 如果session用户找不到对应的数据库中的用户或者找出的用户密码和session中用户不一致则说明session中用户信息无效
         if (getUser == null || !getUser.getPassword().equals(us.getPassword())) {
             result.setResultFailed("用户信息无效！");
             return result;
         }
         result.setResultSuccess("用户已登录！", getUser);
         return result;
     }
    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Users> paginQuery(Users users, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(users.getUsername())){
            queryWrapper.eq(Users::getUsername, users.getUsername());
        }
        if(StrUtil.isNotBlank(users.getPassword())){
            queryWrapper.eq(Users::getPassword, users.getPassword());
        }
        if(StrUtil.isNotBlank(users.getEmail())){
            queryWrapper.eq(Users::getEmail, users.getEmail());
        }
        //2. 执行分页查询
        Page<Users> pagin = new Page<>(current , size , true);
        IPage<Users> selectResult = usersMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    public Users insert(Users users){
        usersMapper.insert(users);
        return users;
    }

    /** 
     * 更新数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    public Users update(Users users){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Users> chainWrapper = new LambdaUpdateChainWrapper<Users>(usersMapper);
        if(StrUtil.isNotBlank(users.getUsername())){
            chainWrapper.eq(Users::getUsername, users.getUsername());
        }
        if(StrUtil.isNotBlank(users.getPassword())){
            chainWrapper.eq(Users::getPassword, users.getPassword());
        }
        if(StrUtil.isNotBlank(users.getEmail())){
            chainWrapper.eq(Users::getEmail, users.getEmail());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Users::getUserId, users.getUserId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(users.getUserId());
        }else{
            return users;
        }
    }
    public int updateById(Users users){
        return usersMapper.updateById(users);
     }
    /** 
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer userId){
        int total = usersMapper.deleteById(userId);
        return total > 0;
    }
}