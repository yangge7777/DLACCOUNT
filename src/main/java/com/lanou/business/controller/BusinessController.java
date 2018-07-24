package com.lanou.business.controller;

import com.lanou.Page;
import com.lanou.account.bean.Account;
import com.lanou.business.bean.Business;
import com.lanou.business.bean.BusinessShow;
import com.lanou.business.bean.SearchBusniess;
import com.lanou.business.service.BusinessServiceImpl;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 18/7/21.
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
@RequestMapping("/bus")
public class BusinessController {
    @Resource
    private BusinessServiceImpl service;

    @RequestMapping("/toservice_list.do")
    public ModelAndView toservice_list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("service/service_list");
        modelAndView.addObject("serviceAll", service.service_show());

        return modelAndView;
    }

    @RequestMapping("/toservice_add.do")
    public ModelAndView toservice_add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("service/service_add");
        modelAndView.addObject("costselect", service.costname_Bystatus1());
        return modelAndView;
    }
  @RequestMapping(value = "/rilegou.do",method = RequestMethod.POST)
  @ResponseBody
    public Map<String, Object> accountAll_Byidcard_no (@RequestParam("idcard_no") String idcard_no ){
      return   service.accountAll_byidcard_no(idcard_no);
  }

  @RequestMapping(value = "insert_service.do",method = RequestMethod.POST)
  @ResponseBody
    public Map<String ,Object>  insert_service(Business business) {
     boolean flag= service.insert_service(business);
      Map<String, Object> map = new HashMap<>();
      if (flag){
          map.put("flag", true);
      }else {
          map.put("flag", false);
      }
      return map;
  }

  @RequestMapping(value = "/searchService.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> searchService(SearchBusniess searchBusniess){

      ModelAndView modelAndView = new ModelAndView();
//      modelAndView.setViewName("service/service_list");
      Page<BusinessShow> page = new Page();
      //页面初始化1
      page.setCurrentPage(1);

      //每页显示条数?
      page.setEveryPageCount(5);
      Map<String, Object> map = new HashMap<>();
      map.put("serviceAll", service.service_search(searchBusniess, page));
      System.out.println(searchBusniess);

      for (BusinessShow businessShow : service.service_search(searchBusniess, page).getList()) {
          System.out.println(businessShow);
      }
      map.put("searchBusniess", searchBusniess);
      return map;

  }


















}
