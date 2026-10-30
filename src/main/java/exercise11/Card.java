package exercise11;

import java.util.Objects;

/**
 * A small card value object. Exercise 11 only needs card identity for testing.
 */
public final class Card {
    private final String label;

    public Card(String label) {
        this.label = Objects.requireNonNull(label);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
