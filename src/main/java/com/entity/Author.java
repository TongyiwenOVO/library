package com.entity;

import java.util.Arrays;

public class Author {
    private Integer authorId;

    private String authorName;

    private String authorInfo;

    private byte[] authorPhoto;

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorInfo='" + authorInfo + '\'' +
                ", authorPhoto=" + Arrays.toString(authorPhoto) +
                '}';
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo == null ? null : authorInfo.trim();
    }

    public byte[] getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(byte[] authorPhoto) {
        this.authorPhoto = authorPhoto;
    }
}