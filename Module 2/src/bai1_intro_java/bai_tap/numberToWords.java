package bai1_intro_java.bai_tap;

import java.util.Scanner;

public class numberToWords {
    final static String[] unit = {"", "one", "two", "three", "four", "five", "six", "seven", " eight", " nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", " sixteen", "seventeen", "eighteen", " nineteen"};
    final static String[] drozen = {"", "", "twenty", "thirty", " forty", "fifty", " sixty", "seventy", " eighty", "ninety"};

    public static void readNumber(int num, String value) {
        System.out.println(num > 19 ? drozen[num / 10] + " " + unit[num % 10] : unit[num]);
        System.out.println(num > 0 ? value : "");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        readNumber(((num / 100) % 10), " hundred and ");
        readNumber(num % 100, "");
    }
}
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Number: ");
//        int number = scanner.nextInt();
//        int hundred = number / 100;
//        int dozen = (number / 10) % 10;
//        int unit = number % 10;
//        String dozens = "";
//        String hundreds = "";
//        if (number < 10 && number >= 0) {
//            switch (number) {
//                case 0:
//                    System.out.println("zero");
//                    break;
//                case 1:
//                    System.out.println("one");
//                    break;
//                case 2:
//                    System.out.println("two");
//                    break;
//                case 3:
//                    System.out.println("three");
//                    break;
//                case 4:
//                    System.out.println("four");
//                    break;
//                case 5:
//                    System.out.println("five");
//                    break;
//                case 6:
//                    System.out.println("six");
//                    break;
//                case 7:
//                    System.out.println("seven");
//                    break;
//                case 8:
//                    System.out.println("eight");
//                    break;
//                case 9:
//                    System.out.println("nine");
//                    break;
//                default:
//                    System.out.printf("out of ability");
//            }
//        } else if (number < 20 && number >= 10) {
//            int a = number % 10;
//            switch (a) {
//                case 0:
//                    System.out.println("ten");
//                    break;
//                case 1:
//                    System.out.println("eleven");
//                    break;
//                case 2:
//                    System.out.println("twelve");
//                    break;
//                case 3:
//                    System.out.println("thirteen");
//                    break;
//                case 4:
//                    System.out.println("fourteen");
//                    break;
//                case 5:
//                    System.out.println("fifteen");
//                    break;
//                case 6:
//                    System.out.println("sixteen");
//                    break;
//                case 7:
//                    System.out.println("seventeen");
//                    break;
//                case 8:
//                    System.out.println("eighteen");
//                    break;
//                case 9:
//                    System.out.println("nineteen");
//                    break;
//            }
//        } else if (number < 100 && number >= 20) {
//            switch (unit) {
//                case 0:
//                    dozens = "zero";
//                    break;
//                case 1:
//                    dozens = "one";
//                    break;
//                case 2:
//                    dozens = "two";
//                    break;
//                case 3:
//                    dozens = "three";
//                    break;
//                case 4:
//                    dozens = "four";
//                    break;
//                case 5:
//                    dozens = "five";
//                    break;
//                case 6:
//                    dozens = "six";
//                    break;
//                case 7:
//                    dozens = "seven";
//                    break;
//                case 8:
//                    dozens = "eight";
//                    break;
//                case 9:
//                    dozens = "nine";
//                    break;
//            }
//            switch (dozen) {
//                case 2:
//                    System.out.println("twenty " + dozens);
//                    break;
//                case 3:
//                    System.out.println("thirty " + dozens);
//                    break;
//                case 4:
//                    System.out.println("forty " + dozens);
//                    break;
//                case 5:
//                    System.out.println("fifty " + dozens);
//                    break;
//                case 6:
//                    System.out.println("sixty " + dozens);
//                    break;
//                case 7:
//                    System.out.println("seventy " + dozens);
//                    break;
//                case 8:
//                    System.out.println("eighty " + dozens);
//                    break;
//                case 9:
//                    System.out.println("ninety " + dozens);
//                    break;
//            }
//
//        } else if (number < 999 && number >= 100) {
//            switch (unit) {
//                case 0:
//                    dozens = "zero";
//                    break;
//                case 1:
//                    dozens = "one";
//                    break;
//                case 2:
//                    dozens = "two";
//                    break;
//                case 3:
//                    dozens = "three";
//                    break;
//                case 4:
//                    dozens = "four";
//                    break;
//                case 5:
//                    dozens = "five";
//                    break;
//                case 6:
//                    dozens = "six";
//                    break;
//                case 7:
//                    dozens = "seven";
//                    break;
//                case 8:
//                    dozens = "eight";
//                    break;
//                case 9:
//                    dozens = "nine";
//                    break;
//            }
//            switch (dozen) {
//                case 2:
//                    hundreds = "twenty " + dozens;
//                    break;
//                case 3:
//                    hundreds = "thirty " + dozens;
//                    break;
//                case 4:
//                    hundreds = "forty " + dozens;
//                    break;
//                case 5:
//                    hundreds = "fifty " + dozens;
//                    break;
//                case 6:
//                    hundreds = "sixty " + dozens;
//                    break;
//                case 7:
//                    hundreds = "seventy " + dozens;
//                    break;
//                case 8:
//                    hundreds = "eighty " + dozens;
//                    break;
//                case 9:
//                    hundreds = "ninety " + dozens;
//                    break;
//            }
//            switch (hundred) {
//                case 1:
//                    System.out.println("one hundred and " + hundreds);
//                    break;
//                case 2:
//                    System.out.println("two hundred and " + hundreds);
//                    break;
//                case 3:
//                    System.out.println("three hundred and " + hundreds);
//                    break;
//                case 4:
//                    System.out.println("four hundred and " + hundreds);
//                    break;
//                case 5:
//                    System.out.println("five hundred and " + hundreds);
//                    break;
//                case 6:
//                    System.out.println("six hundred and " + hundreds);
//                    break;
//                case 7:
//                    System.out.println("seven hundred and " + hundreds);
//                    break;
//                case 8:
//                    System.out.println("eight hundred and " + hundreds);
//                    break;
//                case 9:
//                    System.out.println("nine hundred and " + hundreds);
//                    break;
//            }
//        } else {
//            System.out.println("out of ability");
//        }

