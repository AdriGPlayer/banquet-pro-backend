package aobytes.banquetpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aobytes.banquetpro.dto.UserDTO;
import aobytes.banquetpro.service.UserService;

@RestController
@RequestMapping("/banquetpro/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO dto) {
        userService.saveUser(dto);
        return ResponseEntity.ok("User saved successfully");
    }
}
