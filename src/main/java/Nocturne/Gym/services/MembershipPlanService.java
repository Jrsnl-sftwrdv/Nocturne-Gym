package Nocturne.Gym.services;

import org.springframework.stereotype.Service;

import Nocturne.Gym.ExceptionHandler.DuplicateMembershipPlanException;
import Nocturne.Gym.ExceptionHandler.MembershipPlanNotFoundException;
import Nocturne.Gym.models.MembershipPlan;
import Nocturne.Gym.models.DTOS.Requests.CreateMembershipPlanRequest;
import Nocturne.Gym.models.DTOS.Responses.MembershipPlanResponseDTO;
import Nocturne.Gym.repositories.MembershipPlanRepository;
import jakarta.transaction.Transactional;

import java.util.*;

@Service 
public class MembershipPlanService {
    
    private final MembershipPlanRepository membershipPlanRepository; 

    public MembershipPlanService(MembershipPlanRepository a){ 
        this.membershipPlanRepository = a;
    }

    public List<MembershipPlanResponseDTO> getAllMembershipPlan(){ 
        return membershipPlanRepository.findAll().stream().map(MembershipPlanResponseDTO::from).toList();
    }

    public MembershipPlanResponseDTO getMembershipPlanByName(String name){ 
        MembershipPlan plan = membershipPlanRepository.findByName(name).orElseThrow(() -> new MembershipPlanNotFoundException("No plan found with the name " + name));
        return MembershipPlanResponseDTO.from(plan); 
    }

    @Transactional 
    public MembershipPlanResponseDTO createMembershipPlan(CreateMembershipPlanRequest request){ 
       if(membershipPlanRepository.existsByName(request.getName())){ 
        throw new DuplicateMembershipPlanException("Membership plan already exist with the name" + request.getName()); 
       }
       MembershipPlan plan =  new MembershipPlan(); 
       





    }
    







}
