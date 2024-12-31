package design_patterns.behavioral.iterator.iterators;

import design_patterns.behavioral.iterator.profile.Profile;
import design_patterns.behavioral.iterator.social_networks.LinkedIn;

import java.util.ArrayList;
import java.util.List;

// Implements iteration over LinkedIn profiles.
public class LinkedInIterator implements ProfileIterator {
    private final LinkedIn linkedIn;
    private final String type;
    private final String email;
    private int currentPosition = 0;
    private final List<String> emails = new ArrayList<>();
    private final List<Profile> profiles = new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    private void lazyLoad() {
        if (emails.isEmpty()) {
            List<String> profiles = linkedIn.requestRelatedContactsFromLinkedInAPI(email, type);
            for (String profile : profiles) {
                this.emails.add(profile);
                this.profiles.add(null);
            }
        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }

        String friendEmail = emails.get(currentPosition);
        Profile friendProfile = profiles.get(currentPosition);
        if (friendProfile == null) {
            friendProfile = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
            profiles.set(currentPosition, friendProfile);
        }
        currentPosition++;
        return friendProfile;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
