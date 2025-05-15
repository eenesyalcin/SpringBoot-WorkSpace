package com.enesyalcin.controller.impl;

import com.enesyalcin.DTOs.DTOCustomer;
import com.enesyalcin.controller.ICustomerController;
import com.enesyalcin.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @Override
    @GetMapping(path = "/list/{id}")
    public DTOCustomer getCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.getCustomerById(id);
    }

}
