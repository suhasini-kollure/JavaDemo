package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtilityDemo {
    public static void main(String[] args) {

        //Example List of Cricketers

        List<String> cricketers = Arrays.asList("Rohit Sharma", "Virat Kohli", "Jasprit Bhumra", "Ravindra", "Rahul", "Shubham Gill", "Hardik Pandya");

        //sorting in Ascending order
        Collections.sort(cricketers);
        System.out.println("Ascending order : " + cricketers);

        //custom sorting: Sort by name length
        Collections.sort(cricketers, ((o1, o2) -> o2.length() - o1.length()));
        System.out.println("Sort by name length ascending: " + cricketers);

        cricketers.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println("Sort by name length descending: " + cricketers);

        //Sorting in Descending order
        Collections.sort(cricketers.reversed());
        System.out.println("Descending order : " + cricketers);

        //Searching : Use Binary Search on a sorted list
        Collections.sort(cricketers);
        int index = Collections.binarySearch(cricketers, "Jasprit Bhumra");
        System.out.println("Binary Search : " + index);

        //Reversing : reverse the list order
        Collections.reverse(cricketers);
        System.out.println("reverse the list : " + cricketers);

        //Shuffling : shuffle the list for random order
        Collections.shuffle(cricketers);
        System.out.println("Shuffling : " + cricketers);

        //Swapping : Swap elements at specified indices
        Collections.swap(cricketers, 0, cricketers.size()-1);
        System.out.println("Swap elements : " + cricketers);
    }
}
