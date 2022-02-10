package Service;



import Model.dao.Orders;

import Repository.orderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    orderRepository OrRepo;

    public void  save(Orders orders){
        OrRepo.save(orders);
    }

    public void  saveById(Long bookingId) {
        Orders orders = OrRepo.getById(bookingId);
        OrRepo.save(orders);
    }

    public Orders get(Long bookingId) {
        return OrRepo.findById(bookingId).get();
    }

    public List<Orders> findAll(){
        List<Orders> orders = (ArrayList<Orders>) OrRepo.findAll();
        return orders;
    }

    public void deleteById(Long id) {
        OrRepo.deleteById(id);
    }
}





