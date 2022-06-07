package org.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class App {

    public static void main(String args[])
    {
        Set<Student> set=new TreeSet<Student>();
        set.add(new Student(UUID.randomUUID().toString(),"John",4.7));
        set.add(new Student(UUID.randomUUID().toString(),"Marry",5.9));
        set.add(new Student(UUID.randomUUID().toString(),"Rahul",3.9));
        set.add(new Student(UUID.randomUUID().toString(),"David",7.9));
        Comparator c=new NameComparator();
        Set<Employee> set1=new TreeSet<Employee>(c);
        set1.add(new Employee("John",20000));
        set1.add(new Employee("David",19000));
        set1.add(new Employee("Rahul",21000));
        set1.add(new Employee("Sachin",2000));

        for(Student s:set)
        {
            System.out.println(s);
        }
        for(Employee e:set1)
        {
            System.out.println(e);
        }
    }
}
