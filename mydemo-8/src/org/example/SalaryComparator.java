package org.example;

import java.util.Comparator;

public class SalaryComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Employee employee1=(Employee) o1;
        Employee employee2=(Employee) o2;
        if(employee1.getSalary()> employee2.getSalary())
        {
            return 1;
        }
        else if (employee1.getSalary()< employee2.getSalary()) {
            return -1;
        }
        else {
            return 0;
        }

    }
}
