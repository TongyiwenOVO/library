package com.service.impl;

import com.entity.*;
import com.mapper.AuthorMapper;
import com.mapper.BookMapper;
import com.mapper.BookTypeMapper;
import com.mapper.BrrowInfoMapper;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.apache.commons.codec.binary.Base64;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    AuthorMapper authorMapper;
    @Autowired
    BookTypeMapper bookTypeMapper;
    @Autowired
    BrrowInfoMapper brrowInfoMapper;

    @Override
    public boolean addBookAndAuthor(Book book, Author author) {
        Integer resultAuthor=authorMapper.insertSelective(author);
        if (resultAuthor>0){
            book.setAuthorid(author.getAuthorId());
            Integer resultBook=bookMapper.insertSelective(book);
            if (resultBook>0){
                return true;
            }else {
                System.out.println("图书信息插入失败");
                return false;
            }
        }else {
            System.out.println("作者信息插入失败");
            return false;
        }
    }

    @Override
    public List<BookType> getBookType() {
        List<BookType> bookTypes=bookTypeMapper.selectByExample(null);
        return bookTypes;
    }

    @Override
    public boolean deleteManyBook(List<Integer> del_ids) {
        BookExample example=new BookExample();
        BookExample.Criteria criteria=example.createCriteria();
        criteria.andBookIdIn(del_ids);
        Integer result=bookMapper.deleteByExample(example);
        return result>0?true:false;
    }

    @Override
    public boolean deleteOneBook(Integer id) {
        Integer result=bookMapper.deleteByPrimaryKey(id);
        return result>0?true:false;
    }

    @Override
    public boolean updateBook(Book book,Author author) {
        Integer result=bookMapper.updateByPrimaryKeySelective(book);
        Integer result1=authorMapper.updateByPrimaryKeySelective(author);
        if (result>0&&result1>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books=bookMapper.selectByExampleWithAuthorAndBookType(null);
        return books;
    }

    @Override
    public Book getBookById(Integer id) {
        Book book=bookMapper.selectByPrimaryKeyWithAuthorAndBookType(id);
        return book;
    }

    @Override
    public List<BrrowInfo> getBrrowInfo() {
        List<BrrowInfo> brrowInfos=brrowInfoMapper.selectByExampleWithAccountAndBook(null);
        return brrowInfos;
    }

    @Override
    public List<BrrowInfo> getBrrowInfoByAccount(String account) {
        List<BrrowInfo> brrowInfos=brrowInfoMapper.selectByExampleWithAccountAndBookByAccount(account);
        return brrowInfos;
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        BookExample example=new BookExample();
        BookExample.Criteria criteria=example.createCriteria();
        criteria.andBookNameLike("%"+bookName+"%");
        List<Book> books=bookMapper.selectByExampleWithAuthorAndBookType(example);
        return books;
    }
}
