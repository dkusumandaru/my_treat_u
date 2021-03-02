/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.treatu.TreatUArtifact.entity.Users;
import java.util.Optional;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author creative
 */
@Repository
public interface userRepository extends CrudRepository<Users, String>{
}
