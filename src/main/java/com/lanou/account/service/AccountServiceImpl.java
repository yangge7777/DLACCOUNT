package com.lanou.account.service;

import com.lanou.Page;
import com.lanou.account.bean.Account;
import com.lanou.account.bean.SeachAccount;
import com.lanou.account.dao.AccountMapper;
import com.lanou.excel.ReadExcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 18/7/18.
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
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper mapper;

    @Override
    public Page<Account> account_All() {
        Page<Account> page = new Page<>();
        page.setCurrentPage(1);
        page.setEveryPageCount(5);
        page.setList(mapper.account_All());
        page.setSize(mapper.account_Allcount());
        if (page.getSize()%page.getEveryPageCount() == 0 ){
            page.setPages(page.getSize()/page.getEveryPageCount());
        }else {

            page.setPages(page.getSize()/page.getEveryPageCount()+1);
        }


        return page;
    }

    @Override
    public Page<Account> account_search(SeachAccount seachAccount, Page<Account> page) {
        Page<Account> page1 = new Page<>();
        page1.setCurrentPage(page.getCurrentPage());
        page1.setEveryPageCount(page.getEveryPageCount());
        page1.setBeginData((page1.getCurrentPage()-1)*page1.getEveryPageCount());

        page1.setList(mapper.account_search(seachAccount,page1));
        page1.setSize(mapper.account_datacount(seachAccount));


        if (page1.getSize()%page1.getEveryPageCount() == 0 ){
           page1.setPages(page1.getSize()/page1.getEveryPageCount());
        }else {

            page1.setPages(page1.getSize()/page1.getEveryPageCount()+1);
        }

        return page1;
    }
    //开通
    @Override
    public boolean account_status1(String id) {
       try {
           //delete pause_date
           mapper.account_cleartime(id,"pause_date");
           //status1
           mapper.account_Status(id,"1");
           return true;
       }catch (Exception e){
           return false;
       }

    }
    //暂停
    @Override
    public boolean account_status2(String id) {
        Account account = new Account();
        account.setPause_date(currenttime());
        account.setid(id);
     try {
            //status 2
            mapper.account_Status(id,"2");
            //pause_date
            mapper.account_changetime(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //删除
    @Override
    public boolean account_status3(String id) {
        Account account = new Account();
        account.setClose_date(currenttime());
        account.setid(id);

        try {
            //status 3
            mapper.account_Status(id,"3");
            //close_date
            mapper.account_changetime(account);

            return true;
        }catch (Exception e){
            return false;
        }




    }

    @Override
    public Account account_Byid(String id) {
        return mapper.account_Byid(id);
    }

    @Override
    public int account_datacount(SeachAccount seachAccount) {
        return mapper.account_datacount(seachAccount);
    }

    @Override
    public List<Account> getUserForExcel() {
        return mapper.getUserForExcel();
    }

    @Override
    public String readExcelFile(MultipartFile file) {
        String result = "";
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        List<Account> accountList = readExcel.getExcelInfo(file);
        for (Account account : accountList) {
            System.out.println(account==null);
        }
        if (accountList != null &&!accountList.isEmpty()){
            result = "上传成功";
        }else {
            result = "上传失败";
        }
        return result;
    }

    //系统当前时间
    public String currenttime (){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

}
