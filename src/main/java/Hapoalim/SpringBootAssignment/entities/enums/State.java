package Hapoalim.SpringBootAssignment.entities.enums;

public enum State {

    Israel("Israel"),USA("USA");

    private String stateName;

    private State(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
