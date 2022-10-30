package com.eatingApple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eatingApple.entity.userEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper extends BaseMapper<userEntity> {
}
