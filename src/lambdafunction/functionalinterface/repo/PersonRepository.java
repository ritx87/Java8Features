package lambdafunction.functionalinterface.repo;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {
    public static List<Person> getAllPersons(){
        Person[] person = {
                new Person("Ritesh",5.11,55000.00,"M",1, Arrays.asList("read","eat","sleep")),
                new Person("Alex",5.05,25000.00,"M",2, Arrays.asList("read","swim","cricket")),
                new Person("Nilu",5.06,95000.00,"M",0, Arrays.asList("read","eat","coding")),
                new Person("Rajesh",5.11,55000.00,"M",1, Arrays.asList("read","drive","sleep")),
                new Person("Pinu",5.11,15000.00,"M",0, Arrays.asList("read","eat","sleep")),
                new Person("Anita",5.08,0,"F",1, Arrays.asList("cook","eat","sleep")),
                new Person("Sibu",5.10,10000,"M",0, Arrays.asList("read","eat","sleep")),
        };
        return Arrays.asList(person);
    }
}
