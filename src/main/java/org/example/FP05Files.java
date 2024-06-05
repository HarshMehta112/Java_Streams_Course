package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Description:
 * Author: Harsh Mehta
 * Date: 6/4/24 10:38 PM
 */
public class FP05Files
{
    public static void main(String[] args)  throws Exception
    {
        Files.lines(Paths.get("file.txt")).forEach(System.out::println);

        Files.lines(Paths.get("file.txt"))
                .map(str->str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
