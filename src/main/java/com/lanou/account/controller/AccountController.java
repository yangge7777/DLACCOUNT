package com.lanou.account.controller;

import com.lanou.account.bean.SeachAccount;
import com.lanou.account.service.AccountServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountServiceImpl service;


    //查询accountList
    @RequestMapping("/accountlist.do")
    public ModelAndView account_All() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/account_list");
        return modelAndView.addObject("accountAll", service.account_All());

    }

    //搜索栏
    @RequestMapping(value = "/accountSearch.do",method = RequestMethod.POST )
    public ModelAndView accountSearch(SeachAccount seachAccount){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/account_list");
        ModelMap modelMap = new ModelMap();
        modelAndView.addObject("accountAll", service.account_search(seachAccount));
        modelAndView.addObject("searchAccount", seachAccount);
     return    modelAndView.addAllObjects(modelMap);
//        return modelAndView.addObject("accountAll", service.account_search(seachAccount));

    }

    //params测试
    @RequestMapping(value = "/accountStatus.do",params = {"status=1"})
    public ModelAndView accountStatus1(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/account_list");
        //
        service.account_status1(id);
    return     modelAndView.addObject("accountAll", service.account_All());
    }


    //更改account状态status
    @RequestMapping(value = "/accountStatus{status}.do")
    public ModelAndView accountStatus2(@PathVariable("status")String status,String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/account_list");
       switch (status){
           case "1":
               service.account_status1(id);
               break;
           case "2":service.account_status2(id);
               break;
           case "3":service.account_status3(id);
               break;
       }
        return     modelAndView.addObject("accountAll", service.account_All());
    }


    //params测试
    @RequestMapping(value = "/accountStatus.do",params = {"status=2"})
    public ModelAndView accountStatus3(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/account_list");
        //
        service.account_status3(id);
        return     modelAndView.addObject("accountAll", service.account_All());
    }

    //去account_detail
    @RequestMapping(value = "/toaccount_detail.do")
    public ModelAndView toaccount_detail(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/account_detail");
        return modelAndView.addObject("account", service.account_Byid(request.getParameter("method")));
    }

    }

