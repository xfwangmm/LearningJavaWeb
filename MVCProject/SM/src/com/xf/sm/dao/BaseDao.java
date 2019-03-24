package com.xf.sm.dao;

import com.xf.sm.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Dao基类，实现一些通用的数据操作方法
 * @param <T>
 */
public class BaseDao<T> {
    /**
     *commons-dbutils提供
     */
    protected QueryRunner queryRunner;
    /**
     * T的class类型，如：User.class
     */
    protected Class<T> tClass;

    public BaseDao() {
        this.queryRunner = new QueryRunner();
        tClass = getTClass();
    }

    /**
     * insert，delete，update通用操作
     * @param sql
     * @param args
     * @return
     */
    protected int update(String sql, Object... args){
        Connection conn = C3P0Utils.getConnection();
        int rows = 0;
        try {
            rows = queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C3P0Utils.closeConnection(conn);

        return rows;
    }

    /**
     * 查询某条记录
     * @param sql
     * @param args
     * @return
     */
    protected T query(String sql, Object... args){
        T t = null;
        Connection conn = C3P0Utils.getConnection();
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<>(tClass), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C3P0Utils.closeConnection(conn);

        return t;
    }

    /**
     * 查询多条记录
     * @param sql
     * @param args
     * @return
     */
    protected List<T> queryBatch(String sql, Object... args){
        List<T> tList = null;
        Connection conn = C3P0Utils.getConnection();
        try {
            tList = queryRunner.query(conn, sql, new BeanListHandler<>(tClass), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C3P0Utils.closeConnection(conn);

        return tList;
    }

    /**
     * 获取tClass，例如User.class
     * @return
     */
    private Class<T> getTClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType) type;
            Type[] types = pType.getActualTypeArguments();
            if (types[0] instanceof Class){
                tClass = (Class<T>) types[0];
            }
        }
        return tClass;
    }


}
