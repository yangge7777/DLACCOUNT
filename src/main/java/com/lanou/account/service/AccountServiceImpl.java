package com.lanou.account.service;

import com.lanou.account.bean.Account;
import com.lanou.account.bean.SeachAccount;
import com.lanou.account.dao.AccountMapper;
import org.springframework.stereotype.Service;

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
    public List<Account> account_All() {
        return mapper.account_All();
    }

    @Override
    public List<Account> account_search(SeachAccount seachAccount) {
        return mapper.account_search(seachAccount);
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

    //系统当前时间
    public String currenttime (){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

}
