package com.example.nick.thacke.Movie.Ratings.service.create_account;

import com.example.nick.thacke.Movie.Ratings.dao.create_account.CreateAccountDAO;
import com.example.nick.thacke.Movie.Ratings.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService implements CreateAccountDAO {
    @Override
    public boolean createAccount(User user) {
        return manager.addUser(user);
    }

}
