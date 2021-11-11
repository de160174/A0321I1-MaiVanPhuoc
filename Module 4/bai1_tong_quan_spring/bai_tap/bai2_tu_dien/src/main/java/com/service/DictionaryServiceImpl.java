package com.service;


public class DictionaryServiceImpl implements DictionaryService{

    @Override
    public String dict(String word) {
        String[] arrayEn= {"hello","car","house","computer"};
        String[] arrayVi= {"xin chào","xe hơi","căn nhà","máy tính"};
        for (int i=0;i<arrayEn.length;i++){
            if (word.equals(arrayEn[i])){
                word= arrayVi[i];
                return word;
            }
        }
        word="not found!!";
        return word;
    }
}
