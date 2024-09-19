package org.example;

import org.example.QuadPredicate;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {
    public static <T, R> R runFunction(Function<T, R> function, T input) {
        return function.apply(input);
    }

    public static <T> boolean runPredicate(Predicate<T> predicate, T input) {
        return predicate.test(input);
    }
    public static <T, U> boolean runBiPredicate(BiPredicate<T, U> biPredicate, T input1, U input2) {
        return biPredicate.test(input1, input2);
    }
    public static <A, B, C, D> boolean runQuadPredicate(
            QuadPredicate<A, B, C, D> predicate,
            A arg1, B arg2, C arg3, D arg4
    ) {
        return predicate.test(arg1, arg2, arg3, arg4);
    }
}