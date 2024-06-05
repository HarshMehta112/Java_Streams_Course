package org.example;

import java.util.List;
import java.util.stream.LongStream;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 6/4/24 10:39 AM
 */
public class FP05Parallelizing
{
    public static void main(String[] args)
    {
        long time  = System.currentTimeMillis();

        System.out.println(LongStream.range(0,1000000000).parallel().sum());

        System.out.println(System.currentTimeMillis()-time);

        //without parallelizm 479 Miliseconds
        // with parallelizm 89 Miliseconds

    }

    /**
     * The problem in parallelizing the structured code is lot of
     * state was present and it is continuous changes.
     * Here we can see state of sum variable changes every time so we have to run it in single core.
     * */

    private static int addListStructuredApproach(List<Integer> list)
    {
        int sum=0;

        for (int num : list)
        {
            sum+=num;
        }

        return sum;
    }

    /**
     * When we add parallel in stream it will run in multiple core
     * Java internally splits the main stream into multiple stream and combining results
     * of each stream at the end of operation.
     * */

    private static int addListFunctionalApproach(List<Integer> list)
    {
        return list.stream().parallel().reduce(0,Integer::sum);
    }

}
