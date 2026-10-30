package Nocturne.Gym.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Nocturne.Gym.models.Member;

@Repository 
public interface MemberRepository extends JpaRepository<Member, Long>{
    
   Optional<Member> findByCardUid(String cardUid);

   Boolean existByUid(String cardUID); 

}
