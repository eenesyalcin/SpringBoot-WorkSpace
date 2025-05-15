package com.enesyalcin.controller.impl;

import com.enesyalcin.configuration.DataSource;
import com.enesyalcin.configuration.GlobalProperties;
import com.enesyalcin.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

//    @GetMapping("/datasource")
//    public DataSource getDataSoruce(){
//
//        DataSource dataSource = new DataSource();
//        dataSource.setUrl(globalProperties.getUrl());
//        dataSource.setUsername(globalProperties.getUsername());
//        dataSource.setPassword(globalProperties.getPassword());
//
//        return dataSource ;
//    }


    @GetMapping(value = "/getServers")
    public List<Server> getServers() {
        return globalProperties.getServers();
    }

}
