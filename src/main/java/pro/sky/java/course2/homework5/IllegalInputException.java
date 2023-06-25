package pro.sky.java.course2.homework5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IllegalInputException extends RuntimeException {

}
