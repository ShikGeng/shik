package com.shik.jpa.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "`user`")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String email;

    @Column(length = 32)
    private String password;

    @Column(length = 32)
    private String name;

    @Column
    private Integer age;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "delete_boolean")
    private Boolean deleteBoolean;

    @Column
    private Boolean validate;

    @Column(name = "register_time")
    private Long registerTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleteBoolean() {
        return deleteBoolean;
    }

    public void setDeleteBoolean(Boolean deleteBoolean) {
        this.deleteBoolean = deleteBoolean;
    }

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }
}