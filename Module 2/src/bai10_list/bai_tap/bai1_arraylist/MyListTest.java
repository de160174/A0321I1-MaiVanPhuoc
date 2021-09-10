package bai10_list.bai_tap.bai1_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);
        myList.add(3, 4);
        myList.add(4, 5);
        myList.add(5, 6);
        for(int i=0;i<myList.size();i++){
            System.out.println("element "+i+": "+myList.get(i));
        }
        System.out.println("size: "+myList.size());

        MyList<Integer> clone = myList.clone();
        System.out.println("Array clone: ");
        for (int i = 0; i < clone.size(); i++) {
            System.out.println("element " + i + ": " + clone.get(i));
        }
        System.out.println(myList.contains(5));
        System.out.println(myList.indexOf(1));


        myList.remove(0);
        myList.remove(1);
        myList.remove(2);
        for(int i=0;i<myList.size();i++){
            System.out.println("element "+i+": "+myList.get(i));
        }
    }
}

