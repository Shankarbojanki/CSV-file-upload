package com.example.CSVfileToMysql.service;

import com.example.CSVfileToMysql.entity.Users;
import com.example.CSVfileToMysql.repository.UserRepository;
import com.example.CSVfileToMysql.utility.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public Pair<List<Users>,List<Users>> saveUsers(MultipartFile file){
       try {
           List<Users> list = CSVHelper.csvToUsers(file.getInputStream());
           List<String> emails = list.stream().map(e -> e.getEmail()).collect(Collectors.toList());

           List<Users> existingUsers = userRepository.findByEmails(emails);

           HashSet<String> existingUserEmails = (HashSet<String>) existingUsers.stream().map(e -> e.getEmail()).collect(Collectors.toSet());
           List<Users> usersToInsert = new ArrayList<Users>();
           list.stream().forEach(u -> {
               if (!existingUserEmails.contains(u.getEmail())) {
                   usersToInsert.add(u);
               }
           });

           userRepository.saveAll(usersToInsert);


           Pair<List<Users>, List<Users>> result = Pair.of(existingUsers, usersToInsert);

           return result;

       }catch (IOException e){
           throw new RuntimeException("fail to store csv data: "+e.getMessage());
       }

    }
    public List<Users> getAll(){
      return userRepository.findAll();
    }

    public List<Users> getAllWEmail(String email){
        return (List<Users>) userRepository.findByEmail("email");
    }


    

  































}
