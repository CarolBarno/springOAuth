/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.configuration.service;

import com.cb.auth.configuration.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author CipherCom
 */
public class CustomUser extends User {

    private static final long serialVersionUID = 1L;

    public CustomUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
    }

}
