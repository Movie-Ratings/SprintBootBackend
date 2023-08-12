package com.example.nick.thacke.Movie.Ratings.api.create_account;

import com.example.nick.thacke.Movie.Ratings.model.User;
import com.example.nick.thacke.Movie.Ratings.service.create_account.LoginAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("api/login/account")
@RestController
public class LoginAccountController {

    private final LoginAccountService loginAccountService;

    public LoginAccountController(LoginAccountService loginAccountService) {
        this.loginAccountService = loginAccountService;
    }

    @PostMapping
    public ResponseEntity<Integer> login(@RequestBody User user) {
        int result = loginAccountService.login(user);
        HttpStatus status = (result == LoginAccountService.OK) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(null);
    }
}
