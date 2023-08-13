package com.example.nick.thacke.Movie.Ratings.api.create_account;

import com.example.nick.thacke.Movie.Ratings.model.User;
import com.example.nick.thacke.Movie.Ratings.service.create_account.LoginAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/login/account")
@RestController
public class LoginAccountController {

    private final LoginAccountService loginAccountService;

    public LoginAccountController(LoginAccountService loginAccountService) {
        this.loginAccountService = loginAccountService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestParam String username) {
        System.out.println("Attempting to login as " + username);
        int result = loginAccountService.login(new User(username));
        HttpStatus status = (result == LoginAccountService.OK) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(result == LoginAccountService.OK ? "Succesfully logged in" : "Username not found, cannot login");
    }
}
