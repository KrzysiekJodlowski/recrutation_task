package com.codecool;

import org.junit.Assert;
import org.junit.Test;

public class BracketCheckerTest {

    private BracketChecker bracketChecker;

    @Test
    public void checkIfNullInputReturnsFalse() {
        this.bracketChecker = new BracketChecker(null);

        Assert.assertFalse(this.bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Test
    public void checkIfEmptyInpuitReturnsFalse() {
        this.bracketChecker = new BracketChecker("");

        Assert.assertFalse(this.bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Test
    public void checkIfCorrectShortInputReturnsTrue() {
        this.bracketChecker = new BracketChecker("[]");

        Assert.assertTrue(this.bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Test
    public void checkIfIncorrectShortInputReturnsFalse() {
        this.bracketChecker = new BracketChecker("[{");

        Assert.assertFalse(this.bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Test
    public void checkIfIncorrectLongInputReturnsTrue() {
        this.bracketChecker = new BracketChecker("({)[[[))})");

        Assert.assertFalse(this.bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Test
    public void checkIfCorrectLongInputReturnsTrue() {
        this.bracketChecker = new BracketChecker("([]{[]}([]))");

        Assert.assertTrue(this.bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }
}
