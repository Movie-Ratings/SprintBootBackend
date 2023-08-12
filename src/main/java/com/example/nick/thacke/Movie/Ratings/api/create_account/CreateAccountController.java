package com.example.nick.thacke.Movie.Ratings.api.create_account;

import com.example.nick.thacke.Movie.Ratings.model.User;
import com.example.nick.thacke.Movie.Ratings.service.create_account.CreateAccountService;
import com.example.nick.thacke.Movie.Ratings.service.create_account.LoginAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/create/account")
@RestController
public class CreateAccountController {

    private final CreateAccountService createAccountService;

    @Autowired
    public CreateAccountController(CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody User user) {
        if(user.getID() == null) {
            user = new User(user.getUsername());
        }
        HttpStatus status = (createAccountService.createAccount(user)) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body("The username has already been taken.");
    }

}
