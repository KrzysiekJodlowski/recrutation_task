package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class BracketChecker {

    private String brackets;

    public BracketChecker(String brackets) {
        this.brackets = brackets;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {

        if (this.brackets == null || this.brackets.length() == 0) {
            return false;
        } else {
            List<Character> checkedBrackets = new ArrayList<>();

            for (int index = 0; index < brackets.toCharArray().length; index++) {
                char bracket = brackets.toCharArray()[index];
                if (bracket == '(' || bracket == '{' || bracket == '[') {
                    if (index != brackets.toCharArray().length - 1) {
                        checkedBrackets.add(bracket);
                    } else {
                        return false;
                    }
                } else {
                    Character lastChar = checkedBrackets.get(checkedBrackets.size() -1);
                    if ((bracket == ')' &&  !lastChar.equals('(')) ||
                            (bracket == '}' &&  !lastChar.equals('{')) ||
                            (bracket == ']' &&  !lastChar.equals('['))) {
                        return false;
                    } else {
                        checkedBrackets.remove(checkedBrackets.size() -1);
                    }
                }
            }
        }
        return true;
    }
}
