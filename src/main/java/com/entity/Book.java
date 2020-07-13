package com.entity;

import java.util.Arrays;
import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private Integer bookNumber;

    private Integer bookTypeid;

    private Integer authorid;

    private String publisher;

    private Date publishtime;

    private byte[] bookPhoto;

    private Author author;

    private BookType bookType;

    private String base64encoded;

    //保存图片Base64
    public String getBase64encoded() {
        return base64encoded;
    }

    public void setBase64encoded(String base64encoded) {
        this.base64encoded = base64encoded;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Integer getBookTypeid() {
        return bookTypeid;
    }

    public void setBookTypeid(Integer bookTypeid) {
        this.bookTypeid = bookTypeid;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public byte[] getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(byte[] bookPhoto) {
        this.bookPhoto = bookPhoto;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookNumber=" + bookNumber +
                ", bookTypeid=" + bookTypeid +
                ", authorid=" + authorid +
                ", publisher='" + publisher + '\'' +
                ", publishtime=" + publishtime +
                ", bookPhoto=" + Arrays.toString(bookPhoto) +
                ", author=" + author +
                ", bookType=" + bookType +
                '}';
    }
}