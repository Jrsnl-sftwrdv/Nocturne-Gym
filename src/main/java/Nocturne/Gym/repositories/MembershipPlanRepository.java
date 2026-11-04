package Nocturne.Gym.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Nocturne.Gym.models.MembershipPlan;

@Repository 
public interface MembershipPlanRepository extends JpaRepository<MembershipPlan, Long> {

    Optional<MembershipPlan> findByName(String name); 

     boolean existsByName(String name);
}
