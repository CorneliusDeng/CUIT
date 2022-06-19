package com.dateornotbackend.utils;

public class PageHelper {
    private int pagecount; // 页码数
    private int singlepage = 10; // 页面大小，默认为10

    public int getPagecount() {
        return pagecount;
    }

    public void setPage(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getSinglepage() {
        return singlepage;
    }

    public void setSinglepage(int singlepage) {
        this.singlepage = singlepage;
    }
}
