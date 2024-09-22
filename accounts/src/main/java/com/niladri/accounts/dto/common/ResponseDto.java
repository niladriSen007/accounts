package com.niladri.accounts.dto.common;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    @NotNull
    public String statusCode;
    @NotNull
    public String statusMessage;
}
