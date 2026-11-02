package Nocturne.Gym.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@Entity 
@Table(name = "membership_plans")
public class MembershipPlan {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "name", nullable = false, unique =  true, length = 50)
    private String name; 

    @Column(name = "duration_value", nullable = false)
    private int durationValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration_unit", nullable = false, length = 20)
    private DurationUnit durationUnit; 

   @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; 
    
    @PrePersist 
    protected void onRun(){ 
      if(createdAt == null){ 
        createdAt = LocalDateTime.now(); 
      }
    }

}
