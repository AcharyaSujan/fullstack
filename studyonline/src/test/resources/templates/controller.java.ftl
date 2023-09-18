package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${g.basePackage}.models.${entity};
import ${g.basePackage}.models.model.R;
import ${g.basePackage}.service.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
* description: ${table.comment!} 前端控制器
* author: ${author}
* date ${date}
* version: 1.0
*/

@RestController
@RequestMapping("/admin/${table.entityPath}")
@Api(tags = "${table.entityPath}-${table.comment!}管理", description = "提供${table.comment!}相关的 Rest API")
public class ${entity}Controller {

    @Resource
    private ${entity}Service ${table.entityPath}Service;

    @PostMapping("/add")
    @ApiOperation("新增${table.comment!}")
    public R add(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.save(${table.entityPath});
        return R.ok().message("添加成功!");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除${table.comment!}")
    public R delete(@PathVariable("id") int id) {
        ${table.entityPath}Service.removeById(id);
        return R.ok().message("删除成功!");
    }

    @PutMapping("/update")
    @ApiOperation("更新${table.comment!}")
    public R update(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.updateById(${table.entityPath});
        return R.ok().message("修改成功！");
    }

    @GetMapping("/find/{id}")
    @ApiOperation("根据Id查询${table.comment!}")
    @ApiImplicitParams(value = {
    @ApiImplicitParam(name = "id",value = "查询时候需要用到的 id",required = true),
    })
    public R findById(@PathVariable("id")Integer id) {
        ${entity} ${table.entityPath} = ${table.entityPath}Service.getById(id);
        return R.ok().data("${table.entityPath}",${table.entityPath});
    }


    @ApiOperation("获取${table.entityPath}分页对象")
    @ApiImplicitParams(value = {
    @ApiImplicitParam(name = "pageIndex",value = "当前页",required = true),
    @ApiImplicitParam(name = "pageSize",value = "每页显示条数",required = true),
    })
    @GetMapping("/page/{pageIndex}/{pageSize}")
    public R queryPage(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("pageSize")Integer pageSize){
        Page<${entity}> page = new Page<>(pageIndex,pageSize);
        return R.ok().data("page",${table.entityPath}Service.page(page));
    }


    @ApiOperation("获取${table.entityPath}列表")
    @GetMapping("/list")
    public R list(){
        return R.ok().data("${table.entityPath}List",${table.entityPath}Service.list());
    }

}