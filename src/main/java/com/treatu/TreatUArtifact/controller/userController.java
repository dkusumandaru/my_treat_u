/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.controller;

import com.treatu.TreatUArtifact.entity.Role;
import com.treatu.TreatUArtifact.entity.Users;
import com.treatu.TreatUArtifact.serviceimplements.roleService;
import com.treatu.TreatUArtifact.serviceimplements.userService;
import java.util.Optional;
import static javax.swing.text.html.HTML.Tag.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author creative
 */
@Controller
@RequestMapping
public class userController {

    @Autowired
    userService uService;
    
    @Autowired
    roleService rService;
    /**
     *
     * @return
     */

    @GetMapping("/register")
    public String showForm(Model model){
        Users user = new Users();
        //Role role = new Role();
        
        // DOWNLOAD DEVTOOL
        Iterable<Role> roles = rService.getAll();
//        for (Role roleList : roles) {
//            System.out.println("employees firstname = " + roleList.getRoleName());
//        }
        //List<String> listRole = new ArrayList<String>();
//        List<Integer> listRole = Arrays.asList(1,2,3);
//        List<Integer> listDeparement = Arrays.asList(1,2);
        model.addAttribute("user",user);
        model.addAttribute("role",roles);
        //model.addAttribute("listRole",listRole);
        //model.addAttribute("listDepartment",listDeparement);
        System.out.println(roles);
        return "register_form";
    }
    
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") Users user){
        System.out.println(user);
        return "resgister_success";
    }
    
    
        
    @GetMapping("/thisishome")
    public String home(Model model) {
        Iterable<Users> users = uService.getAll();
//        for (Users userList : users) {
//            System.out.println("employees firstname = " + userList.getFirstName());
//            model.addAttribute("index", users);
//        }
        return "index";

    }
    @GetMapping("/home")
    public String home() {
        System.out.println("home");
        return "user/v_page_home";
    }
    
    @GetMapping("/login")
    public String login() {
        System.out.println("Login");
        return "user/v_page_login";

    }

    @GetMapping("/dashboard")
    public String dashboard() {
        System.out.println("dashboard");
        return "user/v_page_dashboard";
    }    
    
    @GetMapping("/thisisbayu")
    public String getAllEmployee(Model model) {

        Iterable<Users> users = uService.getAll();
        model.addAttribute("users",users);
        
        for (Users userList : users) {
            System.out.println("employees firstname = " + userList.getFirstName());
            //model.addAttribute("index", users);
        }
        return "index";
    }

    @GetMapping("/getbyid/{id}")
    public String getAllEmployeeById(Model model) {
        Optional<Users> users = uService.getById("id");
        System.out.println("Employee First Name : " + users.get().getFirstName());
        return "index";
    }


}
