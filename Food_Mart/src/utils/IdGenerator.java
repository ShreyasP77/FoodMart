package utils;

public class IdGenerator {
    public static int id;

    public static int getId() {
        id++;
        return id;
    }
}
