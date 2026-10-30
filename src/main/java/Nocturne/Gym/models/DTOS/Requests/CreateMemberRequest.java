package Nocturne.Gym.models.DTOS.Requests;

import Nocturne.Gym.models.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CreateMemberRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Card UID is required")
    @Size(max = 50, message = "Card UID must not exceed 50 characters")
    private String cardUid;

    @NotBlank(message = "SMS number is required")
    @Size(max = 20, message = "SMS number must not exceed 20 characters")
    private String smsNumber;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;
}