package com.example.biling.Web;

import com.example.biling.Repositories.BillRepository;
import com.example.biling.Repositories.ProductItemsRepository;
import com.example.biling.entity.Bill;
import com.example.biling.feign.CustomerRestClient;
import com.example.biling.feign.ProductItemRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
public class BillController {
    private BillRepository billRepository;
    private ProductItemsRepository productItemsRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id) throws Exception {
        Bill bill =billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerID()));
        bill.getProductItemsList().forEach(v->{
            v.setProductName(productItemRestClient.getProductById(v.getProductID()).getName());
        });
        return bill;
    }

}
