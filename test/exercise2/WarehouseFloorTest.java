package exercise2;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class WarehouseFloorTest {

    @Test
    public void testWarehouseFloorInputs() {
        WarehouseFloor floor = new WarehouseFloor();
        floor.setFloorSize("2 2");

        WarehouseFloor floor2 = new WarehouseFloor();
        assertThrows(IllegalArgumentException.class, () -> floor2.setFloorSize(""));
        assertThrows(IllegalArgumentException.class, () -> floor2.setFloorSize("a"));
        assertThrows(IllegalArgumentException.class, () -> floor2.setFloorSize("1"));
        assertThrows(IllegalArgumentException.class, () -> floor2.setFloorSize("-1"));
        assertThrows(IllegalArgumentException.class, () -> floor2.setFloorSize("-1 -1"));
        assertThrows(IllegalArgumentException.class, () -> floor2.setFloorSize("1 1 1"));
        assertThrows(NumberFormatException.class, () -> floor2.setFloorSize("a 1"));
        assertThrows(NumberFormatException.class, () -> floor2.setFloorSize("1 a"));
    }
}
