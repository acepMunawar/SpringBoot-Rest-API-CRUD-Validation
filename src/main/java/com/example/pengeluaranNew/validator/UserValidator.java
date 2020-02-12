package com.example.pengeluaranNew.validator;

import java.util.Map;
import java.util.HashMap;

import com.example.pengeluaranNew.repository.UserRepository;
import com.example.pengeluaranNew.vo.UserRequestVO;
import com.example.pengeluaranNew.validator.MandatoryValidator;
import com.example.pengeluaranNew.domain.User;
import com.example.pengeluaranNew.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends BaseValidator{

@Autowired
UserRepository userRepository;

@Autowired
MandatoryValidator mandatoryValidator;


    // public String validateAdd(UserRequestVO vo){

    //     User model = userRepository.findByEmail(vo.getEmail());
    //     if(model!=null){
    //         return "Email already exist";
    //     }

    //     return null;
    // }


    public <T> String UserValidator(UserRequestVO vo) {
        Map<String, T> mandatories = new HashMap();
        mandatories.put("Name", (T) vo.getName());
        mandatories.put("Address", (T) vo.getAddress());
        mandatories.put("Email", (T) vo.getEmail());
        mandatories.put("phone", (T) vo.getPhone());
        String mandatoryCheck = mandatoryValidator.ValidateMandatoryFields(mandatories);
        if(mandatoryCheck!=null){
            return mandatoryCheck;
        }
        // check name
        User model = userRepository.findByName(vo.getName());
        if(model==null){
            return "user not found";
        }
        

        return null;

    }
    public String validateTransaksi2(UserRequestVO vo){
        if(ValidationUtil.isEmptyOrNull(vo.getName())) return "Name can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getAddress())) return "Address can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getEmail())) return "Email can't be empty";
        if(ValidationUtil.isEmptyOrNull(vo.getPhone())) return "Phone transaksi can't be empty";
        return null;
        
    }

}