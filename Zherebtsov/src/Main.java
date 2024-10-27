public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State #4");

        System.out.println("Getting previous state...");
        originator.getStateFromMemento(caretaker.getMemento(1));

        System.out.println("Getting first saved state...");
        originator.getStateFromMemento(caretaker.getMemento(0));
    }
}
