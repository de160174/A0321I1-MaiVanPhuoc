package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService{
    @Override
    public String save(int num1, int num2, String operation) {
        double result=0;
        if (operation.equals("add")){
            result=num1+num2;
        }else if(operation.equals("sub")){
            result=num1-num2;
        }else if(operation.equals("mul")){
            result=num1*num2;
        }else if(operation.equals("div")){
            if (num2==0){
                return "khong the chia cho 0";
            }else {
                result=num1/num2;
            }
        }
        return String.valueOf(result);
    }
}
