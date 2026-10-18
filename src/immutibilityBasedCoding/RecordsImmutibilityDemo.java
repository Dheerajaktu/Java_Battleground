package immutibilityBasedCoding;

import java.util.ArrayList;
import java.util.List;

public class RecordsImmutibilityDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java Full Stack");
        list.add("Java Full Stack with AI");

        Employee e = new Employee(list);
        e.dheeraj().add("Adding new Skils");

        System.out.println(":: Final Skills List:: " + list);
    }
}

// Note - records gives shallow immutibility not deep.
record Employee(List<String> dheeraj) {
};

/*
 * final class Employee {
 * private final List<String> skills = new ArrayList<>();
 * }
 * 
 * 1 - Final --> you can't inherit this class
 * 2 - final with List --> Means you can't assign other list to this one
 * 3 - But you can add values in skills.add()
 */

record Employee1(List<String> val) {
    public Employee1 {
        val = List.copyOf(val); // Here list of immutable here, you can't add now!
    }
}
