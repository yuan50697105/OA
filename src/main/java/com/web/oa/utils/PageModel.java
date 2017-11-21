package com.web.oa.utils;

import java.util.List;

public class PageModel<T> {
    private int pageIndex;
    private int pageSize;
    private long totalRecords;
    private List<T> t;

    public long getStartIndex() {
        return (pageIndex - 1) * pageSize;
    }

    public long getTotalPage() {
        return totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }
}
