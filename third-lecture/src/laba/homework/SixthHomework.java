package laba.homework;

import laba.homework.list.CustomLinkedList;

import java.util.LinkedList;
import java.util.List;

public class SixthHomework {
    /*Add 5 collections to the hierarchy.
    Create custom LinkedList with generic.*/
    public static void main(String[] args) {

        //overloaded constructor
        List<Integer> custom = new CustomLinkedList<>();
        //List<Integer> custom = new CustomLinkedList<>(List.of(12,234,234,234,2,32,34,234,234,234));

        System.out.println("Is empty: " + custom.isEmpty());
        System.out.println("Size: " + custom.size());

        custom.add(1);
        custom.add(3);
        custom.add(2);
        custom.add(6);

        System.out.println("Contains 1: " + custom.contains(1));
        System.out.println("Contains 6: " + custom.contains(6));

        custom.add(9);
        custom.add(34);

        System.out.println("Contains 34: " + custom.contains(34));
        System.out.println("Size: " + custom.size());
        System.out.println("Is empty: " + custom.isEmpty());

    }

}
