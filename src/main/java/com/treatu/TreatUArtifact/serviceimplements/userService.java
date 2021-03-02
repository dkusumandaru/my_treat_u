/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.serviceimplements;

import static antlr.ANTLRTokdefParserTokenTypes.ID;
import com.sun.xml.bind.v2.model.core.ID;
import com.treatu.TreatUArtifact.entity.Department;
import com.treatu.TreatUArtifact.entity.Role;
import com.treatu.TreatUArtifact.entity.Users;
import com.treatu.TreatUArtifact.repository.userRepository;
import com.treatu.TreatUArtifact.serviceinterfaces.userServiceInterface;
import java.util.Optional;
import java.lang.String;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author creative
 */
@Transactional
@Service
public class userService implements userServiceInterface {

    @Autowired
    private userRepository uRepository;

    @Override
    public Iterable<Users> getAll() {
        return uRepository.findAll();

    }

    @Override
    public Optional<Users> getById(String id) {
        return uRepository.findById(id);
    }

    @Override
    public void deleleteById(String id) {
        uRepository.deleteById(id);
    }

    @Override
    public void save(Users user) {
        uRepository.save(user);
    }

    @Override
    public Users update(Users user) {
        return uRepository.save(user);
    }

}
