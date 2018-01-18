package com.mobileme.inhouse.serv.api;

import java.io.Serializable;

/**
 * Structure stored all need preferences from server
 * Created by User on 27.08.2015.
 */
public class HSRespPrefs implements Serializable{

    // api version
    private String apiVersion;

    // company info
    private String companyinfo;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getCompanyinfo() {
        return companyinfo;
    }

    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo;
    }


}
