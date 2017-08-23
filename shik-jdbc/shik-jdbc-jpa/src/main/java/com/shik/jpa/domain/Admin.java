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
package com.shik.jpa.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author gengshikun
 * @date 2017/6/30
 */
@Entity(name = "admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(length = 32)
    private String id;

    @NotEmpty(message = "用户名不能为空")
    @Column(length = 32)
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Column(length = 32)
    private String password;

    @Column(name = "delete_boolean")
    private Boolean deleteBoolean;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "admin_to_role", joinColumns = {@JoinColumn(name = "admin_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;  // 一个用户具有多个角色

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "admin_to_permission", joinColumns = {@JoinColumn(name = "admin_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<Permission> permissionList; // 一个用户具有多个权限

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleteBoolean() {
        return deleteBoolean;
    }

    public void setDeleteBoolean(Boolean deleteBoolean) {
        this.deleteBoolean = deleteBoolean;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
