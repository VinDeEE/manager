package com.vd.common.data;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Desc: mapper基础类
 * Author: VinDe
 * Date: Create in 2019/7/26
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
