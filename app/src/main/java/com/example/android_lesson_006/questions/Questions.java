package com.example.android_lesson_006.questions;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    public static List<Question> getQuestions() {
        List<Question> res = new ArrayList<>();
        res.add(new Question(
                "Who created the Python programming language?",
                        "Guido van Rossum",
                "Dennis M. Ritchie",
                "James Gosling",
                1
                ));
        res.add(
                new Question(
                        "Who created the Java programming language?",
                        "Guido van Rossum",
                        "Dennis M. Ritchie",
                        "James Gosling",
                        3
                )
        );
        res.add(
                new Question(
                        "Who created the Rust programming language?",
                        "Graydon Hoare",
                        "Guido van Rossum",
                        "Larry Wall",
                        1
                )
        );
        res.add(
                new Question(
                        "Who created the JavaScript programming language?",
                        "Graydon Hoare",
                        "Brendan Eich",
                        "Anders Hejlsberg",
                        2
                )
        );
        res.add(
                new Question(
                        "Who created the C++ programming language?",
                        "Graydon Hoare",
                        "Brendan Eich",
                        "Bjarne Stroustrup",
                        3
                )
        );


        return res;
    }
}
