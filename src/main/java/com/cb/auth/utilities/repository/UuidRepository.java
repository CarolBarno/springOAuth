/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.repository;

import com.cb.auth.utilities.domain.Identifiable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UuidRepository<T extends Identifiable> extends JpaRepository<T, Long> {

    Optional<T> findByUuid(String uuid);
}
