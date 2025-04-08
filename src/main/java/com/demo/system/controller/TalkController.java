package com.demo.system.controller;

import com.demo.system.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.demo.system.entity.Talk;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.demo.system.dao.TalkDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对话表
 */
@RestController
@RequestMapping("talk")
@Api(tags = "对话表")
public class TalkController {
    /**
     * 对象
     */
    @Resource
    private TalkDao talkService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询单条数据")
    @PostMapping("getone")
    public AjaxResult getone(Integer id) {
        return AjaxResult.success(talkService.queryById(id));
    }

    /**
     * 查询列表数据
     *
     * @return 列表数据
     */
    @ApiOperation(value = "查询列表数据")
    @RequestMapping(value = "getlist", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getlist(@RequestBody Talk talk) {
        PageHelper.startPage(talk.getOffset(), talk.getLimit());
        List<Map<String, Object>> list = talkService.queryAll(talk);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 查询对话框列表数据
     *
     * @return 列表数据
     */
    @ApiOperation(value = "查询对话框列表数据")
    @RequestMapping(value = "queryBox", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryBox(@RequestBody Talk talk) {
        List<Map<String, Object>> list = talkService.queryBox(talk);
        return AjaxResult.success(list);
    }


    /**
     * 删除
     *
     * @return 是否成功
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("del")
    public AjaxResult del(String code) {
        Integer row = talkService.deleteById(code);
        return row > 0 ? AjaxResult.success() : AjaxResult.fail();
    }

    /**
     * 保存
     *
     * @return 是否成功
     */
    @ApiOperation(value = "通过code修改数据")
    @RequestMapping(value = "updateByCode", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateByCode(@RequestBody Talk talk) {
        Integer row = 0;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        talk.setTime(sdf.format(d));
        row = talkService.updateByCode(talk);
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
    public AjaxResult save(@RequestBody Talk talk) {
        Integer row = 0;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        talk.setTime(sdf.format(d));
        if (talk.getId() == null) {
            row = talkService.insert(talk);
        } else {
            row = talkService.update(talk);
        }
        return row > 0 ? AjaxResult.success() : AjaxResult.fail();
    }

}
