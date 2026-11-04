package Nocturne.Gym.models.DTOS.Requests;

import java.math.BigDecimal;

import Nocturne.Gym.models.DurationUnit;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateMembershipPlanRequestDTO {

    @Size(max = 50, message = "Plan name must be at most 50 characters")
    @Pattern(regexp = ".*\\S.*", message = "Plan name must not be blank")
    private String name;

    @Min(value = 1, message = "Duration must be at least 1")
    private Integer durationValue;

    private DurationUnit durationUnit;

    @DecimalMin(value = "0.00", message = "Price cannot be negative")
    @Digits(integer = 8, fraction = 2, message = "Price must have at most 8 digits and 2 decimals")
    private BigDecimal price;
}