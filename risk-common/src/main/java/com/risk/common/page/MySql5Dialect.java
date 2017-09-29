package com.risk.common.page;


/**
 * MySql数据库方言类的现实，MySql数据库的一些特殊处理
 *
 * @author honghu
 * @version 1.0
 * @since 2015-01-21
 */
public class MySql5Dialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";


    public String getLimitString(String sql, boolean hasOffset) {
        return MySql5PageHepler.getLimitString(sql, -1, -1);
    }

    /**
     * 将sql变成分页sql语句,直接使用offset,limit的值作为占位符.
     * <p>源代码为: getLimitString(sql,offset,String.valueOf(offset),limit,String.valueOf(limit))<p/>
     */
    public String getLimitString(String sql, int offset, int limit) {
        return MySql5PageHepler.getLimitString(sql, offset, limit);
    }

    public boolean supportsLimit() {
        return true;
    }
}
