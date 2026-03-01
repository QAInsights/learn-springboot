package org.qainsights.learningspringboot;

import org.springframework.stereotype.Service;

@Service
public class UserService {


   private final UserRepository userRepository;

   private final NewNotificationService newNotificationService;

    public UserService(UserRepository userRepository, NewNotificationService newNotificationService) {
        this.userRepository = userRepository;
        this.newNotificationService = newNotificationService;
    }

    public void registerUser(User user) throws IllegalAccessException {

        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalAccessException("User are already exists");
        }
        else {
            userRepository.save(user);
            newNotificationService.send("Welcome to our platform!", user.getEmail());
        }
    }
}
