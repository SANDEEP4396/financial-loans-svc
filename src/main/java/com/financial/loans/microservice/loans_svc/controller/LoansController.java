package com.financial.loans.microservice.loans_svc.controller;

import com.financial.loans.microservice.loans_svc.constants.LoanConstants;
import com.financial.loans.microservice.loans_svc.dto.ErrorResponseDTO;
import com.financial.loans.microservice.loans_svc.dto.LoanDTO;
import com.financial.loans.microservice.loans_svc.dto.LoansContactInfoDto;
import com.financial.loans.microservice.loans_svc.dto.ResponseDTO;
import com.financial.loans.microservice.loans_svc.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Loans",
        description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE loan details"
)
@RestController
@Validated
@RequestMapping(path = "/api/loans", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LoansController {

    private final ILoansService iLoansService;

    @Autowired
    private LoansContactInfoDto loansContactInfoDto;

    public LoansController(final ILoansService iLoansService) {
        this.iLoansService = iLoansService;
    }

    @Operation(
            summary = "Create Loan REST API",
            description = "REST API to create new loan inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @PostMapping("/createLoan")
    public ResponseEntity<ResponseDTO> createLoan(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
                                                  String phoneNumber) {
        iLoansService.createLoan(phoneNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Loan Details REST API",
            description = "REST API to fetch loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @GetMapping("/fetchLoan")
    public ResponseEntity<LoanDTO> fetchLoanDetails(@RequestParam
                                                    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
                                                    String phoneNumber) {
        LoanDTO loanDto = iLoansService.fetchLoan(phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loanDto);
    }

    @Operation(
            summary = "Update Loan Details REST API",
            description = "REST API to update loan details based on a loan number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @PutMapping("/updateLoan")
    public ResponseEntity<ResponseDTO> updateLoanDetails(@Valid @RequestBody LoanDTO loanDTO) {
        boolean isUpdated = iLoansService.updateLoan(loanDTO);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Loan Details REST API",
            description = "REST API to delete Loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @DeleteMapping("/deleteLoan")
    public ResponseEntity<ResponseDTO> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
                                                         String phoneNumber) {
        boolean isDeleted = iLoansService.deleteLoan(phoneNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/contact-info")
    public ResponseEntity<LoansContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansContactInfoDto);
    }
}
