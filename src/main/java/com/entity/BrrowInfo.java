package com.entity;

import java.util.Date;

public class BrrowInfo {
    private Integer broId;

    private Integer userid;

    private Integer bookid;

    private Date lendtime;

    private Date returntime;

    private Integer applytime;

    private Float moeny;

    private Book book;

    private Account account;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getBroId() {
        return broId;
    }

    public void setBroId(Integer broId) {
        this.broId = broId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getLendtime() {
        return lendtime;
    }

    public void setLendtime(Date lendtime) {
        this.lendtime = lendtime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public Integer getApplytime() {
        return applytime;
    }

    public void setApplytime(Integer applytime) {
        this.applytime = applytime;
    }

    public Float getMoeny() {
        return moeny;
    }

    public void setMoeny(Float moeny) {
        this.moeny = moeny;
    }

    @Override
    public String toString() {
        return "BrrowInfo{" +
                "broId=" + broId +
                ", userid=" + userid +
                ", bookid=" + bookid +
                ", lendtime=" + lendtime +
                ", returntime=" + returntime +
                ", applytime=" + applytime +
                ", moeny=" + moeny +
                ", book=" + book +
                ", account=" + account +
                '}';
    }
}