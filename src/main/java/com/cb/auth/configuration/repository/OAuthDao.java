/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.configuration.repository;

import com.cb.auth.configuration.entity.UserEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CipherCom
 */
@Repository
public class OAuthDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEntity getUserDetails(String username) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        String userSQLQuery = "SELECT * FROM USERS WHERE USERNAME=?";
        List<UserEntity> list = jdbcTemplate.query(userSQLQuery, new String[]{username},
                (ResultSet rs, int rowNum) -> {

                    UserEntity user = new UserEntity();
                    user.setUsername(username);
                    user.setPassword(rs.getString("PASSWORD"));
                    return user;
                });
        if (list.size() > 0) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthoritiesList.add(grantedAuthority);
            list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
            return list.get(0);
        }
        return null;
    }
}