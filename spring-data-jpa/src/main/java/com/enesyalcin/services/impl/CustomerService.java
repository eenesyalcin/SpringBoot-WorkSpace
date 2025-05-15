package com.enesyalcin.services.impl;

import com.enesyalcin.DTOs.DTOAddress;
import com.enesyalcin.DTOs.DTOCustomer;
import com.enesyalcin.entites.Address;
import com.enesyalcin.entites.Customer;
import com.enesyalcin.repository.CustomerRepository;
import com.enesyalcin.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DTOCustomer getCustomerById(Long id) {

        DTOCustomer dtoCustomer = new DTOCustomer();
        DTOAddress dtoAddress = new DTOAddress();

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            return null;
        }

        Customer customer = optionalCustomer.get();
        Address address = customer.getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);

        return dtoCustomer;
    }
}
