package com.neu.movie.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.movie.base.BaseDomain;
import com.neu.movie.base.BaseMapper;
import com.neu.movie.base.BaseQuery;
import com.neu.movie.service.BaseService;

import java.util.List;

public class BaseServiceImpl<T extends BaseDomain,E extends BaseQuery> implements BaseService<T,E> {

    protected BaseMapper<T,E> baseMapper;

    @Override
    public boolean add(T t) {
        return baseMapper.add(t)==1;
    }

    @Override
    public boolean deleteByIds(String[] idArray) {
        int count = baseMapper.deleteByIds(idArray);
        return (count==idArray.length)?true:false;
    }

    @Override
    public boolean update(T t) {
        return baseMapper.update(t)==1;
    }

    @Override
    public T findById(int TId) {
        return baseMapper.findById(TId);
    }

    @Override
    public PageInfo<T> findByQuery(E query) {
        System.out.println("-------------query--------------"+query);
        PageInfo<T> pageInfo=null;
        if(query.isPaging()){
            //要分页
            if(query.getOffSet()==null || query.getPageSize()==null){
                throw new RuntimeException("分页参数为空异常");
            }
            PageHelper.startPage(query.getOffSet(),query.getPageSize());
            Page<T> list = (Page<T>)baseMapper.findByQuery(query);
            System.out.println("------selectResult:-------"+list);
            pageInfo =  list.toPageInfo();
        }else{
            //不要分页
            List<T> list = baseMapper.findByQuery(query);
            System.out.println("------noSelectResult:-------"+list);
            pageInfo = new PageInfo<>();
            pageInfo.setList(list);
            pageInfo.setSize(list.size());
        }
        return pageInfo;
    }
}
