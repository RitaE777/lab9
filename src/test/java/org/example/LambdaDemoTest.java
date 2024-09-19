package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Gender.MAN;
import static org.example.Gender.WOMAN;
import static org.example.LambdaDemo.*;
import static org.example.LambdaDemo.allYoungerThan;
import static org.example.LambdaRunner.*;
import static org.example.LambdaRunner.runQuadPredicate;
import static org.junit.jupiter.api.Assertions.*;

class LambdaDemoTest {
    /*First task*/
    @Test
    public void testStringLength() {
        assertEquals(4, runFunction(stringLength, "OmSU"));
    }

    @Test
    public void testStringLength2() {
        assertEquals(0, runFunction(stringLength, ""));
    }

    /*Second task*/
    @Test
    public void testFirstChar1() {
        assertEquals('a', runFunction(symbol, "aasfqwzcx"));
    }

    @Test
    public void testFirstChar2() {
        assertEquals(null, runFunction(symbol, ""));
    }

    /*Third task*/
    @Test
    public void testNoSpaces1() {
        assertTrue(runPredicate(checkSpace, "akgmakmgkm"));
    }

    @Test
    public void testNoSpaces2() {
        assertFalse(runPredicate(checkSpace, "aaaaa bbbbb"));
    }

    @Test
    public void testNoSpaces3() {
        assertFalse(runPredicate(checkSpace, " aaaaaaa "));
    }

    /*Fourth task*/
    @Test
    public void testWordCount() {
        assertEquals(3, runFunction(wordCount, "a a, b b, c c"));
    }

    @Test
    public void testWordCount2() {
        assertEquals(3, runFunction(wordCount, "a,b,c"));
    }

    @Test
    public void testWordCount3() {
        assertEquals(1, runFunction(wordCount, "a b c d e"));
    }

    @Test
    public void testWordCount4() {
        assertNull(runFunction(wordCount, ""));
    }

    @Test
    public void testWordCount5() {
        assertEquals(0, runFunction(wordCount, ","));
    }

    /*Fifth task*/
    @Test
    public void testAgeFunction1() {
        Human human = new Human("dmitri", "minckevich", "maksimovich", 19, MAN);
        int expectedAge = 19;
        assertEquals(expectedAge, runFunction(age, human));
    }

    @Test
    public void testAgeFunction2() {
        Student student = new Student("dmitri", "minckevich", "maksimovich", 25, MAN, "OmSU", "FDTK", "Maths");
        int expectedAge = 25;
        assertEquals(expectedAge, runFunction(age, student));
    }

    /*Sixth task*/
    @Test
    public void testSameLastName1() {
        Human human1 = new Human("Daniil", "Meshckov", "Meshock", 20, MAN);
        Human human2 = new Human("Daniil", "Meshckov", "Meshock", 26, WOMAN);
        assertTrue(runBiPredicate(equalsSurName, human1, human2));
    }

    @Test
    public void testSameLastName2() {
        Human human = new Human("Name", "surName", "lastName", 19, MAN);
        Student student = new Student("otherName", "otherSurName", "otherLastName", 18, WOMAN, "OmSU", "FDTC", "Maths");
        assertFalse(runBiPredicate(equalsSurName, human, student));
    }

    @Test
    public void testSameLastName3() {
        Student student1 = new Student("name", "", "lastName", 19, MAN, "OmSU ", "FDTC", "Maths" );
        Student student2 = new Student("otherName", "otherSurName", "otherLastName", 18, MAN, "OmSU", "FDTC", "Maths");
        assertFalse(runBiPredicate(equalsSurName, student1, student2));
    }

    /*Seventh task*/
    @Test
    public void testFullName1() {
        Human human = new Human("Name", "surName", "LastName", 20, MAN);
        assertEquals("surName Name LastName", runFunction(fullName, human));
    }

    @Test
    public void testFullName2() {
        Student student = new Student("Rita", "Epanchinceva", "Dmitrievna", 25, MAN, "OmSU", "FDTC", "Maths");
        assertEquals("Epanchinceva Rita Dmitrievna", runFunction(fullName, student));
    }

    /*Eight task*/
    @Test
    public void testOneYearOlder1() {
        Human human1 = new Human("SurName", "FirstName", "Pattonymic", 19, MAN);
        Student human2 = new Student("SurName", "FirstName", "Pattonymic", 20, MAN, "OmSU", "FDTC", "Maths");
        assertEquals(human2.getAge(), runFunction(oneYearOlder, human1).getAge());
    }

    /*Ninth task*/
    @Test
    public void testAllYungerThanTrue() {
        Human human1 = new Human("SurName", "FirstName", "Pattonymic", 25, MAN);
        Student human2 = new Student("SurName", "FirstName", "Pattonymic", 10, WOMAN, "OmSU", "FDTC", "Maths");
        Human human3 = new Human("SurName", "FirstName", "Pattonymic", 20, MAN);
        int maxAge = 28;
        assertTrue(runQuadPredicate(allYoungerThan,human1,human2,human3, maxAge));
    }

    @Test
    public void testAllYungerThanFalse() {
        Human human1 = new Human("SurName", "FirstName", "Pattonymic", 25, MAN);
        Human human2 = new Human("SurName", "FirstName", "Pattonymic", 10, MAN);
        Human human3 = new Human("SurName", "FirstName", "Pattonymic", 20, MAN);
        int maxAge = 18;
        assertFalse(runQuadPredicate(allYoungerThan, human1, human2, human3, maxAge));
    }

}