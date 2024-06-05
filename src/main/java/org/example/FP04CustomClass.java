package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 6/2/24 6:13 PM
 */

class Course
{
    private String name;

    private String category;

    public Course(String name, String category, int reviewScore, int noOfStudents)
    {
        super();

        this.name = name;

        this.category = category;

        this.noOfStudents = noOfStudents;

        this.reviewScore = reviewScore;
    }

    @Override
    public String toString()
    {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    private int reviewScore;

    private int noOfStudents;

}


public class FP04CustomClass
{
    public static void main(String[] args)
    {
        List<Course> courses = List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","MicroServices",97,22000),
                new Course("MicroServices","MicroServices",96,25000),
                new Course("FullStack","FullStack",91,14000),
                new Course("AWS","Cloud",92,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000)
                );

        //we are now see the functions like allMatch, noneMatch, anyMatch
        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 90));

        System.out.println(courses.stream().anyMatch(course -> course.getReviewScore() > 95));

        System.out.println(courses.stream().noneMatch(course -> course.getReviewScore() < 90));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents).reversed();

        Comparator<Course> comparingByNoOfStudentsAndRatings = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();

        System.out.println(courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList()));


        //Now I want that if the no of students are same then I want to sort by rating
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndRatings).collect(Collectors.toList()));


        //If we want to you primitive comaprision then use comparingInt() in internally handles the auto boxing and unboxing


        //now if i want to top 5 only then
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndRatings).limit(5).collect(Collectors.toList()));

        //skip first 3 courses
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndRatings).skip(3).limit(5).collect(Collectors.toList()));

        // when ever condition is false it breaks the loop and return
        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));

        //opposite of this function is dropwhile in when first element gets condition is true it will print all element after it
        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));

        //findig max
        System.out.println(courses.stream().max(comparingByNoOfStudentsAndRatings));
        //it will return last element of the list it does not know weather it is a larger of smaller value

        System.out.println(courses.stream().min(comparingByNoOfStudentsAndRatings));
        //it will return first element of the list it does not know weather it is a larger of smaller value

        //stream.min/max does not return null values it internally uses optinal interface so it will return optinal.empty
        System.out.println(courses.stream().filter(course -> course.getReviewScore() < 90).max(comparingByNoOfStudentsAndRatings)); //Optional.empty

        //use orElse to pass default value
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() < 90)
                .max(comparingByNoOfStudentsAndRatings)
                .orElse(new Course("Test","Harsh",40000,99)));

        //finds the first element that matches the condition
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .findFirst()
                .orElse(new Course("Test","Harsh",40000,99)));

        //sum function
        //if we are doing in primitive then use mapToInt instead of map because map is less efficient then mapToInt
        //because it is doing autoboxing internally.

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .mapToInt(Course::getNoOfStudents).sum()
        );

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .mapToInt(Course::getNoOfStudents).average()
        );

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .mapToInt(Course::getNoOfStudents).count()
        );

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .mapToInt(Course::getNoOfStudents).max()
        );

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

        //I want hashmap<category, count>
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));

        //I want higest reviewed course
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        //map the course name only group by category
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList()))));

        /**
         * Higher order are the function that return a another function as a return value.
         * */

        System.out.println(courses.stream().filter(getPredicateBasedOnReviewScore(90)).collect(Collectors.toList()));

    }

    // this is called higher order function
    private static Predicate<Course> getPredicateBasedOnReviewScore(int score)
    {
        return course -> course.getReviewScore() > score;
    }
}
