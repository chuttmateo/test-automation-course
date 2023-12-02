package com.solvd.zoomaven.models;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class EleventhHomework {

    public static void main(String[] args) {
        //Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
        try {
            //Create object and call method using the only reflection.
            createObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        //Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods.
        extractInformationFromClassMethods(Zoo.class);
        extractInformationFromClassFields(Zoo.class);
        extractInformationFromClassConstructors(Zoo.class);
    }
    public static void createObject() throws Exception {
        System.out.println("Create object and call method using the only reflection: ");
        System.out.println("FIRST WAY");
        Class<Person> clazz =  Person.class;

        Person instance = clazz
                .getConstructor(String.class, String.class, int.class)
                .newInstance("Mateo", "Chutt", 349857);

        System.out.println(instance.getFirstName());
        System.out.println(instance.getLastName());


        System.out.println("SECOND WAY");
        Class<?> clazz1 = Person.class;
        Object instance2 = clazz
                .getConstructor(String.class, String.class, int.class)
                .newInstance("Mateo", "Chutt", 349857);


        Method getFirstName = clazz1.getMethod("getFirstName");
        String firstName = getFirstName.invoke(instance2).toString();

        Method getLastName = clazz1.getMethod("getLastName");
        String lastName = getLastName.invoke(instance2).toString();

        System.out.println(firstName);
        System.out.println(lastName);
    }

    public static void extractInformationFromClassMethods(Class<?> clazz){
        System.out.println("Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods.");
        System.out.println("Class Name: " + clazz.getSimpleName());
        System.out.println(" ");
        Method[] methods = clazz.getMethods();
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
