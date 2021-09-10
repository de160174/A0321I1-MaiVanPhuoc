package bai11_stack_queue.bai_tap.bai3_count_word_using_map;

import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        String string = "tôi là học viên viên lớp A03";
        String[] strings = string.toUpperCase().split(" ");
        for(String i: strings){
            System.out.println(i);
        }
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        for(int i=0;i<strings.length;i++){
            //containsKey() dùng để kiểm tra một Key có tồn tại trong HashMap hay không. Nếu không tồn tại nó sẽ trả về false, ngược lại true
            //neu treemap khong ton tai thi put key vao neu da ton tai thi treemap se gán key và tăng value len 1
            if(!treeMap.containsKey(strings[i])){
                treeMap.put(strings[i],1);
            }else{
                treeMap.put(strings[i],treeMap.get(strings[i])+1);
            }
        }
        for(String key:treeMap.keySet()){
            System.out.println(key+ " "+treeMap.get(key));
        }

    }
}
