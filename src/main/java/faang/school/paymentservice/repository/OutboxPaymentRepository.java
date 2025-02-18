package faang.school.paymentservice.repository;

import faang.school.paymentservice.model.OutboxPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OutboxPaymentRepository extends JpaRepository<OutboxPayment, Long> {

    @Query("SELECT o FROM OutboxPayment o WHERE o.isPosted = false")
    List<OutboxPayment> findOutboxReadyToPost();

    Optional<OutboxPayment> findOutboxPaymentByIdempotencyKey(UUID idempotencyKey);
}
