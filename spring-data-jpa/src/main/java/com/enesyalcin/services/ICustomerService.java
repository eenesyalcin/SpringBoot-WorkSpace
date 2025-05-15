package com.enesyalcin.services;

import com.enesyalcin.DTOs.DTOCustomer;

public interface ICustomerService {
    public DTOCustomer getCustomerById(Long id);
}
