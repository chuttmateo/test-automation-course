package com.solvd.zoomaven;

import com.solvd.zoomaven.enums.DaysOFTheWeek;
import com.solvd.zoomaven.enums.EnclosureType;
import com.solvd.zoomaven.enums.Health;
import com.solvd.zoomaven.models.*;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EleventhHomework {

    public static void main(String[] args) {
        //Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
        //there are 5 collection streaming in Zoo class and 4 in EleventhHomework class

        Enclosure enclosure = new Enclosure(EnclosureType.AQUARIUM);
        enclosure.addAnimal(new Lion(2345,"red", Health.HEALTHY, 34));
        Zoo zoo = new Zoo("the zoo", DaysOFTheWeek.MONDAY);
        zoo.addEnclosure(enclosure);
        Predicate<Animal> predicate = (a)-> a.getHealth() != Health.CRITICAL;
        zoo.addAnimal(new Fish(234234, "white", Health.HEALTHY, true), predicate);
        zoo.addAnimal(new Fish(2342342, "white", Health.HEALTHY, true), predicate);
        System.out.println(" ");

        try {
            //Create object and call method using the only reflection.
            createObject();
            System.out.println(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
        //Using reflection extract information(modifiers, return types, parameters, etc.)
        // about fields, constructors, methods.
        extractInformationFromClassMethods(Person.class);
        extractInformationFromClassFields(Zoo.class);
        extractInformationFromClassConstructors(Zoo.class);
    }
    public static void createObject() throws Exception {
        System.out.println("Create object and call method using the only reflection: ");
        Class<Person> clazz =  Person.class;

        Person instance = clazz
                .getConstructor(String.class, String.class, int.class)
                .newInstance("Mateo", "Chutt", 349857);

        Method getFirstName = clazz.getMethod("getFirstName");
        String firstName = getFirstName.invoke(instance).toString();

        Method getLastName = clazz.getMethod("getLastName");
        String lastName = getLastName.invoke(instance).toString();

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println("We can also use getFirstName normally");
        System.out.println(instance.getFirstName());
        System.out.println(instance.getLastName());

    }
    public static void extractInformationFromClassMethods(Class<?> clazz){
        System.out.println("Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods.");
        System.out.println("Class Name: " + clazz.getSimpleName());
        System.out.println(" ");
        //Method[] methods = clazz.getMethods(); //This Method returns all public methods, including Object class methods
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods)
                .forEach(method -> {
                    System.out.println("Method Name: " + method.getName());

                    System.out.println("Method modifiers: " + Modifier.toString(method.getModifiers()));
                    System.out.println("Method Return type: " + method.getReturnType().getSimpleName());

                    //this line is to create more-readable parameters list
                    List<String> parameters = parameterListToStringList(method.getParameters());

                    System.out.println("Method parameters: " + parameters);
                    System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "( " + parameters + " );");
                    System.out.println(" ");
                });

    }
    public static void extractInformationFromClassFields(Class<?> clazz){
        System.out.println(" ");
        System.out.println("Extract Fields Information From Class " + clazz.getSimpleName() + " -------------");
        System.out.println(" ");
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0){
            System.out.println("This class doesn't contain fields");
            return;
        }
        Arrays.stream(fields).forEach(field -> {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() );
            System.out.println(" ");
        });
    }
    public static void extractInformationFromClassConstructors(Class<?> clazz){
        System.out.println(" ");
        System.out.println("Extract information from class constructors---------");
        System.out.println(" ");
        Constructor<?>[] constructors = clazz.getConstructors();
        Arrays.stream(constructors)
                .forEach(c -> {
                    //this line is to create more-readable parameters list
                    List<String> parameters = parameterListToStringList(c.getParameters());
                    System.out.println(Modifier.toString(c.getModifiers()) + " " + c.getDeclaringClass().getSimpleName() + " " + parameters);
                });
    }
    public static List<String> parameterListToStringList(Parameter[] parameters){
        return Arrays.stream(parameters)
                .map(parameter -> parameter.getType().getSimpleName() + " " + parameter.getName())
                .toList();
    }
}
