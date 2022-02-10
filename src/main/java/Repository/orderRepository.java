package Repository;

import Model.dao.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface orderRepository extends JpaRepository<Orders, Long> {

    @Transactional
    @Query(value = "delete from Order c where c.booking_id = ?1")
    void deleteByOrderId(String orderId);
}

