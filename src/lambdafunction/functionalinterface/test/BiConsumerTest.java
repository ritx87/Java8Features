package lambdafunction.functionalinterface.test;

import lambdafunction.functionalinterface.repo.Person;
import lambdafunction.functionalinterface.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerTest {
    //print the person name with their hubbies
    static void printPersonDetails(){
        List<Person> personList = PersonRepository.getAllPersons();
        Consumer<List<Person>> c5 = l -> l.sort(Comparator.comparing(Person::getName));
        BiConsumer<String, List<String>> personConsumer = (name,hubbies)-> System.out.println(name+" "+hubbies);
        BiConsumer<String, Double> salaryConsumer = (name,salary)-> System.out.println(name+" "+salary);


        //personList.forEach(person -> bc1.accept(person.getName(),person.getHobbies()));
        c5.accept(personList);
        personList.forEach(person ->{

            personConsumer.accept(person.getName(),person.getHobbies());
            salaryConsumer.accept(person.getName(),person.getSalary());
        });
    }

    public static void main(String[] args) {
        printPersonDetails();
    }
}
