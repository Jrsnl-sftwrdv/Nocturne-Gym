package Nocturne.Gym.models;

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
@Table(name = "members")
public class Member {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @Column(name = "name", nullable =  false, length =  100)
    private String name; 

    @Column(name = "card_uid", nullable = false, length = 50, unique = true)
    private String cardUid; 
    
    @Column(name = "sms_number", nullable = false, length = 20)
    private String smsNumber; 

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 20)
    private Gender gender;  

    @Column(name = "email", nullable = false, length =  100)
    private String email; 

    @Column(name =  "created_at", nullable =  false)
    private LocalDateTime createdAt; 
 
    // This allows the Oncreate to create a localdatetime on runtime
    @PrePersist 
    protected void onCreate(){ 
    if(createdAt == null){ 
        createdAt = LocalDateTime.now(); 
    }   
    }


}
