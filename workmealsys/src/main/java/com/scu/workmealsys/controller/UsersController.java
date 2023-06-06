package com.scu.workmealsys.controller;

import java.util.List;

import com.scu.workmealsys.dto.RegisterReqDto;
import com.scu.workmealsys.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scu.workmealsys.entity.Users;
import com.scu.workmealsys.service.UsersService;

 /**
 * ;(users)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-5-17
 */
@Api(tags = "对象功能接口")
@RestController
@RequestMapping("/users")
public class UsersController{
    public static final String SESSION_NAME = "userInfo";
    @Autowired
    private UsersService usersService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param userId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{userid}")
    public ResponseEntity<Users> queryById(Integer userId){
        return ResponseEntity.ok(usersService.queryById(userId));
    }
    
    /** 
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<PageImpl<Users>> paginQuery(Users users, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Users> pageResult = usersService.paginQuery(users, current,size);
        //3. 分页结果组装
        List<Users> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Users> retPage = new PageImpl<Users>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
    }
     @ApiOperation("注册")
     @PostMapping("/register")
     public Result<Users> register(@RequestBody RegisterReqDto reg,HttpServletRequest request){
        Users users = new Users();
        users.setUserId(reg.getUserId());
        users.setPassword(reg.getPassword());
        users.setEmail(reg.getEmail());
        System.out.println(reg.toString());
        Result<Users> result =  usersService.register(users,reg.getWorkId());
        if(result.isSuccess()){
            request.getSession();
        }
        return result;
     }

     @ApiOperation("登录")
     @PostMapping("/login")
     public Result<Users> login(@RequestBody Users users, HttpServletRequest request){
        System.out.println(users.getUserId());
         Result<Users> result =  usersService.login(users);
         if (result.isSuccess()) {
             request.getSession().setAttribute(SESSION_NAME, result.getData());
         }
         System.out.println(result.isSuccess());
         return result;
     }

    /** 
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Users> add(Users users){
        return ResponseEntity.ok(usersService.insert(users));
    }
    
    /** 
     * 更新数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping("/update")
    public ResponseEntity<Integer> edit(@RequestBody Users users){
        return ResponseEntity.ok(usersService.updateById(users));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer userId){
        return ResponseEntity.ok(usersService.deleteById(userId));
    }
}