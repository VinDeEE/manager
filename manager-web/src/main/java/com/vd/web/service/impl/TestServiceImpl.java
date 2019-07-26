package com.vd.web.service.impl;

import com.vd.common.data.mepper.read.TestMapper;
import com.vd.common.data.model.dto.Student;
import com.vd.web.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Student> getAll() {
        return testMapper.selectAll();
    }


/*    public static void main(String[] args) {
        TestServiceImpl test = new TestServiceImpl();
        List<Student> all = test.getAll();
        System.out.println(all);
    }*/
}
