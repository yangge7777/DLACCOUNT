package com.lanou.business.bean;

/**
 * Created by dllo on 18/7/23.
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
public class SearchBusniess {
    private String OS_USERNAME,UNIX_HOST,idcard_no, status;

    @Override
    public String toString() {
        return "SearchBusniess{" +
                "OS_USERNAME='" + OS_USERNAME + '\'' +
                ", UNIX_HOST='" + UNIX_HOST + '\'' +
                ", idcard_no='" + idcard_no + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getOS_USERNAME() {
        return OS_USERNAME;
    }

    public void setOS_USERNAME(String OS_USERNAME) {
        this.OS_USERNAME = OS_USERNAME;
    }

    public String getUNIX_HOST() {
        return UNIX_HOST;
    }

    public void setUNIX_HOST(String UNIX_HOST) {
        this.UNIX_HOST = UNIX_HOST;
    }

    public String getIdcard_no() {
        return idcard_no;
    }

    public void setIdcard_no(String idcard_no) {
        this.idcard_no = idcard_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
