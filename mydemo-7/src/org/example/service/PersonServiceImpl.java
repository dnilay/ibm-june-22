package org.example.service;

import com.sun.source.tree.Tree;
import org.example.model.Person;
import org.example.service.PersonService;

import java.util.*;

public class PersonServiceImpl implements PersonService {

    private List<Person> persons;

    //default block//similar to default constructor
    {
        persons=new ArrayList<>();
    }

    @Override
    public void createPerson(Person person) {
        persons.add(person);
        System.out.println("Person added successfully");

    }

    @Override
    public List<Person> fetchAllPerson() {
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

    @Override
    public void updatePersonById(String personId,Person person) {
        Person p=null;

        Iterator<Person> iterator=persons.iterator();
        boolean flag=false;
        while (iterator.hasNext())
        {
            p=iterator.next();

            if(p.getPersonId().equals(personId))
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
            p.setEmail(person.getEmail());
            p.setFirstName(person.getFirstName());
            p.setLastName(person.getLastName());
            System.out.println("found "+person.getDetails());
        }
    }
}
