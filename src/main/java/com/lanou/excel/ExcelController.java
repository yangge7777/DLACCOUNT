package com.lanou.excel;

import com.lanou.account.bean.Account;
import com.lanou.account.service.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dllo on 18/7/20.
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
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private AccountServiceImpl service;


    @RequestMapping("/abc.do")
    public void zbv(HttpServletRequest request,HttpServletResponse response,String queryJson){

        List<Account> accountList = service.getUserForExcel();
        ExportExcel<Account> acc=new ExportExcel<Account>();
        String [] headers ={"序号","推荐人id","登录用户名","登录密码","账号状态","创建日期"
        ,"暂停日期","删除日期","真实姓名","身份证","生日","gender","occupation","电话","邮箱"
        ,"mailaddress","zipcode","qq","last_login_time","last_login_ip"};
        String fileName = "账务账号信息表";
        acc.exportExcel(headers,accountList,fileName,response);
    }




    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value="file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String result = service.readExcelFile(file);
        return result;
    }






















}
