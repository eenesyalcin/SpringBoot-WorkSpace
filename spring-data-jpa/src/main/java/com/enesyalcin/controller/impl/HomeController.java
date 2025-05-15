package com.enesyalcin.controller.impl;

import com.enesyalcin.DTOs.DTOHome;
import com.enesyalcin.controller.IHomeController;
import com.enesyalcin.services.IHomeService;
import com.enesyalcin.services.impl.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/home")
public class HomeController implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @Override
    @GetMapping(path = "/list/{id}")
    public DTOHome getHomeById(@PathVariable(name = "id") Long id) {
        return homeService.getHomeById(id);
    }
}
