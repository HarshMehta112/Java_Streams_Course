package org.example;

import java.util.List;

/**
 * Author: Harsh Mehta
 * Date: 5/3/24 4:46 PM
 */
public class FP01Exercises
{
    /**
     * Exercise 1 : Print Only Odd Numbers from the List
     * */

    private static void printOddNumbers(List<Integer> list)
    {
        list.stream().filter(num->num%2!=0).forEach(System.out::println);
    }

    /**
     * Exercise 2 - Print All Courses individually
     * */

    private static void printCourses(List<String> list)
    {
        list.stream().forEach(System.out::println);
    }

    /**
     * Exercise 3 - Print Courses Containing the word "Spring"
     * */

    private static void printCoursesContainsSpring(List<String> list)
    {
        list.stream().filter(name -> name.contains("Spring")).forEach(System.out::println);
    }

    /**
     * Exercise 4 - Print Courses Whose Name has atleast 4 letters.
     * */

    private static void printCoursesNameLengthGreaterThan4(List<String> list)
    {
        list.stream().filter(name -> name.length()>=4).forEach(System.out::println);
    }

    /**
     * Concept of Mapper function - it is lambda function that maps the value to our own modified value.
     * */

    private static void printSquareOfOddNumbers(List<Integer> list)
    {
        list.stream().filter(n->n%2!=0).map(num -> num * num).forEach(System.out::println);
    }

    /**
     * Exercise 5 - Print the cubes of odd numbers
     * */

    private static void printCubeOfOddNumbers(List<Integer> list)
    {
        list.stream().filter(number -> number%2!=0).map(number -> number*number*number).forEach(System.out::println);
    }

    /**
     * Exercise 6 - Print the number of characters in each course name
     * */

    private static void printCharacterForEachName(List<String> list)
    {
        list.stream().map(name -> name + " " + name.length()).forEach(System.out::println);
    }

    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println("------------Print Only Odd Numbers from the List---------");

        printOddNumbers(numbers);

        System.out.println("--------------Print All Courses individually------------");

        printCourses(courses);

        System.out.println("--------------Print Courses Containing the word \"Spring\"------------");

        printCoursesContainsSpring(courses);

        System.out.println("--------------Print Courses Whose Name has atleast 4 letters------------");

        printCoursesNameLengthGreaterThan4(courses);

        System.out.println("--------------Print Squares of odd numbers------------");

        printSquareOfOddNumbers(numbers);

        System.out.println("--------------Print cubes of odd numbers------------");

        printCubeOfOddNumbers(numbers);

        System.out.println("--------------Print the number of characters in each course name------------");

        printCharacterForEachName(courses);
    }

}
