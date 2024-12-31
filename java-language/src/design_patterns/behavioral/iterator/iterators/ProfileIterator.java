package design_patterns.behavioral.iterator.iterators;

import design_patterns.behavioral.iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
