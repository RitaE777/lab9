package org.example;
    @FunctionalInterface
    public interface QuadPredicate<A, B, C, D> {
        boolean test(A q, B w, C e, D r);
    }

