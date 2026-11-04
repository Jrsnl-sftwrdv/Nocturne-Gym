package Nocturne.Gym.services;

import org.springframework.stereotype.Service;

import Nocturne.Gym.ExceptionHandler.DuplicateMembershipPlanException;
import Nocturne.Gym.ExceptionHandler.MembershipPlanNotFoundException;
import Nocturne.Gym.models.MembershipPlan;
import Nocturne.Gym.models.DTOS.Requests.CreateMembershipPlanRequest;
import Nocturne.Gym.models.DTOS.Requests.UpdateMembershipPlanRequestDTO;
import Nocturne.Gym.models.DTOS.Responses.MembershipPlanResponseDTO;
import Nocturne.Gym.repositories.MembershipPlanRepository;
import jakarta.transaction.Transactional;

import java.util.*;

@Service 
public class MembershipPlanService {
    
    private final Nocturne.Gym.repositories.MemberRepository memberRepository;
    private final MembershipPlanRepository membershipPlanRepository; 

    public MembershipPlanService(MembershipPlanRepository a, Nocturne.Gym.repositories.MemberRepository memberRepository){ 
        this.membershipPlanRepository = a;
        this.memberRepository = memberRepository;
    }

    public List<MembershipPlanResponseDTO> getAllMembershipPlan(){ 
        return membershipPlanRepository.findAll().stream().map(MembershipPlanResponseDTO::from).toList();
    }

    public MembershipPlanResponseDTO getMembershipPlanByName(String name){ 
        MembershipPlan plan = membershipPlanRepository.findByName(name).orElseThrow(() -> new MembershipPlanNotFoundException("No plan found with the name " + name));
        return MembershipPlanResponseDTO.from(plan); 
    }

    @Transactional
    public MembershipPlanResponseDTO getMembershipPlanById(Long id){ 
            MembershipPlan plan = membershipPlanRepository.findById(id).orElseThrow(() -> new MembershipPlanNotFoundException("No plan found with id " + id));
     return MembershipPlanResponseDTO.from(plan);
    }


    @Transactional 
    public MembershipPlanResponseDTO createMembershipPlan(CreateMembershipPlanRequest request){ 
       if(membershipPlanRepository.existsByName(request.getName())){ 
        throw new DuplicateMembershipPlanException("Membership plan already exist with the name " + request.getName()); 
       }
       MembershipPlan plan =  new MembershipPlan(); 
       plan.setName(request.getName());
       plan.setDurationValue(request.getDurationValue());
       plan.setDurationUnit(request.getDurationUnit());
       plan.setPrice(request.getPrice());
       MembershipPlan saved = membershipPlanRepository.save(plan); 
       return  MembershipPlanResponseDTO.from(saved); 
    }

    @Transactional 
    public MembershipPlanResponseDTO patchMembershipPlan(Long id, UpdateMembershipPlanRequestDTO request){
    MembershipPlan foundPlan = membershipPlanRepository.findById(id).orElseThrow(() -> new MembershipPlanNotFoundException("No plan with id " + id)); 

    if(request.getName() != null){
        boolean isChanging = !request.getName().equalsIgnoreCase(foundPlan.getName());
        if(isChanging && membershipPlanRepository.existsByName(request.getName())){ 
            throw new DuplicateMembershipPlanException("Membership plan already exists with the name " + request.getName()); 
        }
        foundPlan.setName(request.getName());
    }
    if(request.getDurationUnit() != null){foundPlan.setDurationUnit(request.getDurationUnit());}
    if(request.getDurationValue() != null){foundPlan.setDurationValue(request.getDurationValue());}
    if(request.getPrice() != null){foundPlan.setPrice(request.getPrice());}
    MembershipPlan updatedPlan = membershipPlanRepository.save(foundPlan);
    return MembershipPlanResponseDTO.from(updatedPlan);
    }

    @Transactional 
    public void deletePlanby(Long id){ 
        if(!memberRepository.existsById(id)){ 
            memberRepository.deleteById(id);
        }
        throw new MembershipPlanNotFoundException("No plan with id " + id); 
    }
    







}
