package com.enesyalcin.controller;

import com.enesyalcin.DTOs.DTOAddress;

public interface IAddressController {
    public DTOAddress findAddressById(Long id);
}
