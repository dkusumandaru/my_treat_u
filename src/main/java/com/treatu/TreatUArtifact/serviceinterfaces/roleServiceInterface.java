/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.serviceinterfaces;

import com.treatu.TreatUArtifact.entity.Role;
import java.util.Optional;

/**
 *
 * @author creative
 */
public interface roleServiceInterface {
    Iterable<Role> getAll(); 
    Optional<Role> getById(String id);
    void deleleteById(String id);
    void save(Role role);
    public Role update(Role role);
}
