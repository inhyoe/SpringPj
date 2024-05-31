package com.in28minutes.learnspringframework.Test;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private final DataService dataService;

    // 생성자
    public BusinessCalculationService(DataService dataService){
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

