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

import com.shik.client.ShikUpmsClient;
import com.shik.constant.ShiroConstants;
import com.shik.dao.model.Admin;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    private static final Logger logger = LoggerFactory.getLogger(ShikUpmaIndexController.class);

    @Autowired
    private ShikUpmsClient shikUpmsClient;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {

        return "admin/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/add";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(Admin admin) {
        Object hashPassword = new SimpleHash(ShiroConstants.HASH_ALGORITHM_NAME, admin.getPassword(),
                ByteSource.Util.bytes(admin.getUsername()), ShiroConstants.HASH_ITERATIONS);
        admin.setPassword(hashPassword.toString());
        String result = this.shikUpmsClient.save(admin);
        return result;
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable String id) {

        Admin admin = this.shikUpmsClient.findOne(id);
        System.out.println(admin);

        return "admin/view";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id) {
        return "redirect:list";
    }

}
