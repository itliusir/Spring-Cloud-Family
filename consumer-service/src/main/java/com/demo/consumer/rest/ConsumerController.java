package com.demo.consumer.rest;

import com.demo.consumer.entity.User;
import com.demo.consumer.feign.IProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yss.base.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费方
 *
 * @author liugang
 * @since 2018-06-28
 */
@Slf4j
@RestController
@RequestMapping("consumer-user")
public class ConsumerController {

    @Autowired
    private IProviderService iProviderService;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("")
    public User user() throws BaseException {
        return iProviderService.user();
    }

    public User error(Throwable throwable) throws BaseException{
        log.error("进入回退方法，异常：" + throwable);
        User user = new User();
        user.setId(0);
        user.setAge(0);
        user.setName("Admin");
        user.setPort(8888);
        //throw new BaseException("ConsumerController.user error fallback",500);
        return user;

        /**
         * 1. com.yss.base.common
         * 2. com.yss.demo
         * 3. com.yss.mybatis
         * 4. com.yss.jpa
         *
         *
         * */
    }
}
