package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.exception.ObjectNotFoundException;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
       return  customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List <Customer>customerList =  customerRepository.findAll();
        if(customerList.size() == 0){
            throw new ObjectNotFoundException("No customers in the DB");
        }
        return customerList;
    }

    @Override
    public Customer findById(long customerId) {
        Optional<Customer> owner = customerRepository.findById(customerId);
        if(owner.isPresent()){
            return owner.get();
        }else{
            throw new ObjectNotFoundException("customer not found");
        }
    }
}
