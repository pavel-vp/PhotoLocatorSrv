package com.mobileme.inhouse.serv.api;

import java.io.Serializable;

/**
 * Created by User on 30.08.2015.
 */
public class HSServiceInfo implements Serializable{

    private int serviceId;
    private String serviceName;


    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
