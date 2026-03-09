package org.qainsights.learningspringboot.repositories;

import org.qainsights.learningspringboot.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}