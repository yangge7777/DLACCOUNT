package com.lanou.role.dao;

import com.lanou.role.bean.Module;
import com.lanou.role.bean.Role;
import com.lanou.role.bean.RoleShow;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Repository
public interface RoleMapper {
    //modulelist
    List<Module> module_infoAll();
    void insert_roleinfo(Role role);

    void insert_rolemodule(@Param("role_name")String role_name,@Param("module_id")String module_id);
   List<RoleShow> roleshow();

    //update_role
    void update_role(@Param("role_name") String role_name, @Param("role_id") String role_id);
    List<Module> lastrole_Module(String role_id);
    void update_role_module(@Param("role_id")String role_id,@Param("module_id")String module_id
    ,@Param("lastmodule_id")String lastmodule_id);

    void delete_role_moduleByroleid(String role_id);

    void insert_rolemodule2(@Param("role_id") String role_id, @Param("module_id") String module_id);
}
