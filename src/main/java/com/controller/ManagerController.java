package com.controller;

import com.entity.Author;
import com.entity.Book;
import com.entity.BookType;
import com.entity.BrrowInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.LoginAndRegisterService;
import com.service.ManagerService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    LoginAndRegisterService loginAndRegisterService;
    /**
     * url:/Manager/getBrrowInfoByAccount
     * 传参：account
     * 属性：String
     * 通过账户查询具体某个账户订单
     * @param account
     * @return
     */
    @RequestMapping("/getBrrowInfoByAccount")
    @ResponseBody
    public Msg getBrrowInfoByAccount(String account){
        //检查用户是否存在
        Boolean result=loginAndRegisterService.checkRegister(account);
        if (result) {
            List<BrrowInfo> brrowInfos=managerService.getBrrowInfoByAccount(account);
            if (!brrowInfos.isEmpty()){
                return Msg.success().add("brrowinfobyaccount",brrowInfos);
            }else {
                return Msg.fail().add("err_msg","该用户不存在订单！");
            }
        }else {
            return Msg.fail().add("err_msg","用户不存在");
        }
    }
    /**
     * url:/Manager/getBrrowInfo
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
     * http://localhost:8080/Manager/getBookById
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
     * http://localhost:8080/Manager/getBookByName
     * 通过书名模糊查找
     * @param bookName
     * @return
     */
    @RequestMapping("/getBookByName")
    @ResponseBody
    public Msg getBookByName(String bookName){
        if (bookName!=null){
            List<Book> books=managerService.getBookByName(bookName);
            return Msg.success().add("bookByName",books);
        }else {
            return Msg.fail();
        }
    }
    /**
     * http://localhost:8080/Manager/getBooks?pn=x
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
     * http://localhost:8080/Manager/getBookType
     * 在增加book之前先获取booktype，以下拉列表显示
     * @return
     */
    @RequestMapping("/getBookType")
    @ResponseBody
    public Msg getBookType(){
        List<BookType> bookType =managerService.getBookType();
        return Msg.success().add("booktype",bookType);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Msg upload(MultipartFile file) throws IOException {
        String path=null;
        if (file!=null){
            String oldName=file.getOriginalFilename();
            if (oldName!=null&&oldName.length()>0){
                String newName= UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
                file.transferTo(new File("E:\\SSM\\library\\picture\\"+newName));
                path="/pic/"+newName;
                return Msg.success().add("path",path);
            }else {
                return Msg.fail().add("err_msg","文件名为空");
            }
        }else {
            return Msg.fail().add("err_msg","文件为空！");
        }
    }

    /**
     * 添加图书
     * http://localhost:8080/Manager/addBookAndAuthor
     *
     * @param book
     * @param author
     * @return
     */
    @RequestMapping("/addBookAndAuthor")
    @ResponseBody
    public Msg addBook(Book book, Author author){
        boolean result=managerService.addBookAndAuthor(book,author);
        if (result){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    /**
     * http://localhost:8080/Manager/deleteBook/xx-xx-xx
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
     * http://localhost:8080/Manager/updateBookAndAuthor
     * 更新图书信息
     * 点击每个图书的更新按钮 可以获得book_id，author_id并绑定到要修改的数据中一起传回来
     * @param book
     * @return
     */
    @RequestMapping("/updateBookAndAuthor")
    @ResponseBody
    public Msg updateBookAndAuthor(Book book,Author author) {

        boolean result=managerService.updateBook(book,author);
        if (result){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
