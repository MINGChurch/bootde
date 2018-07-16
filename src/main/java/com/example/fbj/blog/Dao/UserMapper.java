package com.example.fbj.blog.Dao;

import com.example.fbj.blog.Entity.User;
import org.apache.ibatis.annotations.Mapper;
/**
 * @Author :fubijie
 * @Description :
 * @Date : 19:08 2018/7/16
 **/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}