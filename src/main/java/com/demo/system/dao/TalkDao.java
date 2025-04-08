package com.demo.system.dao;

import org.apache.ibatis.annotations.Mapper;
import com.demo.system.entity.Talk;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 对话表
 */
public interface TalkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param talk 实例对象
     * @return 对象列表
     */
    List<Map<String, Object>> queryAll(Talk talk);


    /**
     * 查询对话框
     */
    List<Map<String, Object>> queryBox(Talk talk);

    /**
     * 新增数据
     *
     * @param talk 实例对象
     * @return 影响行数
     */
    int insert(Talk talk);

    /**
     * 修改数据
     *
     * @param talk 实例对象
     * @return 影响行数
     */
    int update(Talk talk);


    /**
     * 修改数据
     */
    int updateByCode(Talk talk);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String code);

}
