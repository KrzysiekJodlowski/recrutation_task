package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class BracketChecker {

    private String brackets;

    public BracketChecker(String brackets) {
        this.brackets = brackets;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        boolean result = false;

        if (this.brackets == null || this.brackets.length() == 0) {
            return result;
        } else {
            List<Character> checkedBrackets = new ArrayList<>();

            for (char bracket : brackets.toCharArray()) {
                if (bracket == '(' || bracket == '{' || bracket == '[') {
                    checkedBrackets.add(bracket);
                } else {
                    Character lastChar = checkedBrackets.get(checkedBrackets.size() -1);
                    if ((bracket == ')' &&  !lastChar.equals('(')) ||
                            (bracket == '}' &&  !lastChar.equals('{')) ||
                            (bracket == ']' &&  !lastChar.equals('['))) {
                        result = false;
                    } else {
                        checkedBrackets.remove(checkedBrackets.size() -1);
                    }
                }
            }
        }
        return result;
    }
}
