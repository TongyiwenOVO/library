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
    public boolean updateBook(Book book) {
        Integer result=bookMapper.updateByPrimaryKeySelective(book);
        return result>0?true:false;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books=bookMapper.selectByExampleWithAuthorAndBookType(null);
        String baseString=null;
        for (Book book:books){
            baseString=Base64.encodeBase64String(book.getBookPhoto());
            book.setBase64encoded(baseString);
        }
        return books;
    }

    @Override
    public Book getBookById(Integer id) {
        Book book=bookMapper.selectByPrimaryKeyWithAuthorAndBookType(id);
        String baseString=Base64.encodeBase64String(book.getBookPhoto());
        book.setBase64encoded(baseString);
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
}
