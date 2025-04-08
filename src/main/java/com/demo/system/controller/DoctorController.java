package com.demo.system.controller;

import com.demo.system.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.demo.system.entity.Doctor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.demo.system.dao.DoctorDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 医生表
 */
@RestController
@RequestMapping("doctor")
@Api(tags = "医生表")
public class DoctorController {
    /**
     * 对象
     */
    @Resource
    private DoctorDao doctorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询单条数据")//医生详情
    @PostMapping("getone")
    public AjaxResult getone(Integer id) {
        return AjaxResult.success(doctorService.queryById(id));
    }

    /**
     * 查询列表数据
     *
     * @return 列表数据
     */
    @ApiOperation(value = "查询列表数据")//首页显示医生，医生分类显示，
    @RequestMapping(value = "getlist", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getlist(@RequestBody Doctor doctor) {
        PageHelper.startPage(doctor.getOffset(), doctor.getLimit());
        List<Map<String, Object>> list = doctorService.queryAll(doctor);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);//封装查询数据
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
        Integer row = doctorService.deleteById(id);
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
    public AjaxResult save(@RequestBody Doctor doctor) {
        Integer row = 0;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        doctor.setTime(sdf.format(d));
        if (doctor.getId() == null) {
            row = doctorService.insert(doctor);
        } else {
            row = doctorService.update(doctor);
        }
        return row > 0 ? AjaxResult.success() : AjaxResult.fail();
    }

}
