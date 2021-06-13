package exercise2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class VacuumCleanerTest {

    @Test
    public void testStartingPointInputs() {
        VacuumCleaner vc1 = new VacuumCleaner("1 1 N");
        assertEquals("1 1 N", vc1.getOutput());
        vc1 = new VacuumCleaner("5 2 W");
        assertEquals("5 2 W", vc1.getOutput());
        vc1 = new VacuumCleaner("W 5 2");
        assertEquals("5 2 W", vc1.getOutput());

        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner(""));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1 2"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1 2 3 4"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1 2 WWW"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1 W 2"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1 2 3"));

        assertThrows(NumberFormatException.class, () -> new VacuumCleaner("W 2 W"));
        assertThrows(NumberFormatException.class, () -> new VacuumCleaner("W W W"));
        assertThrows(NumberFormatException.class, () -> new VacuumCleaner("a 2 W"));
        assertThrows(NumberFormatException.class, () -> new VacuumCleaner("2 a W"));

        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("-1 2 W"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("1 -2 W"));
        assertThrows(IllegalArgumentException.class, () -> new VacuumCleaner("-1 -2 W"));
    }

    @Test
    public void testDoCommandLeft() {
        VacuumCleaner vc = new VacuumCleaner("0 0 N");
        vc.doCommandLeft();
        assertEquals("0 0 W", vc.getOutput());
        vc.doCommandLeft();
        assertEquals("0 0 S", vc.getOutput());
        vc.doCommandLeft();
        assertEquals("0 0 E", vc.getOutput());
        vc.doCommandLeft();
        assertEquals("0 0 N", vc.getOutput());
    }

    @Test
    public void testDoCommandRight() {
        VacuumCleaner vc = new VacuumCleaner("0 0 N");
        vc.doCommandRight();
        assertEquals("0 0 E", vc.getOutput());
        vc.doCommandRight();
        assertEquals("0 0 S", vc.getOutput());
        vc.doCommandRight();
        assertEquals("0 0 W", vc.getOutput());
        vc.doCommandRight();
        assertEquals("0 0 N", vc.getOutput());
    }

    @Test
    public void testDoCommandForward() {
        VacuumCleaner vc = new VacuumCleaner("1 1 N");
        vc.doCommandForward();
        assertEquals("1 2 N", vc.getOutput());

        vc = new VacuumCleaner("1 1 E");
        vc.doCommandForward();
        assertEquals("2 1 E", vc.getOutput());

        vc = new VacuumCleaner("1 1 S");
        vc.doCommandForward();
        assertEquals("1 0 S", vc.getOutput());

        vc = new VacuumCleaner("1 1 W");
        vc.doCommandForward();
        assertEquals("0 1 W", vc.getOutput());
    }

    @Test
    public void testDoOneCommand(){
        VacuumCleaner vc = new VacuumCleaner("1 1 N");
        vc.doOneCommand("L");
        assertEquals("1 1 W", vc.getOutput());
        vc.doOneCommand("F");
        assertEquals("0 1 W", vc.getOutput());
        vc.doOneCommand("R");
        assertEquals("0 1 N", vc.getOutput());
        vc.doOneCommand("R");
        assertEquals("0 1 E", vc.getOutput());

        assertThrows(IllegalArgumentException.class, () ->  vc.doOneCommand(""));
        assertThrows(IllegalArgumentException.class, () ->  vc.doOneCommand("X"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doOneCommand("1"));

    }

    @Test
    public void testDoCommand(){
        VacuumCleaner vc = new VacuumCleaner("1 1 N");
        vc.doCommand("0L");
        assertEquals("1 1 N", vc.getOutput());
        vc.doCommand("L");
        assertEquals("1 1 W", vc.getOutput());
        vc.doCommand("7L");
        assertEquals("1 1 N", vc.getOutput());
        vc.doCommand("14F");
        assertEquals("1 15 N", vc.getOutput());

        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("0"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("1"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("1"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("-L"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("21L"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("-1L"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("X"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("XL"));
        assertThrows(IllegalArgumentException.class, () ->  vc.doCommand("5XL"));

    }

    @Test
    public void testDoCommands(){
        VacuumCleaner vc = new VacuumCleaner("1 1 N");
        vc.doCommands("2F");
        assertEquals("1 3 N", vc.getOutput());

        vc = new VacuumCleaner("N 8 12");
        vc.doCommands("4FRFR4FLFL4F");
        assertEquals("10 16 N", vc.getOutput());

        vc = new VacuumCleaner("30 24 S");
        vc.doCommands("4FR4FR4FR4FR");
        assertEquals("30 24 S", vc.getOutput());
    }


}
