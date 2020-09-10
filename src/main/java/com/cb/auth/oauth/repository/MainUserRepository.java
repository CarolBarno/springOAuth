/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.oauth.repository;

import com.cb.auth.oauth.entity.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MainUserRepository extends JpaRepository<MainUser, Long>{
    
}
