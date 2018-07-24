package com.lanou.account.dao;

import com.lanou.Page;
import com.lanou.account.bean.Account;
import com.lanou.account.bean.SeachAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Repository
public interface AccountMapper {
    List<Account> account_All();
    int account_Allcount();
    //查询searchaccount
    List<Account> account_search(@Param("a") SeachAccount seachAccount,@Param("p") Page<Account> page);
    //status 1 开通 2 暂停 3 删除
    void account_Status(@Param("id") String id, @Param("status") String changeStatus);

    //account总页数
    int account_datacount(SeachAccount seachAccount);
    //account time
    void account_changetime(Account account);

    //clear account time
    void account_cleartime(@Param("id")String id ,@Param("time")String time);

    //查询account by id
    Account account_Byid(String id);
    /**
     * 根据查询条件查询出所有的记录,不用分页,用于excel导出功能
     */
    List<Account> getUserForExcel();

}
