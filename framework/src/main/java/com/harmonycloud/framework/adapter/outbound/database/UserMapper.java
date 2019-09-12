package com.harmonycloud.framework.adapter.outbound.database;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @DS("read")
    @Select("SELECT t.\"login_name\" FROM \"cims_user\" t where t.\"user_id\" = #{id}")
    String findById(@Param("id") int id);
}
