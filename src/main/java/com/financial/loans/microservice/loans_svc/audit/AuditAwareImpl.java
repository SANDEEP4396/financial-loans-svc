package com.financial.loans.microservice.loans_svc.audit;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    @NullMarked
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Loans_Svc"); // In a real application, you would return the actual user performing the operation, e.g., from a security context.
    }
}
