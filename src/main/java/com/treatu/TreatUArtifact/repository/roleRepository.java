/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.repository;

import com.treatu.TreatUArtifact.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author creative
 */
@Repository
public interface roleRepository extends CrudRepository<Role, String> {

}
