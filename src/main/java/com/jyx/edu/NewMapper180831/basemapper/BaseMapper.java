package com.jyx.edu.NewMapper180831.basemapper;

import com.jyx.edu.NewMapper180831.basemapper.mymapper.TreeMapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface BaseMapper<T> extends Mapper<T> ,MySqlMapper<T> ,IdsMapper<T> ,TreeMapper<T> {


}
