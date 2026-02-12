package com.financial.loans.microservice.loans_svc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(
        name = "ErrorResponse",
        description = "Schema holds the details of the error response such as error message, api path, error code and timestamp"
)
@AllArgsConstructor
public class ErrorResponseDTO {
    @Schema(
            description = "Error message of the response",
            example = "Loans details already exist"
    )
    private String errorMessage;

    @Schema(
            description = "API path of the request that caused the error",
            example = "/api/v1/laons"
    )
    private String apiPath;

    @Schema(
            description = "Error code of the response",
            example = "400/500"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Timestamp of when the error occurred",
            example = "2024-06-01T12:00:00"
    )
    private LocalDateTime timestamp;
}
