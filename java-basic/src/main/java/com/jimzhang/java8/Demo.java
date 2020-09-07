package com.jimzhang.java8;

import java.time.LocalDate;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public class Demo {


    public static void main(String[] args) {
        iterate(LocalDate.now(), date -> date.plusDays(1)).limit(1).forEach(System.out::println);
    }
}
