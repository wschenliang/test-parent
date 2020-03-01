package com.snail.test.contorller;

import com.snail.test.pojo.User;
import com.snail.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> test(@RequestParam("name") String name){
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> all(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
