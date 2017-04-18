package org.toephy.blog.bean.dto;

/**
 * Created by Toephy on 2017.4.18 17:28
 * 分页信息
 */
public class Pager {

    private int pageNo;      //当前页号
    private int totalPage;   //总页码数
    private String toURL;    //点击分页标签时要跳转到的目标URL

    public Pager() {
    }

    public Pager(int pageNo, int totalPage, String toURL) {
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.toURL = toURL;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getToURL() {
        return toURL;
    }

    public void setToURL(String toURL) {
        this.toURL = toURL;
    }
}
