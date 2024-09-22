package com.niladri.accounts.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private String errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime errorTime;

}
