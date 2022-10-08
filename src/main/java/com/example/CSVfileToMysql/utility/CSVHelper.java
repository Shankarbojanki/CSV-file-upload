package com.example.CSVfileToMysql.utility;


import com.example.CSVfileToMysql.entity.Users;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {

    public static final String TYPE ="text/csv";


    public static boolean hasCSVFormat(MultipartFile file){
        if (!TYPE.equals(file.getContentType())){
            return false;
        }
        return true;
    }

    public static List<Users> csvToUsers(InputStream is){


        int  age;
        Long id,mobile;
        String first_name,last_name,email,gender,username,address;
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser parser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<Users> users=new ArrayList<>();


            Iterable<CSVRecord> csvRecords =parser.getRecords();

            for (CSVRecord csvRecord:csvRecords){

                Users user = new Users();
                user.setId(Long.parseLong(csvRecord.get("id")));
                user.setFirst_name(csvRecord.get("first_name"));
                try {
                    user.setId(Long.parseLong(csvRecord.get("id")));
                }catch (Exception e){
                    id= Long.valueOf(0);
                }
                try {
                    user.setFirst_name(csvRecord.get("first_name"));
                }catch (Exception e){
                    first_name=null;
                }
                try {
                    user.setLast_name(csvRecord.get("last_name"));
                }catch (Exception e){
                    last_name=null;
                }
               try {
                   user.setEmail(csvRecord.get("email"));
               }catch (Exception e){
                   email=null;
               }
               try {
                   user.setGender(csvRecord.get("gender"));
               }catch (Exception e){
                   gender=null;
               }
                try {
                    user.setUsername(csvRecord.get("username"));
                }catch (Exception e){
                    username=null;
                }
               try {
                   user.setAge(Integer.parseInt(csvRecord.get("age")));
               }catch (Exception e){
                   age=0;
               }
               try {
                   user.setAddress(csvRecord.get("address"));
               }catch (Exception e){
                   address=null;
               }
              try {
                  user.setMobile(Long.valueOf(csvRecord.get("mobile")));
              }catch (Exception e){
                  mobile= Long.valueOf(0);
              }
                users.add(user);
            }
            parser.close();
            return users;



        }catch (IOException e){
            throw new RuntimeException("fail to parse CSV file: "+e.getMessage());
        }

    }



}


