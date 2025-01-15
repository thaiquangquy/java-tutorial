package design_patterns.behavioral.mediator.components;

import design_patterns.behavioral.mediator.mediator.Mediator;

// Common component interface
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
