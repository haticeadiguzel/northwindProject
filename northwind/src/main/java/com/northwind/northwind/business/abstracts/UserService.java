package com.northwind.northwind.business.abstracts;

import com.northwind.northwind.core.utilities.entities.User;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> getByEmail(String email);
}
