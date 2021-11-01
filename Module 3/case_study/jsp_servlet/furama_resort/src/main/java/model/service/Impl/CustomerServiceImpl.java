package model.service.Impl;

import model.bean.Customer;
import model.repository.CustomerRepo;
import model.repository.Impl.CustomerRepoImpl;
import model.service.CustomerService;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo=new CustomerRepoImpl();
    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public Customer findById(String id) {
        return this.customerRepo.findById(id);
    }

    @Override
    public Map<String,String> create(Customer customer) {
        Map<String,String> stringMap=new HashMap<>();
        if(Validate.validateCustomerID(customer.getCustomer_id())!=null
            ||Validate.validateIDCard(customer.getCustomer_id_card())!=null
            ||Validate.validatePhone(customer.getCustomer_phone())!=null
            ||Validate.validateEmail(customer.getCustomer_email())!=null){
            stringMap.put("customer_id",Validate.validateCustomerID(customer.getCustomer_id()));
            stringMap.put("customer_id_card",Validate.validateIDCard(customer.getCustomer_id_card()));
            stringMap.put("customer_phone",Validate.validatePhone(customer.getCustomer_phone()));
            stringMap.put("customer_email",Validate.validateEmail(customer.getCustomer_email()));
        }else {
            this.customerRepo.create(customer);
        }
        return stringMap;
    }

    @Override
    public Map<String,String> update(Customer customer) {
        Map<String,String> stringMap=new HashMap<>();
        if(Validate.validateCustomerID(customer.getCustomer_id())!=null
                ||Validate.validateIDCard(customer.getCustomer_id_card())!=null
                ||Validate.validatePhone(customer.getCustomer_phone())!=null
                ||Validate.validateEmail(customer.getCustomer_email())!=null){
            stringMap.put("customer_id",Validate.validateCustomerID(customer.getCustomer_id()));
            stringMap.put("customer_id_card",Validate.validateIDCard(customer.getCustomer_id_card()));
            stringMap.put("customer_phone",Validate.validatePhone(customer.getCustomer_phone()));
            stringMap.put("customer_email",Validate.validateEmail(customer.getCustomer_email()));
        }else {
            this.customerRepo.update(customer);
        }
        return stringMap;
    }

    @Override
    public void delete(String id) {
        this.customerRepo.delete(id);
    }

    @Override
    public List<Customer> search(String name) {
        return this.customerRepo.search(name);
    }
}
