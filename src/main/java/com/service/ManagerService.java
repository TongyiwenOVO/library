package com.service;

import com.entity.Author;
import com.entity.Book;
import com.entity.BookType;
import com.entity.BrrowInfo;

import java.util.List;

public interface ManagerService {

    boolean addBookAndAuthor(Book book, Author author);

    List<BookType> getBookType();

    boolean deleteManyBook(List<Integer> del_ids);

    boolean deleteOneBook(Integer id);

    boolean updateBook(Book book);

    List<Book> getBooks();

    Book getBookById(Integer id);

    List<BrrowInfo> getBrrowInfo();

    List<BrrowInfo> getBrrowInfoByAccount(String account);
}
