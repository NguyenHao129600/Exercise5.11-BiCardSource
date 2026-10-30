package exercise11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BiCardSourceTest {

    @Test
    void draw_source1NotEmpty_drawsFromSource1() {
        Card card1 = new Card("SOURCE-1-CARD");
        Card card2 = new Card("SOURCE-2-CARD");
        StubCardSource source1 = new StubCardSource(false, card1);
        StubCardSource source2 = new StubCardSource(false, card2);
        BiCardSource uut = new BiCardSource(source1, source2);

        Card result = uut.draw();

        assertSame(card1, result);
        assertEquals(1, source1.getDrawCallCount());
        assertEquals(0, source2.getDrawCallCount());
    }

    @Test
    void draw_source1Empty_drawsFromSource2() {
        Card card1 = new Card("SOURCE-1-CARD");
        Card card2 = new Card("SOURCE-2-CARD");
        StubCardSource source1 = new StubCardSource(true, card1);
        StubCardSource source2 = new StubCardSource(false, card2);
        BiCardSource uut = new BiCardSource(source1, source2);

        Card result = uut.draw();

        assertSame(card2, result);
        assertEquals(0, source1.getDrawCallCount());
        assertEquals(1, source2.getDrawCallCount());
    }

    @Test
    void isEmpty_source1NotEmpty_returnsFalseAndShortCircuits() {
        StubCardSource source1 = new StubCardSource(false, null);
        StubCardSource source2 = new StubCardSource(true, null);
        BiCardSource uut = new BiCardSource(source1, source2);

        boolean result = uut.isEmpty();

        assertFalse(result);
        assertEquals(1, source1.getIsEmptyCallCount());
        assertEquals(0, source2.getIsEmptyCallCount(),
                "source2.isEmpty() must not be evaluated because && short-circuits");
    }

    @Test
    void isEmpty_source1EmptyAndSource2NotEmpty_returnsFalse() {
        StubCardSource source1 = new StubCardSource(true, null);
        StubCardSource source2 = new StubCardSource(false, null);
        BiCardSource uut = new BiCardSource(source1, source2);

        boolean result = uut.isEmpty();

        assertFalse(result);
        assertEquals(1, source1.getIsEmptyCallCount());
        assertEquals(1, source2.getIsEmptyCallCount());
    }

    @Test
    void isEmpty_bothSourcesEmpty_returnsTrue() {
        StubCardSource source1 = new StubCardSource(true, null);
        StubCardSource source2 = new StubCardSource(true, null);
        BiCardSource uut = new BiCardSource(source1, source2);

        boolean result = uut.isEmpty();

        assertTrue(result);
        assertEquals(1, source1.getIsEmptyCallCount());
        assertEquals(1, source2.getIsEmptyCallCount());
    }
}
