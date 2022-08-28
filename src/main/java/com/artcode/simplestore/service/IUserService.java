package com.artcode.simplestore.service;

import com.artcode.simplestore.entity.UserData;

public interface IUserService {
    public void register(UserData userData) throws Exception;

    public boolean checkIfUserExist(String email);
}
