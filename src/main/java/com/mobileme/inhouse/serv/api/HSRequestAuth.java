package com.mobileme.inhouse.serv.api;

import java.io.Serializable;

/**
 * Created by User on 30.08.2015.
 */
public class HSRequestAuth implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
