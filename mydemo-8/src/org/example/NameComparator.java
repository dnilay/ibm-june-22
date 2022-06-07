package org.example;

import java.util.Comparator;

public class NameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return(((Employee)o1).getName().compareTo(((Employee)o2).getName()));
    }
}
