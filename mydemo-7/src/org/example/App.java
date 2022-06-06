package org.example;

import org.example.model.Person;
import org.example.service.PersonServiceImpl;
import org.example.service.PersonService;

import java.util.*;

public class App {
//set does not allow duplicate values

    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)
    {

        PersonService service=new PersonServiceImpl();
        int choice=0;
        String id,fName,lName,email=null;
        do {
            System.out.println("1. Create A New Person");
            System.out.println("2. Display All Available Person(s)");
            System.out.println("3. Get A Person By ID: ");
            System.out.println("4. Update Person by id.");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    String str[]= UUID.randomUUID().toString().split("-");
                    id=str[0];
                    System.out.print("Enter First Name: ");
                    fName=scanner.next();
                    System.out.print("Enter Last Name: ");
                    lName=scanner.next();
                    System.out.print("Enter Email: ");
                    email=scanner.next();
                    service.createPerson(new Person(id,fName,lName,email));
                    break;
                case 2:
                    List<Person> set=service.fetchAllPerson();
                    if(set.isEmpty())
                    {
                        System.out.println("no person(s) available");
                    }
                    else {
                        for (Person p:set)
                        {
                            System.out.println(p.getDetails());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    id=scanner.next();
                   service.getPersonById(id);

                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    id=scanner.next();
                    service.updatePersonById(id,new Person("rahul","dravid","rahul@email.com"));
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice...!");
                    break;
            }


        }while (choice!=0);

       /* Set<Integer> set=new TreeSet<Integer>();
        set.add(11);
        set.add(10);
        set.add(-1);
        set.add(0);
        set.add(20);

        System.out.println(set);
        List<Integer>list=new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(-1);
        list.add(5);
        list.add(20);
        System.out.println(list);*/


    }
}
