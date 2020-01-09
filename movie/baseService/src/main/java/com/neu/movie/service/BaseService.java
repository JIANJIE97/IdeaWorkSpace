package com.neu.movie.service;

import com.github.pagehelper.PageInfo;
import com.neu.movie.base.BaseDomain;
import com.neu.movie.base.BaseQuery;

public interface BaseService<T extends BaseDomain,E extends BaseQuery> {
    public PageInfo<T> findByQuery(E query);

    public boolean deleteByIds(String[] idArray);

    public T findById(int TId);

    public boolean update(T t);

    public boolean add(T t);
}
