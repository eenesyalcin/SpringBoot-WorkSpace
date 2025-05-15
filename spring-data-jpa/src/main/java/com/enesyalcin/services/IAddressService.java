package com.enesyalcin.services;

import com.enesyalcin.DTOs.DTOAddress;

public interface IAddressService {

    public DTOAddress findAddressById(Long id);

}
