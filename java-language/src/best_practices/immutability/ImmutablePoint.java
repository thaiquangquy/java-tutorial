package best_practices.immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable value object: all fields are final, set only in the constructor,
 * no setters, and any mutable input is defensively copied so external code
 * can't reach in and change internal state after construction.
 */
public final class ImmutablePoint {
    private final int x;
    private final int y;
    private final List<String> tags;

    public ImmutablePoint(int x, int y, List<String> tags) {
        this.x = x;
        this.y = y;
        // Defensive copy: without this, the caller's list reference could be
        // mutated later and silently change this "immutable" object's state.
        this.tags = Collections.unmodifiableList(new ArrayList<>(tags));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<String> getTags() {
        return tags;
    }

    /** "Mutating" an immutable object returns a new instance instead. */
    public ImmutablePoint withX(int newX) {
        return new ImmutablePoint(newX, this.y, this.tags);
    }

    @Override
    public String toString() {
        return "ImmutablePoint{x=" + x + ", y=" + y + ", tags=" + tags + "}";
    }
}
