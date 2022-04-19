package lambdafunction.functionalinterface.test;

import lambdafunction.functionalinterface.repo.Person;
import lambdafunction.functionalinterface.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
  static   List<Person> personList = PersonRepository.getAllPersons();

    //Consumer: an operation which takes an arg and returns nothing

    //static Consumer<Person> c = (p) -> System.out.println(p);
    //static Consumer<Person> c1 = System.out::println;

    //static Consumer<Person> c2 = (p)-> System.out.println(p.getName().toUpperCase());

    //static Consumer<Person> c3 = (p) -> System.out.println(p.getHobbies());

    //To print the list of all the person details
    static Consumer<List<Person>> c1 = System.out::println;


    //to print the person list one by one
    //l - List<Person>
    //s - Person
    static Consumer<List<Person>> c2 = l -> l.forEach((s)-> System.out.println(s));
    //print the name in upper case
    static Consumer<List<Person>> c3 = l -> l.forEach((s)-> System.out.println(s.getName().toUpperCase()));
    //print the hobbies of each person
    static Consumer<List<Person>> c4 = l -> l.forEach((s)-> System.out.println(s.getHobbies()));

    //print the sorted list by name
    //static Consumer<List<Person>> c5 =  l -> l.sort((Person p1,Person p2)->p1.getName().compareTo(p2.getName()));
    //static Consumer<List<Person>> c6 = l -> l.forEach((s)-> System.out.println(s));
                            //or
    static Consumer<List<Person>> c5 =  l -> l.sort(Comparator.comparing(Person::getName));
    static Consumer<List<Person>> c6 = l -> l.forEach(System.out::println);
     //print the sorted list by name in descending order
    static Consumer<List<Person>> c7 =  l -> l.sort((Person p1,Person p2)->p2.getName().compareTo(p1.getName()));
    static Consumer<List<Person>> c8 = l -> l.forEach(System.out::println);

    //print the name in upper case
    static Consumer<Person> c11 = (s)-> System.out.println(s.getName().toUpperCase());
    //print the hobbies of each person
    static Consumer<Person> c22 = (s)-> System.out.println(s.getHobbies());

    private static void printFemaleWithHobby() {
        personList.forEach(p->{
            if(p.getGender().equalsIgnoreCase("f"))
                c11.andThen(c22).accept(p);
        });
    }

    //or
    static Consumer<List<Person>> c33 = l -> l.forEach(p->{
         if(p.getGender().equalsIgnoreCase("F"))
                c3.andThen(c4).accept(l);
    });

    public static void main(String[] args) {
       // List<Person> personList = PersonRepository.getAllPersons();

       // c1.accept(personList);
        //c2.accept(personList);
        //c3.accept(personList);
       // c4.accept(personList);

        //To print the sorted list we have to first call the c5 consumer then call c6
        //or else if you call the c6 then it return the unsorted list
        //c5.accept(personList);
       // c6.accept(personList);
        //or
        System.out.println();
        //it will first execute c5 ie sort the list and the call c6 ie call c6
       // c5.andThen(c6).accept(personList);
        //c7.andThen(c8).accept(personList);
/*Person{name='Alex', height=5.05, salary=25000.0, gender='M', kids=2, hobbies=[read, swim, cricket]}
Person{name='Anita', height=5.08, salary=0.0, gender='F', kids=1, hobbies=[cook, eat, sleep]}
Person{name='Nilu', height=5.06, salary=95000.0, gender='M', kids=0, hobbies=[read, eat, coding]}
Person{name='Pinu', height=5.11, salary=15000.0, gender='M', kids=0, hobbies=[read, eat, sleep]}
Person{name='Rajesh', height=5.11, salary=55000.0, gender='M', kids=1, hobbies=[read, drive, sleep]}
Person{name='Ritesh', height=5.11, salary=55000.0, gender='M', kids=1, hobbies=[read, eat, sleep]}
Person{name='Sibu', height=5.1, salary=10000.0, gender='M', kids=0, hobbies=[read, eat, sleep]}*/

        //print the female with their hobbies
        printFemaleWithHobby();
        c33.accept(personList);

    }


}
