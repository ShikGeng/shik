package com.shik.jpa.repository;

import com.shik.jpa.domain.Blog;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gengshikun
 * @date 2016/12/6
 */
@Repository
@CacheConfig(cacheNames = "blogs")
public interface BlogRepository extends PagingAndSortingRepository<Blog, String>, JpaRepository<Blog, String> {

    /**
     * 列表页分页查询
     *
     * @param query
     * @param pageable
     * @return
     */
    Page<Blog> findByTitleLike(String query, Pageable pageable);

    Blog findByTitle(String title);

    @CacheEvict(key = "'blog:'+#p0.blogId")
    Blog save(Blog blog);

    @CacheEvict(key = "'blog:'+#p0.blogId")
    Blog saveAndFlush(Blog blog);

    @Cacheable(key = "'blog:'+#p0")
    Blog findOne(String blogId);


}
