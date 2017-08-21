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
package com.shik.shiro.session;

import com.shik.support.util.SerializableUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * @author gengshikun
 * @date 2017/8/21
 */
public class ShikSessionDao extends EnterpriseCacheSessionDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        String sql = "insert into sessions(id, session) values(?,?)";
        jdbcTemplate.update(sql, sessionId,
                SerializableUtil.serialize(session));
        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String sql = "select session from sessions where id=?";
        List<String> sessionStrList = jdbcTemplate.queryForList(sql,
                String.class, sessionId);
        if (sessionStrList.size() == 0)
            return null;
        return (Session) SerializableUtil.deserialize(sessionStrList.get(0).getBytes());
    }

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession
                && !((ValidatingSession) session).isValid()) {
            return;
        }
        String sql = "update sessions set session=? where id=?";
        jdbcTemplate.update(sql, SerializableUtil.serialize(session),
                session.getId());
    }

    @Override
    protected void doDelete(Session session) {
        String sql = "delete from sessions where id=?";
        jdbcTemplate.update(sql, session.getId());
    }
}
