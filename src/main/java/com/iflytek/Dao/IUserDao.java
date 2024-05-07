package com.iflytek.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.Domin.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao extends BaseMapper<User> {
    @Insert("insert into usermessage(username,password) values(#{username},#{password})")
    int insertUser(String username, String password);

}
