package Nocturne.Gym.models.DTOS.Requests;

import Nocturne.Gym.models.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
public class UpdateMemberRequest {
    
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name; 

    @NotBlank(message =  "SMS number is required")
    @Size(max = 20, message = "SMS number must be at most 20 characters")
    private String sms;     

    @NotBlank(message = "Email is required") 
    @Email(message = "Please enter a valid email")
    @Size(max = 100)
    private String email; 

    @NotNull(message = "Gender is required")
    private Gender gender; 


}
