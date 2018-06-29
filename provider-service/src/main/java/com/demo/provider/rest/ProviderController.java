package com.demo.provider.rest;

import com.demo.provider.entity.User;
import com.yss.base.common.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供方API
 *
 * @author liugang
 * @since 2018-06-28
 */

@RestController
@RequestMapping("provider-user")
public class ProviderController {

    @Autowired
    private User user;


    /**
     * 暴露User信息
     *
     * @author liugang 2018-06-28 13:45
     * */
    @GetMapping("")
    public User user() throws BaseException {
        return user;
    }

    /**
     * 模拟超时错误
     *
     * @author liugang 2018-06-28 13:45
     * */
    @GetMapping("/error")
    public User error() throws BaseException{
        throw new BaseException(HttpStatus.GATEWAY_TIMEOUT.getReasonPhrase(), HttpStatus.GATEWAY_TIMEOUT.value());
    }
}