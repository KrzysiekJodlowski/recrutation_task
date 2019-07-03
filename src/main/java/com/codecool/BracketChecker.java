package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class BracketChecker {

    private String brackets;
    private final int ZERO_INDEX = 0;
    private final int INDEX_ONE = 1;

    public BracketChecker(String brackets) {
        this.brackets = brackets;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        if (this.brackets == null || this.brackets.length() == this.ZERO_INDEX) {
            return false;
        } else {
            return checkMatchingAndNesting();
        }
    }

    private boolean checkMatchingAndNesting() {
        List<Character> checkedBrackets = new ArrayList<>();
        int bracketsLength = this.brackets.length();

        for (int index = this.ZERO_INDEX; index < bracketsLength; index++) {
            char bracket = this.brackets.toCharArray()[index];

            if (isOpeningBracket(bracket)) {
                if (index != bracketsLength - this.INDEX_ONE) {
                    checkedBrackets.add(bracket);
                } else {
                    return false;
                }
            } else {
                Character lastChar = checkedBrackets.get(checkedBrackets.size() - this.INDEX_ONE);
                if (isBracketNotClosed(bracket, lastChar)) {
                    return false;
                } else {
                    checkedBrackets.remove(checkedBrackets.size() - this.INDEX_ONE);
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
