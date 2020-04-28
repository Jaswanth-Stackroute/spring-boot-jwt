package com.stackroute.appservice.service;

import com.stackroute.appservice.domain.User;
import com.stackroute.appservice.exception.UserAlreadyExistException;
import com.stackroute.appservice.exception.UserNotFoundException;
import com.stackroute.appservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {

        Optional<User> userResult = userRepository.findById(user.getId());

        if (userResult.isPresent()) {
            throw new UserAlreadyExistException("User Already Exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User findByIdAndPassword(String id, String password) throws UserNotFoundException {
        User authUser = userRepository.findByIdAndPassword(id, password);
        if (authUser == null) {
            throw new UserNotFoundException("Invalid Id and Password");
        }
        return authUser;
    }

}
