package exercise2;

public enum Direction {
    N,
    S,
    W,
    E;

    static Direction findByName(String name) {
        try {
            return valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
