package com.vd.web.controller;

import com.vd.api.web.ControllerApi;
import com.vd.common.data.model.entity.Student;
import com.vd.web.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController implements ControllerApi {

    @Resource
    private TestService testService;

    @GetMapping("/getAll")
    @Override
    public List<Student> getAll() {
        log.info("into");
        return testService.getAll();
    }


    @Scheduled(cron = "0/5 * * * * ? ") //测试
    public void all() {
        log.info("into");
        List<Student> all = testService.getAll();
        System.out.println(all);
    }

}
