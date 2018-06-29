package com.demo.consumer.feign;

import com.demo.consumer.entity.User;
import com.yss.base.common.exception.BaseException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feignClient interface
 *
 * @author liugang
 * @since 2018-06-28
 */
@FeignClient(name = "provider-service")
public interface IProviderService {

    /**
     * provider-service User
     *
     * @throws BaseException
     * @return User
     * @author liugang 2018-06-28 14:00
     * */
    @GetMapping("/provider-user")
    User user() throws BaseException;

    /**
     * provider-service Error
     *
     * @throws BaseException
     * @return User
     * @author liugang 2018-06-28 14:01
     * */
    @GetMapping("/provider-user/error")
    User error() throws BaseException;
}
