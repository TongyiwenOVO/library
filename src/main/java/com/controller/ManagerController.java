package com.controller;

import com.entity.Author;
import com.entity.Book;
import com.entity.BookType;
import com.entity.BrrowInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ManagerService;
import com.utils.Msg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/Manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    /**
     * 通过账户查询具体某个账户订单
     * @param account
     * @return
     */
    @RequestMapping("/getBrrowInfoByAccount")
    @ResponseBody
    public Msg getBrrowInfoByAccount(String account){
        List<BrrowInfo> brrowInfos=managerService.getBrrowInfoByAccount(account);
        return Msg.success().add("brrowinfobyaccount",brrowInfos);
    }
    /**
     * 管理员获取订单信息
     * @return
     */
    @RequestMapping("/getBrrowInfo")
    @ResponseBody
    public Msg getBrrowInfo(){
        List<BrrowInfo> brrowInfos=managerService.getBrrowInfo();
        return Msg.success().add("brrowinfos",brrowInfos);
    }
    /**
     * 通过book_id查询
     * 在修改时回显调用
     * @param id
     * @return
     */
    @RequestMapping("/getBookById")
    @ResponseBody
    public Msg getBookById(Integer id){
        Book book=managerService.getBookById(id);
        return Msg.success().add("book",book);
    }
    /**
     * 分页查询图书信息和Author BookType联合查询
     * @param pn
     * @return
     */
    @RequestMapping("/getBooks")
    @ResponseBody
    public Msg getBooks(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Book> books=managerService.getBooks();
        PageInfo pageInfo=new PageInfo(books,5);
        return Msg.success().add("page",pageInfo);
    }
    /**
     * 在增加book之前先获取booktype，以下拉列表显示
     * @return
     */
    @RequestMapping("/getBookType")
    @ResponseBody
    public Msg getBookType(){
        List<BookType> bookType =managerService.getBookType();
        return Msg.success().add("booktype",bookType);
    }
    /**
     * 添加图书
     * @param book   图书实体类
     * @param author   作者实体类
     * @param bookFile  图书的图片
     * @param authorFile  作者的图片
     * @return
     * @throws Exception
     */
    @RequestMapping("/addBookAndAuthor")
    @ResponseBody
    public Msg addBook(Book book, Author author, MultipartFile bookFile,MultipartFile authorFile)throws Exception{
        //图片转化为数据流
        book.setBookPhoto(bookFile.getBytes());
        author.setAuthorPhoto(authorFile.getBytes());
        boolean result=managerService.addBookAndAuthor(book,author);
        if (result){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    /**
     * 单个删除和批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/deleteBook/{ids}")
    @ResponseBody
    public Msg deleteBook(@PathVariable("ids") String ids){
        boolean result;
        if (ids.contains("-")){
            String[] str_ids=ids.split("-");
            List<Integer> del_ids=new ArrayList<>();
            for (String str:str_ids){
                del_ids.add(Integer.parseInt(str));
            }
           result= managerService.deleteManyBook(del_ids);
        }else{
            Integer id=Integer.parseInt(ids);
            result=managerService.deleteOneBook(id);
        }
        if (result){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    /**
     * 更新图书信息
     * 点击每个图书的更新按钮 可以获得book_id并绑定到要修改的数据中一起传回来
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    @ResponseBody
    public Msg updateBook(Book book){
        boolean result=managerService.updateBook(book);
        if (result){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
