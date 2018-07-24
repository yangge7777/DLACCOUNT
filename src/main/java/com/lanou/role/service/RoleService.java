package com.lanou.role.service;

import com.lanou.role.bean.Module;
import com.lanou.role.bean.Role;
import com.lanou.role.bean.RoleShow;
import org.apache.ibatis.annotations.Param;

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
public interface RoleService {
    //modulelist
    List<Module> module_infoAll();

    boolean insert_roleinfo(Role role);
    boolean insert_rolemodule(String role_name,String module_id);
   List<RoleShow>  roleshow();

    boolean update_role(String role_name, String role_id);
    List<Module> lastrole_Module(String role_id);

    boolean update_role_module(String role_id, String module_id, String lastmodule_id);
    boolean delete_role_moduleByroleid(String role_id);

    boolean insert_rolemodule2(String role_id, String module_id);
}
