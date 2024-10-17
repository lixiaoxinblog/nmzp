package com.xiaoxin.nmzp.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxin.nmzp.server.entity.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xiaoxin
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2024-10-17 14:02:46
* @Entity .domain.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}




