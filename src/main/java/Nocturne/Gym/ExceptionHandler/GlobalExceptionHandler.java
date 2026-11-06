package Nocturne.Gym.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.*;

@ControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>manve(MethodArgumentNotValidException manve){ 
        Map<String, String> error = new HashMap<>(); 
        error.put("message", manve.getBindingResult().getAllErrors().get(0).getDefaultMessage()); 
        return ResponseEntity.badRequest().body(error); 
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Map<String, String>> membernotfound(MemberNotFoundException mnfe){ 
        Map<String, String> error = new HashMap<>(); 
        error.put("message", mnfe.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(DuplicateCardUidException.class)
    public ResponseEntity<Map<String, String>>duplicatecard(DuplicateCardUidException dcue){ 
        Map<String, String> error = new HashMap<>(); 
        error.put("message", dcue.getMessage());
        return  ResponseEntity.status(409).body(error); 
    }

    @ExceptionHandler(MembershipPlanNotFoundException.class)
        public ResponseEntity<Map<String, String>>membershipplannotfound(MembershipPlanNotFoundException mpnfe){ 
            Map<String, String> error = new HashMap<>(); 
            error.put("message", mpnfe.getMessage());
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); 
        }

    @ExceptionHandler(DuplicateMembershipPlanException.class)
    public ResponseEntity<Map<String, String>> duplicatemembershipplan(DuplicateMembershipPlanException dmpe){ 
        Map<String, String> error = new HashMap<>(); 
        error.put("message", dmpe.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error); 
    }







    }








