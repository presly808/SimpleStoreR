package com.artcode.simplestore.service;

import com.artcode.simplestore.entity.User;
import com.artcode.simplestore.entity.UserData;
import com.artcode.simplestore.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(UserData userData) throws Exception {
        if (checkIfUserExist(userData.getEmail())) {
            throw new Exception("User already exists for this email");
        }
        User userEntity = new User();
        BeanUtils.copyProperties(userData, userEntity);
        encodePassword(userEntity, userData);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

    private void encodePassword(User userEntity, UserData user) {
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()).getBytes());
    }
}
