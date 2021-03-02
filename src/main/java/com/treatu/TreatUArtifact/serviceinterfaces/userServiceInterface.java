/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.serviceinterfaces;

import com.sun.xml.bind.v2.model.core.ID;
import com.treatu.TreatUArtifact.entity.Department;
import com.treatu.TreatUArtifact.entity.Role;
import com.treatu.TreatUArtifact.entity.Users;
import java.util.Optional;

/**
 *
 * @author creative
 */
public interface userServiceInterface {
    Iterable<Users> getAll(); 
    Optional<Users> getById(String id);
    void deleleteById(String id);
    void save(Users user);
    public Users update(Users user);
    
}

