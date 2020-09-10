/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.oauth.data;

import com.cb.auth.oauth.entity.MainUser;
import lombok.Data;

@Data
public class MainUserData {

    private String email;
    private String username;
    private String name;
    private boolean enabled;

    public static MainUser map(MainUserData data) {
        MainUser mainUser = new MainUser();

        return mainUser;
    }

    public static MainUserData map(MainUser user) {
        MainUserData data = new MainUserData();

        data.setEmail(user.getEmail());
        data.setEnabled(user.isEnabled());
        data.setName(user.getName());
        data.setUsername(user.getUsername());

        return data;
    }
}
