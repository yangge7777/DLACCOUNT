package com.lanou.fee.controller;

import com.lanou.fee.bean.Cost;
import com.lanou.fee.service.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 18/7/16.
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
@RequestMapping("/fee")
public class FeeController {
    @Resource
    private FeeServiceImpl service;

    //展示资费表单所有内容
    @RequestMapping("/feelist.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fee/fee_list");
      return   modelAndView.addObject("costAll", service.cost_All());
    }
    //跳转资费增加界面
    @RequestMapping("/tofee_modi.do")
    public ModelAndView tofee_modi(HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("fee/fee_modi");
        return modelAndView.addObject("cost", service.cost_Byid(request.getParameter("method")));

    }
    //跳转到detail界面
    @RequestMapping("/tofee_detail.do")
    public ModelAndView tofee_detail(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fee/fee_detail");
        return modelAndView.addObject("cost",service.cost_Byid(request.getParameter("method")));
    }


    //修改资费中内容
    @RequestMapping(value = "/cost_update.do",method = RequestMethod.POST)
    public ModelAndView cost_update(Cost cost) {
        boolean flag = service.cost_update(cost);
        System.out.println(flag);
        ModelAndView modelAndView = new ModelAndView();
        if (flag){
            modelAndView.setViewName("fee/fee_list");
            return modelAndView.addObject("costAll", service.cost_All());
        }else {
            modelAndView.setViewName("fee/fee_modi");
            return modelAndView.addObject("msg", true);
        }

    }
    //向fee列表中增加数据
    @RequestMapping(value = "/cost_insert.do",method = RequestMethod.POST)
    public ModelAndView cost_insert(Cost cost){

        ModelAndView modelAndView = new ModelAndView();
        boolean flag = service.cost_insert(cost);
        if (flag){
            modelAndView.setViewName("fee/fee_list");
            return modelAndView.addObject("costAll", service.cost_All());
        }else {
            modelAndView.setViewName("fee/fee_add");
            return modelAndView.addObject("msg", true);
        }


    }

    //fee列表启用Byid
    @RequestMapping(value = "/cost_updateStatus.do")
    public ModelAndView cost_updateStatus(HttpServletRequest request){
        service.cost_updateStatus(request.getParameter("method"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fee/fee_list");
        return modelAndView.addObject("costAll", service.cost_All());
    }



    //删除fee列表某条数据
    @RequestMapping("/cost_delete.do")
    public ModelAndView cost_delete(HttpServletRequest request){
            service.cost_deleteByid(request.getParameter("method"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fee/fee_list");
        return modelAndView.addObject("costAll",service.cost_All() );
    }
    @RequestMapping("/tofee_add.do")
    public String tofee_add(){
        return "fee/fee_add";
    }






}
