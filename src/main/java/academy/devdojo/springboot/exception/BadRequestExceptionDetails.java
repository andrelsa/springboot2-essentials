package academy.devdojo.springboot.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {
    public String tittle;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;
}
