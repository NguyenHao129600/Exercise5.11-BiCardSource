package exercise11;

/**
 * Minimal abstraction used by BiCardSource.
 */
public interface CardSource {
    Card draw();

    boolean isEmpty();
}
