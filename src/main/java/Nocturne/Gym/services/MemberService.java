package Nocturne.Gym.services;
import org.springframework.stereotype.Service;

import Nocturne.Gym.ExceptionHandler.MemberNotFoundException;
import Nocturne.Gym.models.Member;
import Nocturne.Gym.models.DTOS.Requests.UpdateMemberRequest;
import Nocturne.Gym.models.DTOS.Responses.MemberResponseDTO;
import Nocturne.Gym.repositories.MemberRepository;
import java.util.*;

@Service 
public class MemberService {

    private final MemberRepository memberRepository; 

   public  MemberService(MemberRepository memberRepository){ 
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers(){ 
        return memberRepository.findAll(); 
    }
    

 public Member getMemberById(Long id){ 
        return  memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found")); 
    }

    public MemberResponseDTO updateMember(Long id,  UpdateMemberRequest request){ 
        Member foundMember = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found")); 
        foundMember.setEmail(request.getEmail());
        foundMember.setGender(request.getGender());
        foundMember.setName(request.getName());
        foundMember.setSmsNumber(request.getSms());
        Member updatedMember = memberRepository.save(foundMember); 
        return MemberResponseDTO.from(updatedMember); 
    }




    
}
