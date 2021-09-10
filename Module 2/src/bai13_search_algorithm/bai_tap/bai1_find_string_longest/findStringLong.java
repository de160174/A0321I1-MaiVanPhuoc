package bai13_search_algorithm.bai_tap.bai1_find_string_longest;

import java.util.LinkedList;
import java.util.Scanner;

public class findStringLong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            if (list.size()>1&& string.charAt(i) <= list.getLast()) {
                list.clear();
            }
            list.add(string.charAt(i));
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }

        }
        for (Character character : max) {
            System.out.println(character);
        }
        System.out.println();
    }
}
