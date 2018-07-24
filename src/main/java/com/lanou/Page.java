package com.lanou;

import java.util.List;

/**
 * Created by dllo on 18/7/19.
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * My Dear Taoism's Friend .Please SitDown.
 */
public class Page<T> {
    //当前页数
    private int currentPage;
    //总页数
    private int pages;
    //每页展示条数
    private int everyPageCount;
    //总信息数
    private int size;
    //展示的数据集合
    private List<T> list;
    //从第几条开始展示
    private  int beginData;
    public Page() {
    }

    public Page(int currentPage, int pages, int everyPageCount, int size, List<T> list) {

        this.currentPage = currentPage;
        this.pages = pages;
        this.everyPageCount = everyPageCount;
        this.size = size;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pages=" + pages +
                ", everyPageCount=" + everyPageCount +
                ", size=" + size
                ;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginData() {
        return beginData;
    }

    public void setBeginData(int beginData) {
        this.beginData = beginData;
    }

    public int getPages() {
       return pages;
    }

    public void setPages(int pages) {

        this.pages = pages;
    }

    public int getEveryPageCount() {
        return everyPageCount;
    }

    public void setEveryPageCount(int everyPageCount) {
        this.everyPageCount = everyPageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
