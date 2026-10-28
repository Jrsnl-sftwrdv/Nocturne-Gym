package Nocturne.Gym.models.DTOS.Responses;

import java.time.LocalDateTime;
import Nocturne.Gym.models.Gender;
import Nocturne.Gym.models.Member;

public record MemberResponseDTO(
    Long id,
    String name,
    String smsNumber,
    String email,
    Gender gender,
    String cardUid,
    LocalDateTime createdAt
) {
    public static MemberResponseDTO from(Member member) {
        return new MemberResponseDTO(
            member.getId(),
            member.getName(),
            member.getSmsNumber(),
            member.getEmail(),
            member.getGender(),
            member.getCardUid(),
            member.getCreatedAt()
        );
    }
}