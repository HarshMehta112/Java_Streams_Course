package org.example;

import java.util.List;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 04/04/24 11:06 am
 */
public class FP02FunctionalApproach
{
    public static void main(String[] args) {

        System.out.println(addListOfNumbers(List.of(1,2,3,4,5,6,7,8,9,10)));
    }

    private static int addListOfNumbers(List<Integer> list)
    {
        return list.stream().reduce(0, Integer::sum);
    }
}
