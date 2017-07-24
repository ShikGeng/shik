package com.shik.controller;

import com.shik.constant.enums.DataSourceType;
import com.shik.dao.mybatis.CommDAO;
import com.shik.jpa.repository.UserRepository;
import com.shik.support.component.DynamicDataSource;
import com.shik.support.util.JedisUtil;
import com.shik.support.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shik on 2017/7/23.
 */
@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "test/redis", method = RequestMethod.GET)
    @ResponseBody
    public String testRedis() {

        JedisUtil.getInstance().STRINGS.setEx("boot-test", 100, "redis-test");

        String test = JedisUtil.getInstance().STRINGS.get("boot-test");
        System.out.println(test);

        return "success";
    }

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "test/jpa", method = RequestMethod.GET)
    @ResponseBody
    public String testJPA() {
        com.shik.jpa.domain.User user = new com.shik.jpa.domain.User();
        user.setName("jpa");
        userRepository.save(user);
        return "success";
    }

    @Autowired
    private CommDAO commDAO;

    @RequestMapping(value = "test/mybatis", method = RequestMethod.GET)
    @ResponseBody
    public String testMybatis() {
        com.shik.dao.model.User user = new com.shik.dao.model.User();
        user.setUserid(UUIDUtil.random16UUID());
        user.setName("mybatis1");
        DynamicDataSource.setDataSource(DataSourceType.READ.getValue());
        this.commDAO.init(com.shik.dao.model.User.class).insert(user);
        DynamicDataSource.setDataSource(DataSourceType.PRIMARY.getValue());
        this.commDAO.init(com.shik.dao.model.User.class).insert(user);
        return "success";
    }
}
