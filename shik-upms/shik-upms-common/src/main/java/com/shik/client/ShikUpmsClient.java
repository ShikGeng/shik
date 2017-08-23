/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
package com.shik.client;

import com.shik.client.hystrix.ShikUpmsClientImpl;
import com.shik.dao.model.Admin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author gengshikun
 * @date 2017/7/17
 */
@FeignClient(value = "shik-zuul", fallback = ShikUpmsClientImpl.class)
public interface ShikUpmsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/shik-dao-upms/administrators")
    String save(Admin admin);

    @RequestMapping(method = RequestMethod.GET, value = "/shik-dao-upms/administrators")
    Admin findOneByUsername(@RequestParam("username") String username);

    @RequestMapping(method = RequestMethod.GET, value = "/shik-dao-upms/administrators/{id}")
    Admin findOne(@PathVariable("id") String id);
}
