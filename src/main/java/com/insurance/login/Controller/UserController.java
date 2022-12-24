package com.insurance.login.Controller;

import com.insurance.login.Entity.User;
import com.insurance.login.Service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    private List getAllEmployees() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private User getEmployeeById(@PathVariable("id") int id) {
        return userService.getEmployeeById(id);
    }

    @PostMapping("/user")
    private ResponseEntity createUser(@RequestBody User user) {
        try {
            userService.saveOrUpdate(user);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New User created with id: " + user.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody String credentials) {
        JSONObject response = new JSONObject();
        try {
            JSONObject userCredentials = new JSONObject();
            JSONParser parser = new JSONParser();

            userCredentials = (JSONObject) parser.parse(credentials);

            response = userService.validate(userCredentials);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Login : " + response.get("Msg").toString(), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    private ResponseEntity deleteById(@PathVariable("id") int id) {
        try {
            userService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: " + id, HttpStatus.OK);
    }
}