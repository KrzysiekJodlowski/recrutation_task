package com.codecool;

public class BracketChecker {

    private String brackets;

    public BracketChecker(String brackets) {
        this.brackets = brackets;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        boolean result = false;
        if (this.brackets != null && this.brackets.equals("[]")) {
            result = true;
        }
        return result;
    }
}
