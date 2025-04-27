package com.practice.csvtojson;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private CsvToJson service;
    
    @GetMapping("/upload")
    public Map<String, Object> uploadCsv(@RequestParam("header") boolean header) throws Exception {
        return service.convertCsvToJson(header);
//        return service.readJson(header);
    }

}
