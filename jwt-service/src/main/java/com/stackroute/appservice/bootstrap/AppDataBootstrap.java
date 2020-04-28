package com.stackroute.appservice.bootstrap;

import com.stackroute.appservice.domain.User;
import com.stackroute.appservice.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppDataBootstrap implements CommandLineRunner {
    private UserRepository userRepository;
    @Autowired
    public AppDataBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        User user1=new User("meghna@email.com","meghna@123");
        User user2=new User("john@email.com","john@123");
        userRepository.save(user1);
        userRepository.save(user2);
        log.debug("Loaded users...");

    }
}
