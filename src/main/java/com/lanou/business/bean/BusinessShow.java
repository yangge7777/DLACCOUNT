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
public class BusinessShow {
    private String SERVICEID;
    private String id;
    private String idcard_no;
    private String real_name;
    private String OS_USERNAME;
    private String STATUS;
    private String UNIX_HOST;
    private String name;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    private String descr;

    @Override
    public String toString() {
        return "BusinessShow{" +
                "SERVICEID='" + SERVICEID + '\'' +
                ", id='" + id + '\'' +
                ", idcard_no='" + idcard_no + '\'' +
                ", real_name='" + real_name + '\'' +
                ", OS_USERNAME='" + OS_USERNAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", UNIX_HOST='" + UNIX_HOST + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }

    public String getSERVICEID() {
        return SERVICEID;
    }

    public void setSERVICEID(String SERVICEID) {
        this.SERVICEID = SERVICEID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcard_no() {
        return idcard_no;
    }

    public void setIdcard_no(String idcard_no) {
        this.idcard_no = idcard_no;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getOS_USERNAME() {
        return OS_USERNAME;
    }

    public void setOS_USERNAME(String OS_USERNAME) {
        this.OS_USERNAME = OS_USERNAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getUNIX_HOST() {
        return UNIX_HOST;
    }

    public void setUNIX_HOST(String UNIX_HOST) {
        this.UNIX_HOST = UNIX_HOST;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
