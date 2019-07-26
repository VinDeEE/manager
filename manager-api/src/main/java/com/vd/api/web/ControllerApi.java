package com.vd.api.web;

import com.vd.common.data.model.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value = "测试接口", description = "测试11接口")
public interface ControllerApi {
    @ApiOperation("查找全部")
    public List<Student> getAll();
}
