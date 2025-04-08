package com.demo.system.controller;

import com.demo.system.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.demo.system.entity.Admin;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.demo.system.dao.AdminDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 管理员表
 */
@RestController
@RequestMapping("admin")
@Api(tags = "管理员表")
public class AdminController {
    /**
     * 对象
     */
    @Resource
    private AdminDao adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询单条数据")
    @PostMapping("getone")
    public AjaxResult getone(Integer id) {
        return AjaxResult.success(adminService.queryById(id));
    }

    /**
     * 查询列表数据
     *
     * @return 列表数据
     */
    @ApiOperation(value = "查询列表数据")
    @RequestMapping(value = "getlist", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getlist(@RequestBody Admin admin) {
        PageHelper.startPage(admin.getOffset(), admin.getLimit());
        List<Map<String, Object>> list = adminService.queryAll(admin);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 删除
     *
     * @return 是否成功
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("del")
    public AjaxResult del(Integer id) {
        Integer row = adminService.deleteById(id);
        return row > 0 ? AjaxResult.success() : AjaxResult.fail();
    }

    /**
     * 保存
     *
     * @return 是否成功
     */
    @ApiOperation(value = "保存数据")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@RequestBody Admin admin) {
        Integer row = 0;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        admin.setTime(sdf.format(d));
        if (admin.getId() == null) {
            row = adminService.insert(admin);
        } else {
            row = adminService.update(admin);
        }
        return row > 0 ? AjaxResult.success() : AjaxResult.fail();
    }

}
