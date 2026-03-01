package org.qainsights.learningspringboot;

import org.springframework.stereotype.Service;

public interface UserRepository {
    void save(User user);
    public User findByEmail(String email);
}
