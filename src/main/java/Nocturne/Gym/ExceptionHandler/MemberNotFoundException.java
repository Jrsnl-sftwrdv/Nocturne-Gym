package Nocturne.Gym.ExceptionHandler;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message){ 
        super(message); 
    }
}
