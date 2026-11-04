package Nocturne.Gym.models.DTOS.Responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import Nocturne.Gym.models.DurationUnit;

import Nocturne.Gym.models.MembershipPlan;

public record MembershipPlanResponseDTO(
Long id, 
String name,
int durationValue,
DurationUnit durationUnit,
BigDecimal price,
LocalDateTime createdAt
){
    public static MembershipPlanResponseDTO from(MembershipPlan membershipPlan){
        return  new MembershipPlanResponseDTO(membershipPlan.getId(),
             membershipPlan.getName(),
              membershipPlan.getDurationValue(),
               membershipPlan.getDurationUnit(),
                membershipPlan.getPrice(),
                 membershipPlan.getCreatedAt()
                ); 
    }
}
