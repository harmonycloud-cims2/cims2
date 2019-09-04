package com.harmonycloud.common.database.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Usage: 分页封装
 * @Author: gjq
 * @Date: 2019/3/20 4:28 PM
 */
public class SmartPage<T> extends Page<T> {
    private T search;

    public T getSearch() {
        return search;
    }

    public void setSearch(T search) {
        this.search = search;
    }
}
