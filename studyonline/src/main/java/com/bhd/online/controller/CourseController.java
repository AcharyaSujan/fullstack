package com.bhd.online.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bhd.online.models.entity.Course;
import com.bhd.online.models.model.R;
import com.bhd.online.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



@RestController
@RequestMapping("/course")
@Api(tags = "course-management", description = "provide related Rest API")
public class CourseController {

    @Resource
    private CourseService courseService;

    @PostMapping("/add")
    @ApiOperation("Add")
    public R add(@RequestBody Course course) {
        courseService.save(course);
        return R.ok().message("sucess add");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete")
    public R delete(@PathVariable("id") int id) {
        courseService.removeById(id);
        return R.ok().message("sucess delete!");
    }

    @PutMapping("/update")
    @ApiOperation("Update")
    public R update(@RequestBody Course course) {
        courseService.updateById(course);
        return R.ok().message("update sucess！");
    }

    @GetMapping("/find/{id}")
    @ApiOperation("data Id search")
    @ApiImplicitParams(value = {
    @ApiImplicitParam(name = "id",value = "search need id",required = true),
    })
    public R findById(@PathVariable("id")Integer id) {
        Course course = courseService.getById(id);
        return R.ok().data("course",course);
    }


    @ApiOperation("get course page object")
    @ApiImplicitParams(value = {
    @ApiImplicitParam(name = "pageIndex",value = "current page",required = true),
    @ApiImplicitParam(name = "pageSize",value = "mei ye xianshi tiaoshu",required = true),
    })
    @GetMapping("/page/{pageIndex}/{pageSize}")
    public R queryPage(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("pageSize")Integer pageSize){
        Page<Course> page = new Page<>(pageIndex,pageSize);
        return R.ok().data("page",courseService.page(page));
    }


    @ApiOperation("get course table")
    @GetMapping("/list")
    public R list(){
        return R.ok().data("courseList",courseService.list());
    }

}