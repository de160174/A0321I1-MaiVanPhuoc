package bai4_class_object.bai_tap;

import java.util.Arrays;

public class StopWatch {
    private long starTime,endTime;
    public StopWatch(){
    }
    public void star(){
         starTime= System.currentTimeMillis();
    }
    public void end(){
         endTime= System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime-starTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch=new StopWatch();
        int[] array=new int[100000];
        for(int i=0;i<array.length;i++){
            array[i]= (int) (Math.random()*100000);
        }
        stopWatch.star();
        Arrays.sort(array);
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
