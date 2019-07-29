package com.vd.web.service.impl;

import com.vd.common.data.mapper.read.TestMapper;
import com.vd.common.data.model.entity.Stu;
import com.vd.web.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Stu> getAll() {
        return testMapper.selectAll();
/*        Stu student = new Stu();
        student.setSName("456hahahaha,范蛇皮");
        student.setSNo(456);
        student.setSAge(new Date());

        return Arrays.asList(student);*/
    }


/*    public static void main(String[] args) {
        TestServiceImpl test = new TestServiceImpl();
        List<Student> all = test.getAll();
        System.out.println(all);
    }*/
}
