package com.vd.web.controller;

import com.vd.api.web.ControllerApi;
import com.vd.common.data.model.entity.Stu;
import com.vd.web.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController implements ControllerApi {

    @Resource
    private TestService testService;

    @RequestMapping("/getAll")
    @Override
    public List<Stu> getAll() {
        log.info("into");
        return testService.getAll();
    }


    @Scheduled(cron = "0/5 * * * * ? ") //测试
    public void all() {
        log.info("into");
        List<Stu> all = testService.getAll();
        System.out.println(all);
    }

}
