package by.it.kanaplianik.jd02_04;

import java.util.ArrayList;

public class TopPriorityOperatorIndex {
    private final ArrayList<Character> operators;

    public TopPriorityOperatorIndex(ArrayList<Character> operators) {

        this.operators = operators;
    }

    public int getValue() {
        for (var i = 0; i < operators.size(); i++) {
            var current = operators.get(i);

            if (current == '*' || current == '/') {
                return i;
            }
        }

        for (var i = 0; i < operators.size(); i++) {
            var current = operators.get(i);

            if (current == '+' || current == '-') {
                return i;
            }
        }

        for (var i = 0; i < operators.size(); i++) {
            var current = operators.get(i);

            if (current == '=') {
                return i;
            }
        }

        return 0;
    }
}
