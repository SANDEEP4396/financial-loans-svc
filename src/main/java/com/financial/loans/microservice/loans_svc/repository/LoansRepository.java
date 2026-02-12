package com.financial.loans.microservice.loans_svc.repository;

import com.financial.loans.microservice.loans_svc.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    Optional<Loans> findByLoanNumber(String loanNumber);
    Optional<Loans> findByPhoneNumber(String phoneNumber);
}
