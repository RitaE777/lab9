package org.example;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaDemo {
    public static final Function<String, Integer> stringLength = String::length;
    public static final Function<String, Character> symbol = s -> s.isEmpty() ? null : s.charAt(0);
    public static final Predicate<String> checkSpace = s -> !s.contains(" ");
    public static final Function<String, Long> wordCount = s -> s.isEmpty() ? null : Arrays.stream(s.split(",")).count();
    public static final Function<Human,Integer> age = Human::getAge;
    public static final BiPredicate<Human, Human> equalsSurName = (p1, p2) -> p1.getSurName().equals(p2.getSurName());
    public static final Function<Human, String> fullName = p -> p.getSurName() + " " + p.getName() + " " + p.getLastName();
    public static final UnaryOperator<Human> oneYearOlder = h -> new Human(h.getName(), h.getSurName(), h.getLastName(), h.getAge() + 1,h.getGender());
    public static final QuadPredicate<Human, Human, Human, Integer> allYoungerThan = (h1, h2, h3, maxAge) -> h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;
}
