/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.serviceimplements;

import com.treatu.TreatUArtifact.entity.Role;
import com.treatu.TreatUArtifact.entity.Users;
import com.treatu.TreatUArtifact.repository.roleRepository;
import com.treatu.TreatUArtifact.repository.userRepository;
import com.treatu.TreatUArtifact.serviceinterfaces.roleServiceInterface;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author creative
 */
@Service
public class roleService implements roleServiceInterface{
    @Autowired
    private roleRepository rRepository;    

    @Override
    public Iterable<Role> getAll() {
        return rRepository.findAll();  
    }
    
    @Override
    public Optional<Role> getById(String id) {
        return rRepository.findById(id);
    }

    @Override
    public void deleleteById(String id) {
        rRepository.deleteById(id);
    }

    @Override
    public void save(Role role) {
        rRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return rRepository.save(role);
    }

    
    
}
