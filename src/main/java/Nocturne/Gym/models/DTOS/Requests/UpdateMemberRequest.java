package Nocturne.Gym.models.DTOS.Requests;

import Nocturne.Gym.models.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
public class UpdateMemberRequest {
    

    @Size(max = 100, message = "Name must be at most 100 characters")
    @Pattern(regexp = "^\\s*\\S.*$")
    private String name; 

    @Size(max = 20, message = "SMS number must be at most 20 characters")
    @Pattern(regexp = "^\\s*\\S.*$")
    private String sms;     

    @Email(message = "Please enter a valid email")
    @Size(max = 100)
    @Pattern(regexp = "^\\s*\\S.*$")
    private String email; 

    private Gender gender; 




}
