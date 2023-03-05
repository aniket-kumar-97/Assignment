package Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwappingMinMax {

    public static void main(String[] args) {

        // Test Case:- 1
//        List<Integer> l1 = Arrays.asList(1,2,6,5,1,2);
//        List<Integer> l2 = Arrays.asList(3,4,3,2,2,5);

        // Test Case:- 2
//        List<Integer> l1 = Arrays.asList(8,7,9,6,5,6,6,5,6,4,6,7,8,5,4,3,2,1,4,5,6,7,8,7,8);
//        List<Integer> l2 = Arrays.asList(2,4,5,6,7,6,7,8,9,8,7,6,7,6,5,4,3,2,3,4,5,5,5,4,5);

        // Test Case:- 3
        List<Integer> l1 = Arrays.asList(1,2,3,2,3,4,5,3,5,6,7,8);
        List<Integer> l2 = Arrays.asList(2,1,5,3,4,6,4,3,2,3,1,2);

        System.out.println(minMax(l1, l2));

    }

    public static int minMax(List<Integer> l1, List<Integer> l2) {

        for (int i = 0; i < l1.size(); i++) {
            if(l1.get(i) < l2.get(i)) {
                swap(l1, l2, i);
            }
        }

        return Collections.max(l1) * Collections.max(l2);
    }

    public static void swap(List<Integer> l1, List<Integer> l2, int i) {
        int temp = l1.get(i);
        l1.set(i, l2.get(i));
        l2.set(i, temp);
    }
}

/*
        Explanation:-
            In this we need to minimize product of max(list1) * max(list2).
            For a particular index, we can keep all the max element in list1 and min in list2.
            After swap, we can take product of max from list1 and max from list2.
 */
