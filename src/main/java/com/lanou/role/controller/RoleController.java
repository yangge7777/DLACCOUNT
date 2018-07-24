package com.lanou.role.controller;

import com.lanou.role.bean.Module;
import com.lanou.role.bean.Role;
import com.lanou.role.service.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/7/24.
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
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleServiceImpl service;
    @RequestMapping("/torole_list.do")
    public ModelAndView torole_list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role/role_list");
        modelAndView.addObject("roleshowlist", service.roleshow());

        return modelAndView;
    }

    @RequestMapping("/torole_add.do")
    public ModelAndView torole_add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role/role_add");

      return   modelAndView.addObject("modulelist", service.module_infoAll());
    }

    @RequestMapping("/insert_roleinfo_rolemodule.do")
    public ModelAndView insert_roleinfo_rolemodule(@RequestParam("rolename")String rolename, @RequestParam
            ("modeuleid")List<String> moduleid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role/role_list");
        Role role = new Role();
        role.setName(rolename);
       boolean flag = service.insert_roleinfo(role);

        for (String s : moduleid) {
            service.insert_rolemodule(rolename, s);
        }
        modelAndView.addObject("roleshowlist", service.roleshow());
        return modelAndView;

    }
    @RequestMapping("/update_roleinfo_rolemodule.do")
    public ModelAndView update_roleinfo_rolemodule(@RequestParam("rolename")String rolename,@RequestParam("moduleid")
        List<String> moduleid,@RequestParam("roleid")String roleid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role/role_list");
        service.update_role(rolename, roleid);
///        List<Module> modules = service.lastrole_Module(roleid);
        service.delete_role_moduleByroleid(roleid);
        for (String s : moduleid) {
            service.insert_rolemodule2(roleid, s);
        }
        modelAndView.addObject("roleshowlist", service.roleshow());
        return modelAndView;

    }



    @RequestMapping("/torole_modi.do")
    public ModelAndView torole_modi(HttpServletRequest request){
        String role_id = request.getParameter("role_id");
        String role_name = request.getParameter("name");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role/role_modi");
        Role role = new Role();
        role.setName(role_name);
        role.setRole_id(role_id);
       modelAndView.addObject("role", role);
        modelAndView.addObject("modulelist", service.module_infoAll());

        return modelAndView;
    }




















}
