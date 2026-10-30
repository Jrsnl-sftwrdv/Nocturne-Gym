package Nocturne.Gym.services;
import org.springframework.stereotype.Service;

import Nocturne.Gym.ExceptionHandler.DuplicateCardUidException;
import Nocturne.Gym.ExceptionHandler.MemberNotFoundException;
import Nocturne.Gym.models.Member;
import Nocturne.Gym.models.DTOS.Requests.CreateMemberRequest;
import Nocturne.Gym.models.DTOS.Requests.PatchMemberRequest;
import Nocturne.Gym.models.DTOS.Requests.UpdateMemberRequest;
import Nocturne.Gym.models.DTOS.Responses.MemberResponseDTO;
import Nocturne.Gym.repositories.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.*;

@Service 
public class MemberService {

    private final MemberRepository memberRepository; 

   public MemberService(MemberRepository memberRepository){ 
        this.memberRepository = memberRepository;
    }

    @Transactional 
    public MemberResponseDTO createMember(CreateMemberRequest request){ 
    
        if(memberRepository.existByUid(request.getCardUid())){ 
        throw new DuplicateCardUidException("Card UID is already registered"); 
    }

    Member member = new Member(); 
    member.setName(request.getName());
    member.setGender(request.getGender());
    member.setCardUid(request.getCardUid());
    member.setEmail(request.getEmail());
    member.setSmsNumber(request.getSmsNumber());
    Member savedMember = memberRepository.save(member); 
    return MemberResponseDTO.from(savedMember); 
    }

    public List<MemberResponseDTO> getAllMembers(){ 
        return memberRepository.findAll().stream().map(MemberResponseDTO::from).toList();
    }
    

 public MemberResponseDTO getMemberById(Long id){ 
        Member member =  memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found with id: " + id)); 
        return MemberResponseDTO.from(member); 
    }

    @Transactional 
    public MemberResponseDTO updateMember(Long id, PatchMemberRequest request){
        Member foundMember = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found with id: " + id));

        if(request.getName() != null){foundMember.setName(request.getName());}
        if(request.getEmail() != null){foundMember.setEmail(request.getEmail());}
        if(request.getGender() != null){foundMember.setGender(request.getGender());}
        if(request.getSms() != null){foundMember.setSmsNumber(request.getSms());}
        memberRepository.save(foundMember); 
        return MemberResponseDTO.from(foundMember); 
    }

    public void deleteMember(Long id){ 
        if(!memberRepository.existsById(id)){ 
            throw new MemberNotFoundException("Member not found with id: " + id); 
        }
        memberRepository.deleteById(id);
    }
    


    
}
