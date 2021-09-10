package bai2_loop.bai_tap;

public class Prime100 {
    public static void main(String[] args) {
        String result = "";
        for (int i = 2; i < 100; i++) {
            boolean check = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
            if (check) {
                result += i + " ";
            }
        }
        System.out.println("số nguyên tố nhỏ hơn 100 " + result);
    }
}
