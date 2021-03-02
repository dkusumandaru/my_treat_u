/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.controller;

import com.treatu.TreatUArtifact.entity.Role;
import com.treatu.TreatUArtifact.serviceimplements.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author D
 */
@Controller
public class roleController {
    
    @Autowired
    roleService rService;
    
    @GetMapping("/roles")
    public String home(Model roleModel) {
        
        Iterable<Role> roles = rService.getAll();
        roleModel.addAttribute("roles", roles);
        
        System.out.println("roles");
        System.out.println(roles);
        return "roles/v_page";
    }
    
    public String home(Model roleModel) {
        
        Iterable<Role> roles = rService.getAll();
        roleModel.addAttribute("roles", roles);
        
        System.out.println("roles");
        System.out.println(roles);
        return "roles/v_page";
    }
    
}
