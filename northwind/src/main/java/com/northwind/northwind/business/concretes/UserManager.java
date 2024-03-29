package com.northwind.northwind.business.concretes;

import com.northwind.northwind.business.abstracts.UserService;
import com.northwind.northwind.core.utilities.dataAccess.UserRepository;
import com.northwind.northwind.core.utilities.entities.User;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.core.utilities.results.SuccessDataResult;
import com.northwind.northwind.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;

    @Override
    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("User added.");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(userRepository.getByEmail(email), "User listed.");
    }
}
