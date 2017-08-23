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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gengshikun
 * @date 2017/8/5
 */
@Controller
@RequestMapping(value = "administrators")
public class ShikUpmsAdminController {

    @Autowired
    private AdminRepository adminRepository;

    /**
     * 列表
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Object administrators(@RequestParam String username) {
        if(StringUtils.isNotBlank(username)){
            // 根据username获得资源
            return this.adminRepository.findOneByUsername(username);
        }
        return null;
    }

    /**
     * 新增
     * @param admin
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Admin administratorsId(@RequestBody Admin admin) {
        return this.adminRepository.save(admin);
    }

    /**
     * 获得
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Admin administratorsId(@PathVariable String id) {
        return this.adminRepository.findOne(id);
    }

    /**
     * 更新
     * @param admin
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Admin update(@PathVariable String id, @RequestBody Admin admin) {
        return this.adminRepository.save(admin);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setDeleteBoolean(Boolean.TRUE);
        this.adminRepository.save(admin);
    }
}
