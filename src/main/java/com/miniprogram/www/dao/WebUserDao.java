package com.miniprogram.www.dao;

import com.miniprogram.www.entity.WebUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebUserDao {

    @Select("select * from web_user where id = #{id}")
    WebUser queryWebUserById(int id);

    @Select("select * from web_user where account = #{account}")
    WebUser queryWebUserByAccount(String account);

    @Insert("insert into web_user(account, password, name, type) values (#{account}, #{password}, #{name}, #{type})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertWebUser(WebUser webUser);

    List<String> queryNameListById(List<Integer> idList);

}
