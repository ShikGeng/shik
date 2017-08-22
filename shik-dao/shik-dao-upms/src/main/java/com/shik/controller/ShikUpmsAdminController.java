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
package com.shik.controller;

import com.shik.jpa.domain.Admin;
import com.shik.jpa.domain.User;
import com.shik.jpa.repository.AdminRepository;
import com.shik.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gengshikun
 * @date 2017/8/5
 */
@Controller
@RequestMapping(value = "admin")
public class ShikUpmsAdminController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Admin admin) {
        this.adminRepository.save(admin);
        return "success";
    }

    @RequestMapping(value = "find_one_by_username", method = RequestMethod.POST)
    @ResponseBody
    public Admin findOne(@RequestBody String username) {
        return this.adminRepository.findOneByUsername(username);
    }
}
