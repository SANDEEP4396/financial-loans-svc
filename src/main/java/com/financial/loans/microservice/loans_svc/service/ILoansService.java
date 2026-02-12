package com.financial.loans.microservice.loans_svc.service;

import com.financial.loans.microservice.loans_svc.dto.LoanDTO;

public interface ILoansService {

    /**
     * Creates a new loan for the given mobile number.
     * @param phoneNumber the mobile number for which the loan is to be created
     */
    void createLoan(String phoneNumber);

    /**
     * Fetches the loan details for the given mobile number.
     * @param phoneNumber the mobile number for which the loan details are to be fetched
     * @return a LoanDTO containing the loan details
     */
    LoanDTO fetchLoan(String phoneNumber);

    /**
     * Updates the loan details for the given LoanDTO.
     * @param loanDTO the LoanDTO containing the updated loan details
     * @return true if the loan was updated successfully, false otherwise
     */
    boolean updateLoan(LoanDTO loanDTO);

    /**
     * Deletes the loan for the given mobile number.
     * @param phoneNumber the mobile number for which the loan is to be deleted
     * @return true if the loan was deleted successfully, false otherwise
     */
    boolean deleteLoan(String phoneNumber);
}
