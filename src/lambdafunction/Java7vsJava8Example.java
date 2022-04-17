package lambdafunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java7vsJava8Example {

    public static void main(String[] args) {
      //before
        int total = 0;
        for (int i=0;i<=50;i++){
            total += i;
        }
        System.out.println("Total is : "+ total);

        //after
        int totalNew = IntStream.rangeClosed(0,50)
                .map(Integer::new)
                .sum();
        System.out.println("Total is (in java 8) : "+ totalNew);

        //print the distinct name from a list

        //Java7
        List<String> rawList = Arrays.asList("Sam","Ram","Ritesh","Peter","Sam","Gopal","Ram");
        List<String > distinctList = new ArrayList<>();
        for (String name: rawList
             ) {
            if(!distinctList.contains(name)){
               distinctList.add(name) ;
            }
        }
        System.out.println("Distinct List in Java 7 : "+ distinctList);

        //java8
        List<String> distinctListJava8 = rawList.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct List in Java 8 : "+ distinctListJava8);
    }


}
