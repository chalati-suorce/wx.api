package com.demo.system.dao;

import org.apache.ibatis.annotations.Mapper;
import com.demo.system.entity.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 医生表
 */
public interface DoctorDao {

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
     * @param doctor 实例对象
     * @return 对象列表
     */
    List<Map<String, Object>> queryAll(Doctor doctor);

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int insert(Doctor doctor);

    /**
     * 修改数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int update(Doctor doctor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
