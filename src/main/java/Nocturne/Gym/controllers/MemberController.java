package Nocturne.Gym.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Nocturne.Gym.models.DTOS.Requests.CreateMemberRequest;
import Nocturne.Gym.models.DTOS.Requests.PatchMemberRequest;
import Nocturne.Gym.models.DTOS.Requests.UpdateMemberRequest;
import Nocturne.Gym.models.DTOS.Responses.MemberResponseDTO;
import Nocturne.Gym.services.MemberService;
import jakarta.validation.Valid;

import  java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("/api/members")
public class MemberController {
    
    private final MemberService memberService; 

    public MemberController(MemberService memberService){ 
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAllMembers(){ 
    List<MemberResponseDTO> responses = memberService.getAllMembers(); 
     return  ResponseEntity.ok(responses); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getMemberById(@PathVariable Long id){ 
    MemberResponseDTO responseDTO = memberService.getMemberById(id); 
    return  ResponseEntity.ok(responseDTO); 
    }

    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@Valid @RequestBody CreateMemberRequest request){
    MemberResponseDTO responseDTO = memberService.createMember(request); 
    return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO); 
     }
    
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteMember(@PathVariable Long id){ 
        memberService.deleteMember(id);
     return ResponseEntity.noContent().build();
     }

     @PutMapping("/{id}")
     public ResponseEntity<MemberResponseDTO> updateMember(@PathVariable Long id, @Valid @RequestBody UpdateMemberRequest request){ 
      MemberResponseDTO updatedMember =  memberService.updateMember(id, request); 
        return ResponseEntity.ok(updatedMember); 
     }

     @PatchMapping("/{id}")
     public ResponseEntity<MemberResponseDTO> patchMember(@PathVariable Long id, @Valid @RequestBody PatchMemberRequest request){ 
     MemberResponseDTO patchedMember = memberService.patchMember(id, request); 
     return ResponseEntity.ok(patchedMember); 
     }




}
