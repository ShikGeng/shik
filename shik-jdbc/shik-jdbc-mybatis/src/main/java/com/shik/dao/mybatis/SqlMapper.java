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


import com.shik.support.component.SpringContextUtil;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author gengshikun
 * @date 2017/2/27
 */
public class SqlMapper {
    private String namespace;
    private ShikSqlSessionDaoSupport daoSupport;

    public SqlMapper(String namespace) {
        this.namespace = namespace;
        this.daoSupport = (ShikSqlSessionDaoSupport) SpringContextUtil.getBean("shikSqlSessionDaoSupport");
    }

    public int insert(String insertId, Object parameter) {
        insertId = namespace + "." + insertId;
        return daoSupport.insert(insertId, parameter);
    }

    public int update(String updateId, Object parameter) {
        updateId = namespace + "." + updateId;
        return daoSupport.update(updateId, parameter);
    }

    public int delete(String deleteId, Object parameter) {
        deleteId = namespace + "." + deleteId;
        return daoSupport.delete(deleteId, parameter);
    }

    public <M> M selectOne(String selectId, Object parameter) {
        selectId = namespace + "." + selectId;
        return daoSupport.selectOne(selectId, parameter);
    }

    public <E> List<E> selectList(String selectId, Object parameter) {
        selectId = namespace + "." + selectId;
        return daoSupport.selectList(selectId, parameter);
    }

    public <M> M selectFirstFromList(String selectId, Object parameter) {
        selectId = namespace + "." + selectId;
        List<M> ls = daoSupport.selectList(selectId, parameter);
        if (ls.size() > 0) {
            return ls.get(0);
        }
        return null;
    }

    public <E> List<E> selectLimitedList(String selectId, Object parameter,
                                         RowBounds rowBounds) {
        selectId = namespace + "." + selectId;

        return daoSupport.selectLimitedList(selectId, parameter, rowBounds);
    }

    public int selectPageCount(String countId, Object parameter) {
        countId = namespace + "." + countId;
        return daoSupport.selectOne(countId, parameter);
    }

    public <E> List<E> selectByPage(String selectId, Object params,
                                    int page, int rows) {
        selectId = namespace + "." + selectId;
        RowBounds rowBounds = new RowBounds(page, rows);
        List<E> results = daoSupport.selectLimitedList(selectId, params,
                rowBounds);
        return results;
    }

}
