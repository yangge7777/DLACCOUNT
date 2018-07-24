package com.lanou.role.service;

import com.lanou.role.bean.Module;
import com.lanou.role.bean.Role;
import com.lanou.role.bean.RoleShow;
import com.lanou.role.dao.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper mapper;
    @Override
    public List<Module> module_infoAll() {
      return   mapper.module_infoAll();
    }

    @Override
    public boolean insert_roleinfo(Role role) {
        try{
            mapper.insert_roleinfo(role);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean insert_rolemodule(String role_name, String module_id) {
        try{
            mapper.insert_rolemodule(role_name,module_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<RoleShow> roleshow() {
        return mapper.roleshow();
    }

    @Override
    public boolean update_role(String role_name, String role_id) {
        try{
            mapper.update_role(role_name,role_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Module> lastrole_Module(String role_id) {
        return mapper.lastrole_Module(role_id);
    }

    @Override
    public boolean update_role_module(String role_id, String module_id, String lastmodule_id) {
        try{
            mapper.update_role_module(role_id,module_id,lastmodule_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete_role_moduleByroleid(String role_id) {
        try{
            mapper.delete_role_moduleByroleid(role_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean insert_rolemodule2(String role_id, String module_id) {
        try{
            mapper.insert_rolemodule2(role_id,module_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
