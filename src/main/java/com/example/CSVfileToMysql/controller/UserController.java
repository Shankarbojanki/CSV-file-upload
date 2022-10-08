package com.example.CSVfileToMysql.controller;


import com.example.CSVfileToMysql.dto.ResponseData;
import com.example.CSVfileToMysql.entity.Users;
import com.example.CSVfileToMysql.repository.UserRepository;
import com.example.CSVfileToMysql.service.UserService;
import com.example.CSVfileToMysql.utility.CSVHelper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;




    @PostMapping("/file/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,Users user) {

        try {


            Pair<List<Users>, List<Users>> processedInfo = userService.saveUsers(file);

            ResponseData response = new ResponseData();
            response.setStatus(true);
            response.getMessages().add("success  :" + file.getOriginalFilename());
            response.setData(processedInfo);
            return ResponseEntity.ok(response);

        }catch (Exception e) {
            System.out.println(e);
            ResponseData response = new ResponseData();
            response.setStatus(false);
            response.getMessages().add("can't upload file :" + file.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }


    }


    @GetMapping("/users")
    public List<Users> findAllUsers() {

            List<Users> users = userService.getAll();
            return users;
        }

    @GetMapping("/emails")
    public List<Users> findAllEmail() {

        List<Users> users = userService.getAllWEmail("email");
        return users;
    }

}








