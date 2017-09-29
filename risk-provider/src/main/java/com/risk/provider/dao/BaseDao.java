package com.risk.provider.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface BaseDao<T>{
    /**
     * 新增操作
     *
     * @param t
     * @return
     */
    public int insert(T t);


    /**
     * 更新所有字段
     *
     * @param t
     * @return
     */
    public int update(T t);



    /**
     * 根据ID删除记录
     *
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public T get(Integer id);

    /**
     * 查询所有的记录，自动分页
     *
     * @return
     */
    public List<T> findList(T t);


    /**
     * 查询所有的记录,不带分页
     *
     * @return
     */
    public List<T> findAllList(T t);


}
