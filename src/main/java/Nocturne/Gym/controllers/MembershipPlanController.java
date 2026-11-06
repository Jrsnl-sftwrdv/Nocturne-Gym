package Nocturne.Gym.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Nocturne.Gym.models.DTOS.Requests.CreateMembershipPlanRequest;
import Nocturne.Gym.models.DTOS.Requests.UpdateMembershipPlanRequestDTO;
import Nocturne.Gym.models.DTOS.Responses.MembershipPlanResponseDTO;
import Nocturne.Gym.services.MembershipPlanService;
import jakarta.validation.Valid;
import  java.util.*;


@RestController 
@RequestMapping("/api/plans")
public class MembershipPlanController {
    
    private final MembershipPlanService membershipPlanService; 

    public MembershipPlanController(MembershipPlanService membershipPlanService){ 
        this.membershipPlanService = membershipPlanService; 
    }

    @PostMapping   
    public ResponseEntity<MembershipPlanResponseDTO> createMembershipPlan(@Valid @RequestBody CreateMembershipPlanRequest request){ 
        MembershipPlanResponseDTO responseDTO = membershipPlanService.createMembershipPlan(request); 
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO); 
        }

    @GetMapping  
    public ResponseEntity<List<MembershipPlanResponseDTO>> getAllMembershipPlan(){ 
        List<MembershipPlanResponseDTO> responses = membershipPlanService.getAllMembershipPlan(); 
        return  ResponseEntity.ok(responses); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipPlanResponseDTO> getMembershipPlanById(@PathVariable Long id){ 
        MembershipPlanResponseDTO responseDTO = membershipPlanService.getMembershipPlanById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MembershipPlanResponseDTO> updateMembershipPlan(@PathVariable Long id, @Valid @RequestBody UpdateMembershipPlanRequestDTO request){ 
      MembershipPlanResponseDTO patchedRequest =  membershipPlanService.patchMembershipPlan(id, request); 
      return ResponseEntity.ok(patchedRequest); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembershipPlan(@PathVariable Long id){ 
        membershipPlanService.deleteMembershipPlan(id);
        return ResponseEntity.noContent().build(); 
    }
}
