package com.insurance.login.Service;

import com.insurance.login.Entity.User;
import com.insurance.login.Repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getEmployeeById(int id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public JSONObject validate(JSONObject userCreds) {
        User user = userRepository.findByUsername(userCreds.get("username").toString());
        JSONObject response = new JSONObject();
        if(user.getPassword().equals(userCreds.get("password").toString())){
            System.out.println("Login Successful");
            response.put("Msg","Success");
        }
        else{
            System.out.println("Login failed... Please Try Again");
            response.put("Msg","Failed");
        }
        return response;
    }




    public void delete(int id) {
        userRepository.deleteById(id);
    }
}