package org.example;

import java.util.List;
import java.util.function.Supplier;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 6/2/24 5:57 PM
 */
public class FP03MethodReferences
{
    public static void main(String[] args)
    {
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

        courses.stream().map(str->str.toUpperCase()).forEach(System.out::println);


        //here we are calling the method reference to public non-static method,
        // so internally we are creating the instance of the class and calling the method

        courses.stream().map(String::toUpperCase).forEach(System.out::println);

        //this is code that return new string object whenever supplier is called.
        Supplier<String> supplier = () -> new String();

        //we can write this thing in different way using the concept of constructor references.
        Supplier<String> supplier1 = String::new;

    }
}
