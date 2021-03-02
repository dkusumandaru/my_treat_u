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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author D
 */
@Controller
public class roleController {
    
    @Autowired
    roleService rService;
    
    @GetMapping("/roles")
    public String getRole(Model roleModel) {
        
        Iterable<Role> roles = rService.getAll();
        roleModel.addAttribute("roles", roles);
        
        Role role = new Role();
        roleModel.addAttribute("addRole", role);
       
        roleModel.addAttribute("editRole", role);  
        
        return "roles/v_page";
    }
    
    
    @PostMapping("/roles/add")
    public String addRole(@ModelAttribute("addRole") Role role){
        System.out.println("Here ^_^");
        System.out.println(role);
        this.rService.save(role);
        return "redirect:/roles";
    }
    
    @PostMapping("/roles/edit")
    public String editRole(@ModelAttribute("editRole") Role role){
        System.out.println("Here ^_^");
        System.out.println(role);
        this.rService.save(role);
        return "redirect:/roles";
    }
    
}
