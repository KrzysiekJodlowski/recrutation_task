package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class BracketChecker {

    private String brackets;

    public BracketChecker(String brackets) {
        this.brackets = brackets;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        int bracketsLength;

        int ZERO_INDEX = 0;
        int INDEX_ONE = 1;

        if (this.brackets == null || this.brackets.length() == ZERO_INDEX) {
            return false;
        } else {
            List<Character> checkedBrackets = new ArrayList<>();
            bracketsLength = brackets.length();

            for (int index = ZERO_INDEX; index < brackets.toCharArray().length; index++) {
                char bracket = brackets.toCharArray()[index];

                if (isOpeningBracket(bracket)) {
                    if (index != bracketsLength - INDEX_ONE) {
                        checkedBrackets.add(bracket);
                    } else {
                        return false;
                    }
                } else {
                    Character lastChar = checkedBrackets.get(checkedBrackets.size() - INDEX_ONE);
                    if (isBracketNotClosed(bracket, lastChar)) {
                        return false;
                    } else {
                        checkedBrackets.remove(checkedBrackets.size() - INDEX_ONE);
                    }
                }
            }
        }
        return true;
    }

    private boolean isOpeningBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private boolean isBracketNotClosed(char bracket, Character lastChar) {
        return (bracket == ')' &&  !lastChar.equals('(')) ||
                (bracket == '}' &&  !lastChar.equals('{')) ||
                (bracket == ']' &&  !lastChar.equals('['));
    }
}
