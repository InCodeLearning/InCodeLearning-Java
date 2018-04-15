package github.incodelearning.concurrency.jcip;

/**
 * Implicitly allowing the this reference to escape. When the inner EventListener instance is published, so is the
 * enclosing ThisEscape instance. An object is in a consistent, predictable state only after its constructor returns.
 * Publishing an object from within its constructor can publish an incompletely constructed object.
 * <p>
 * A common mistake that can let the this reference escape is to start a thread from a constructor. When an object
 * starts a thread from its constructor, it almost always shares its this reference with the new thread, either
 * explicitly (by passing it to the constructor) or implicitly (because the Thread or Runnable is an inner class of
 * the owning object). There is nothing wrong in creating a thread in a constructor, but is is best not to start
 * the thread immediately.
 * <p>
 * Calling an overridable instance method from the constructor can also allow the this reference to escape.
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
