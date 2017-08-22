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
import com.shik.jpa.domain.Admin;
import com.shik.jpa.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String save(Admin admin) {
        String result = this.shikUpmsClient.save(admin);
        logger.info(">>>>>>>>>>>>>>>>> result : {} >>>>>>>>>>>>>>>>>", result);
        return "redirect:http://zuul.shik.com:5551/shik-upms/admin/list";
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable String id) {
        return "admin/view";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id) {
        return "redirect:http://zuul.shik.com:5551/shik-upms/admin/list";
    }

}
