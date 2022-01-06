package com.example.demo.repository;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value="select customer.customer_id,customer_name,customer_birth_day,customer_phone,customer_address,contract.contract_id,\n" +
            "            contract_total_money,contract_detail.contract_detail_id,attach_service.attach_service_id,attach_service_name\n" +
            "            from customer\n" +
            "            right join contract on customer.customer_id=contract.customer_id\n" +
            "            inner join service on contract.service_id=service.service_id\n" +
            "            right join contract_detail on contract.contract_id=contract_detail.contract_id\n" +
            "            right join attach_service on contract_detail.attach_service_id=attach_service.attach_service_id\n" +
            "            group by customer.customer_id",nativeQuery=true)
    Page<Contract> findCustomerUsingService(Pageable pageable, String name);
}
