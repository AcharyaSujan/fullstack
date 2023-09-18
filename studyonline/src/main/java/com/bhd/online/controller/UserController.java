package com.bhd.online.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bhd.online.models.entity.User;
import com.bhd.online.models.model.LoginException;
import com.bhd.online.models.model.R;
import com.bhd.online.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: UserController
 * author: DaTao
 * email: jixu65@sina.com
 * date 2023-09-11 14:07
 * version: 1.0
 */
@RestController
@Api(tags = "user-用户管理", description = "提供用户相关的 Rest API")
public class UserController {

    @Resource
    private UserService userService;

    @PutMapping("/add")
    @ApiOperation("无参数添加用户...")
    public R add(User user){
        userService.save(user);
        return R.ok().message("success");
    }

    @PutMapping("/delete")
    @ApiOperation("根据id删除用户...")
    public R delete(Integer id){
        userService.removeById(id);
        return R.ok().message("success");
    }


    @PutMapping("/update")
    @ApiOperation("修改用户信息...")
    public R update(User user){

        userService.updateById(user);
        return R.ok().message("success");
    }


    @GetMapping("/list")
    @ApiOperation("查询所有数据...")
    public R list(){

        return R.ok().data(userService.list());
    }

    @GetMapping("/page")
    @ApiOperation("分页查询...")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "current",value = "当前页",required = true),
            @ApiImplicitParam(name = "size",value = "每页显示条数",required = true),
    })
    public R page(Integer current, Integer size){
        //age > 20
        Page<User> page = new Page<User>(1,4);
        //查询条件
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
//                .gt("age",20)
//                .like("name","%明%");

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .gt(User::getAge,17)
                .like(User::getName,"%明%");

        Page<User> data = userService.page(page, lambdaQueryWrapper);

        return R.ok().data(data);
    }


}
