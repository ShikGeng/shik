package com.shik.jpa.repository;

import com.shik.jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author gengshikun
 * @date 2016/12/6
 */
public interface UserRepository extends PagingAndSortingRepository<User, String>, JpaRepository<User, String> {

    /**
     * 列表页分页查询
     *
     * @param query
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String query, Pageable pageable);

    /**
     * 根据用户名和密码查询
     *
     * @param email
     * @param password
     * @return
     */
    User findByEmailAndPassword(String email, String password);

    /**
     * 根据email获得用户
     *
     * @param email
     * @param deleteBoolean
     * @return
     */
    User findByEmailAndDeleteBoolean(String email, Boolean deleteBoolean);

}
