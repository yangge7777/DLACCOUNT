package com.lanou.account.service;

import com.lanou.Page;
import com.lanou.account.bean.Account;
import com.lanou.account.bean.SeachAccount;
import org.springframework.web.multipart.MultipartFile;

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
public interface AccountService {
    Page<Account> account_All();

    //查询searchaccount
    Page<Account> account_search(SeachAccount seachAccount, Page<Account> page);

    //更改account状态1开通
    boolean account_status1(String id);
    //更改account状态2暂停
    boolean account_status2(String id);
    //更改account状态3删除
    boolean account_status3(String id);
    //查询account by id
    Account account_Byid(String id);

    //account总页数
    int account_datacount(SeachAccount seachAccount);
    /**
     * 根据查询条件查询出所有的记录,不用分页,用于excel导出功能
     */
    List<Account> getUserForExcel();
    //把excel导入到database
    String readExcelFile( MultipartFile file);

}
