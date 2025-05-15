package com.enesyalcin.controller;

import com.enesyalcin.DTOs.DTOCustomer;

public interface ICustomerController {
    public DTOCustomer getCustomerById(Long id);
}
