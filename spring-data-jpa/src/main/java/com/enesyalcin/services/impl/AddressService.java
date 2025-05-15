package com.enesyalcin.services.impl;

import com.enesyalcin.DTOs.DTOAddress;
import com.enesyalcin.DTOs.DTOCustomer;
import com.enesyalcin.entites.Address;
import com.enesyalcin.entites.Customer;
import com.enesyalcin.repository.AddressRepository;
import com.enesyalcin.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DTOAddress findAddressById(Long id) {
        DTOAddress dtoAddress = new DTOAddress();
        DTOCustomer dtoCustomer = new DTOCustomer();

        Optional<Address> optionalAddress =  addressRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            return null;
        }

        Address address = optionalAddress.get();
        Customer customer = address.getCustomer();

        BeanUtils.copyProperties(address, dtoAddress);
        BeanUtils.copyProperties(customer, dtoCustomer);

        dtoAddress.setCustomer(dtoCustomer);
        return dtoAddress;
    }
}
