package org.example.service;

import org.example.model.Person;
import org.example.service.PersonService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PersonServiceImpl implements PersonService {

    private Set<Person> persons;

    //default block//similar to default constructor
    {
        persons=new HashSet<Person>();
    }

    @Override
    public void createPerson(Person person) {
        persons.add(person);
        System.out.println("Person added successfully");

    }

    @Override
    public Set<Person> fetchAllPerson() {
        return persons;
    }

    @Override
    public void getPersonById(String personId) {
        Person person=null;

        Iterator<Person> iterator=persons.iterator();
        boolean flag=false;
        while (iterator.hasNext())
        {
            person=iterator.next();

            if(person.getPersonId().equals(personId))
            {
               flag=true;

                break;

            }
        }

        if (flag==false)
        {
            System.out.println("not found. ");
        }
        else
        {
            System.out.println("found "+person.getDetails());
        }
    }
}
