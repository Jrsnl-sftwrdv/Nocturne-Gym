package Nocturne.Gym.models.DTOS.Requests;

import java.math.BigDecimal;

import org.hibernate.sql.ast.tree.expression.DurationUnit;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter  @NoArgsConstructor     
public class CreateMembershipPlanRequest {
    
    @NotBlank (message = "This field is required")
    @Size(max = 50, message = "Plan name must be at most 50 characters")
    private String name; 

    @NotNull(message = "Duration value is required")
    @Min(value = 1, message = "Duration must be at least 1")
    private Integer durationValue; 

    @NotNull(message = "Duration unit is required")
    private DurationUnit durationUnit; 

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.00", message = "Price cannot be negative")
    @Digits(integer = 8, fraction = 2, message = "Price must have at most 8 digits and 2 decimals")
    private BigDecimal price; 




}
