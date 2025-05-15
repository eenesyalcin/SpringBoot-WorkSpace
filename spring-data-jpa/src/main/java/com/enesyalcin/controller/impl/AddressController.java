package com.enesyalcin.controller.impl;

import com.enesyalcin.DTOs.DTOAddress;
import com.enesyalcin.controller.IAddressController;
import com.enesyalcin.services.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class AddressController implements IAddressController {

    @Autowired
    private AddressService addressService;

    @Override
    @GetMapping(path = "/list/{id}")
    public DTOAddress findAddressById(@PathVariable(name = "id") Long id) {
        return addressService.findAddressById(id);
    }
}
