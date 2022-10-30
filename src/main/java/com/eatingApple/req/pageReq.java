package com.eatingApple.req;

public class pageReq {
    //页面页码
    private  int page;
//    每页条数
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "pageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public void setSize(int size) {
        this.size = size;
    }
}
