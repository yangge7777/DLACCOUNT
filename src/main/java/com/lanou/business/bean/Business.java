package com.lanou.business.bean;

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
public class Business {
    private String SERVICEID,ACCOUNT_ID,UNIX_HOST,OS_USERNAME,LOGIN_PASSWD,STATUS,CREATE_DATE,PAUSE_DATE,CLOSE_DATE,COST_ID;

    @Override
    public String toString() {
        return "Business{" +
                "SERVICEID='" + SERVICEID + '\'' +
                ", ACCOUNT_ID='" + ACCOUNT_ID + '\'' +
                ", UNIX_HOST='" + UNIX_HOST + '\'' +
                ", OS_USERNAME='" + OS_USERNAME + '\'' +
                ", LOGIN_PASSWD='" + LOGIN_PASSWD + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CREATE_DATE='" + CREATE_DATE + '\'' +
                ", PAUSE_DATE='" + PAUSE_DATE + '\'' +
                ", CLOSE_DATE='" + CLOSE_DATE + '\'' +
                ", COST_ID='" + COST_ID + '\'' +
                '}';
    }

    public String getSERVICEID() {
        return SERVICEID;
    }

    public void setSERVICEID(String SERVICEID) {
        this.SERVICEID = SERVICEID;
    }

    public String getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public void setACCOUNT_ID(String ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public String getUNIX_HOST() {
        return UNIX_HOST;
    }

    public void setUNIX_HOST(String UNIX_HOST) {
        this.UNIX_HOST = UNIX_HOST;
    }

    public String getOS_USERNAME() {
        return OS_USERNAME;
    }

    public void setOS_USERNAME(String OS_USERNAME) {
        this.OS_USERNAME = OS_USERNAME;
    }

    public String getLOGIN_PASSWD() {
        return LOGIN_PASSWD;
    }

    public void setLOGIN_PASSWD(String LOGIN_PASSWD) {
        this.LOGIN_PASSWD = LOGIN_PASSWD;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getPAUSE_DATE() {
        return PAUSE_DATE;
    }

    public void setPAUSE_DATE(String PAUSE_DATE) {
        this.PAUSE_DATE = PAUSE_DATE;
    }

    public String getCLOSE_DATE() {
        return CLOSE_DATE;
    }

    public void setCLOSE_DATE(String CLOSE_DATE) {
        this.CLOSE_DATE = CLOSE_DATE;
    }

    public String getCOST_ID() {
        return COST_ID;
    }

    public void setCOST_ID(String COST_ID) {
        this.COST_ID = COST_ID;
    }
}
