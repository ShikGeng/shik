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
package com.shik.dao.mybatis;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gengshikun
 * @date 2017/2/27
 */
@Component("shikSqlSessionDaoSupport")
public class ShikSqlSessionDaoSupport extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int insert(String insertId, Object parameter) {
        return getSqlSession().insert(insertId, parameter);
    }

    public int update(String updateId, Object parameter) {
        return getSqlSession().update(updateId, parameter);
    }

    public int delete(String deleteId, Object parameter) {
        return getSqlSession().delete(deleteId, parameter);
    }

    public <M> M selectOne(String selectId, Object parameter) {
        return getSqlSession().selectOne(selectId, parameter);
    }

    public <E> List<E> selectList(String selectId, Object parameter) {
        return getSqlSession().selectList(selectId, parameter);
    }

    public <E> List<E> selectLimitedList(String selectId,Object parameter, RowBounds rowBounds) {
        return getSqlSession().selectList(selectId, parameter,rowBounds);
    }
    public int selectCount(String countId, Object parameter) {
        return getSqlSession().selectOne(countId, parameter);
    }
}
