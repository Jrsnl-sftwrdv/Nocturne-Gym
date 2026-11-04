package Nocturne.Gym.ExceptionHandler;

public class MembershipPlanNotFoundException extends RuntimeException {
    public MembershipPlanNotFoundException(String message){
        super(message); 
    }
}
