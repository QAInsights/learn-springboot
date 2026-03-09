package org.qainsights.learningspringboot.repositories;

import org.qainsights.learningspringboot.dtos.UserSummary;
import org.qainsights.learningspringboot.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @Query("select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints > ?1 order by p.user.email")
    @EntityGraph(attributePaths = "user")
    List<UserSummary> findLoyalProfiles(Long loyaltyPoints);
}