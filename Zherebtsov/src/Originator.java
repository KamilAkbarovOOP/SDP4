public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("State set: " + state);
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("State set: " + state);
    }
}
