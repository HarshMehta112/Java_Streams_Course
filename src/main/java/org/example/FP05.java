package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 6/2/24 11:25 PM
 */
public class FP05
{
    public static void main(String[] args)
    {
        //another way to create the stream is using stream.of() method
        // this method return wrapper class

        System.out.println(Stream.of(1,2,3,4,5,6,7,8).count());

        System.out.println(Stream.of(1,2,3,4,5,6,7,8).reduce(0,Integer::sum));

        int[] array = {1,2,3,4,5,6,7,8};

        //here stream is stream of primitive data type so we can do min max directly
        System.out.println(Arrays.stream(array).max());
    }
}
