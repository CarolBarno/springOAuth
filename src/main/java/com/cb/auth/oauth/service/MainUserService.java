/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.oauth.service;

import com.cb.auth.oauth.entity.MainUser;
import com.cb.auth.oauth.repository.MainUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainUserService {

    @Autowired
    private MainUserRepository mainUserRepository;

    @Transactional
    public MainUser saveUser(MainUser mainUser) {
        return mainUserRepository.save(mainUser);
    }

    @Transactional
    public MainUser updateUser(MainUser user) {
        return mainUserRepository.save(user);
    }

    public Page<MainUser> fetchUsers(Pageable pageable) {
        return mainUserRepository.findAll(pageable);
    }

//    public MainUser fetchById(Long id) {
//        return mainUserRepository.findById(id)
//                .orElseThrow(() -> APIException.notFound("Cooperate driver identified by id {0} not found", id));
//    }
    
    @Transactional
    public void deleteUser(Long id) {
        mainUserRepository.deleteById(id);
    }

}
