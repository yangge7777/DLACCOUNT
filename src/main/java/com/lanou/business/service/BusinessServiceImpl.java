package com.lanou.business.service;




import com.lanou.Page;
import com.lanou.business.bean.Business;
import com.lanou.business.bean.BusinessShow;
import com.lanou.business.bean.SearchBusniess;
import com.lanou.business.dao.BusinessMapper;
import com.lanou.fee.bean.Cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessMapper mapper;
    @Override
    public Map<String ,Object> accountAll_byidcard_no(String idcard_no) {
        Map<String, Object> accountMap = new HashMap<>();
        if (mapper.accountAll_byidcard_no(idcard_no)!=null){
            accountMap.put("data", mapper.accountAll_byidcard_no(idcard_no));

            accountMap.put("code", true);
            return accountMap;
        }else {
            accountMap.put("code", false);
            accountMap.put("data", null);
            return accountMap;
        }
    }

    @Override
    public List<Cost> costname_Bystatus1() {
        return mapper.costname_Bystatus1();
    }

    @Override
    public boolean insert_service(Business business) {
        try {
            //      UNIX_HOST='114.114.114.114', OS_USERNAME='dsa', LOGIN_PASSWD='dsa',COST_ID='4',ACCOUTN_ID='4'
            business.setSTATUS("1");
            business.setCREATE_DATE(currenttime());

            mapper.insert_service(business);
            return true;
        }catch (Exception e){
            return false;
        }





    }

    @Override
    public Page<BusinessShow> service_show() {
        Page<BusinessShow> page = new Page<BusinessShow>();
        page.setCurrentPage(1);
        page.setEveryPageCount(5);
        page.setList(mapper.service_show());
        page.setSize(mapper.service_count());
        if (page.getSize()%page.getEveryPageCount()==0){
            page.setPages(page.getSize()/page.getEveryPageCount());
        }else {
            page.setPages(page.getSize()/page.getEveryPageCount()+1);
        }
        return page;
    }

    @Override
    public Page<BusinessShow> service_search(SearchBusniess searchBusniess, Page<BusinessShow> page) {
        Page<BusinessShow> page1 = new Page<>();
        page1.setCurrentPage(page.getCurrentPage());
        page1.setEveryPageCount(page.getEveryPageCount());
        page1.setBeginData((page1.getCurrentPage() - 1) * page1.getEveryPageCount());
        page1.setList(mapper.searchlist(searchBusniess,page1));
        page1.setSize(mapper.search_service_count(searchBusniess));
        if (page1.getSize()%page1.getEveryPageCount() == 0 ){
            page1.setPages(page1.getSize()/page1.getEveryPageCount());
        }else {

            page1.setPages(page1.getSize()/page1.getEveryPageCount()+1);
        }

        return page1;
    }

    //系统当前时间
    public String currenttime (){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
