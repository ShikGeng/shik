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
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author gengshikun
 * @date 2017/2/27
 */
public class TableMapper {

    private String namespace;
    private ShikSqlSessionDaoSupport daoSupport;

    public TableMapper(String namespace) {
        this.namespace = namespace;
        this.daoSupport = (ShikSqlSessionDaoSupport) SpringContextUtil.getBean("shikSqlSessionDaoSupport");
    }

    public <E> List<E> selectByExample(Object example) {
        String selectId = namespace + ExampleEnum.selectByExample;
        List<E> ls = this.daoSupport.selectList(selectId, example);
        return ls;
    }

    public <M> M selectFirstByExample(Object example) {
        String selectId = namespace + ExampleEnum.selectByExample;
        List<M> ls = this.daoSupport.selectList(selectId, example);
        if (ls.size() > 0) {
            return ls.get(0);
        }
        return null;
    }

    public <M> M selectByPrimaryKey(Object key) {
        String selectId = namespace + ExampleEnum.selectByPrimaryKey;
        M m = this.daoSupport.selectOne(selectId, key);
        return m;
    }

    public int deleteByPrimaryKey(Object key) {
        String deleteId = namespace + ExampleEnum.deleteByPrimaryKey;
        int count = this.daoSupport.delete(deleteId, key);
        return count;
    }

    public int countByExample(Object example) {
        String countId = namespace + ExampleEnum.countByExample;
        int count = this.daoSupport.selectCount(countId, example);
        return count;
    }

    public int deleteByExample(Object example) {
        String deleteId = namespace + ExampleEnum.deleteByExample;
        int count = this.daoSupport.delete(deleteId, example);
        return count;
    }

    public int insert(Object parameter) {
        String insertId = namespace + ExampleEnum.insert;
        int count = this.daoSupport.insert(insertId, parameter);
        return count;
    }

    public int insertSelective(Object parameter) {
        String insertId = namespace + ExampleEnum.insertSelective;
        int count = this.daoSupport.insert(insertId, parameter);
        return count;
    }

    public int updateByExample(Object record, Object example) {
        ParamMap<Object> pm = new ParamMap<Object>();
        pm.put("record", record);
        pm.put("example", example);
        String updateId=namespace+ExampleEnum.updateByExample;
        int obj=this.daoSupport.update(updateId, pm);
        return obj;
    }

    public int updateByExampleSelective(Object record,Object example){
        ParamMap<Object> pm = new ParamMap<Object>();
        pm.put("record", record);
        pm.put("example", example);
        String updateId=namespace+ExampleEnum.updateByExampleSelective;
        int obj=this.daoSupport.update(updateId, pm);
        return obj;
    }

    public int updateByPrimaryKeySelective(Object record) {
        String updateId = namespace + ExampleEnum.updateByPrimaryKeySelective;
        int obj = this.daoSupport.update(updateId, record);
        return obj;
    }

    public int updateByPrimaryKey(Object key) {
        String updateId = namespace + ExampleEnum.updateByPrimaryKey;
        int obj = this.daoSupport.update(updateId, key);
        return obj;
    }

    public <E> List<E> selectLimitedList(Object parameter, int offset, int limit) {
        String selectId = namespace + ExampleEnum.selectLimitedList;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<E> ls = this.daoSupport.selectLimitedList(selectId, parameter,
                rowBounds);
        return ls;
    }

    public <E, M> List<E> selectByPage(int page, int rows, M example) {
        RowBounds rowBounds = new RowBounds(page, rows);
        List<E> results = this.daoSupport.selectLimitedList(namespace
                + ExampleEnum.selectByExample.toString(), example, rowBounds);
        return results;
    }

    public <E, M> List<E> selectByPageWithBLOBs(int page, int rows, M example) {
        RowBounds rowBounds = new RowBounds(page, rows);
        List<E> results = this.daoSupport.selectLimitedList(namespace
                        + ExampleEnum.selectByExampleWithBLOBs.toString(), example,
                rowBounds);
        return results;
    }

}
