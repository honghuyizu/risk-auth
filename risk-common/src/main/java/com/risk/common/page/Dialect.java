package com.risk.common.page;

/**
 * 类似hibernate的Dialect,但只精简出分页部分
 *
 * @author honghu
 * @version 1.0
 * @since 2015-01-21
 */
public class Dialect {

    public boolean supportsLimit() {
        return false;
    }

    public boolean supportsLimitOffset() {
        return supportsLimit();
    }

    /**
     * 将sql变成分页sql语句,直接使用offset,limit的值作为占位符.
     * <p>源代码为: getLimitString(sql,offset,String.valueOf(offset),limit,String.valueOf(limit))<p/>
     */
    public String getLimitString(String sql, int offset, int limit) {
        return getLimitString(sql, offset, Integer.toString(offset), limit, Integer.toString(limit));
    }

    /**
     * 将sql变成分页sql语句,提供将offset及limit使用占位符(placeholder)替换.
     * <p/>
     * 如mysql
     * dialect.getLimitString("select * from user", 12, ":offset",0,":limit") 将返回
     * select * from user limit :offset,:limit
     * <p/>
     *
     * @return 包含占位符的分页sql
     */
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        throw new UnsupportedOperationException("paged queries not supported");
    }

}
