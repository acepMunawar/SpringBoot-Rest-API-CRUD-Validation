package com.example.pengeluaranNew.validator;

import java.util.Map;


import org.springframework.stereotype.Component;

@Component
public class MandatoryValidator{
    public <T> String ValidateMandatoryFields(Map<String, T>mandatories){
        for(Map.Entry<String, T>entry : mandatories.entrySet()){
            if(entry.getValue()== null || entry.getValue()== ""){
                
                return entry.getKey()+" can't be empty";
            }
        }
        return null;
    }


}