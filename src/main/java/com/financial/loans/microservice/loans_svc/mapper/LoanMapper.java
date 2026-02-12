package com.financial.loans.microservice.loans_svc.mapper;


import com.financial.loans.microservice.loans_svc.dto.LoanDTO;
import com.financial.loans.microservice.loans_svc.entity.Loans;

public class LoanMapper {
    public static LoanDTO mapToLoanDTO(Loans loans, LoanDTO loanDTO) {
        loanDTO.setLoanNumber(loans.getLoanNumber());
        loanDTO.setLoanType(loans.getLoanType());
        loanDTO.setPhoneNumber(loans.getPhoneNumber());
        loanDTO.setTotalLoan(loans.getTotalLoan());
        loanDTO.setAmountPaid(loans.getAmountPaid());
        loanDTO.setOutstandingAmount(loans.getOutstandingAmount());
        return loanDTO;
    }

    public static Loans mapToLoans(LoanDTO loanDTO, Loans loans) {
        loans.setLoanNumber(loanDTO.getLoanNumber());
        loans.setLoanType(loanDTO.getLoanType());
        loans.setPhoneNumber(loanDTO.getPhoneNumber());
        loans.setTotalLoan(loanDTO.getTotalLoan());
        loans.setAmountPaid(loanDTO.getAmountPaid());
        loans.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loans;
    }

}
