package lambdafunction;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        //lambda
        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);
        //method reference
        Comparator<Integer> c3 = Integer::compareTo;

        System.out.println("Comparator result in Java 7: "+ c1.compare(10,26));
        System.out.println("Comparator result in Java 8 using lambda: "+ c2.compare(10,26));
        System.out.println("Comparator result in Java 8 using method reference: "+ c3.compare(10,26));
    }
}
