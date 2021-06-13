package exercise2;

public class WarehouseFloor {

    private int sizeX;
    private int sizeY;

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setFloorSize(String line) {
        String[] args = line.split(" ");

        if (args.length != 2) {
            throw new IllegalArgumentException("wrong arguments, please provide 2 positive integer dimensions.");
        }

        sizeX = Integer.parseInt(args[0]);
        if (sizeX <= 0) {
            throw new IllegalArgumentException("wrong 1st argument[" + args[0] + "], please provide positive integer.");
        }

        sizeY = Integer.parseInt(args[1]);
        if (sizeY <= 0) {
            throw new IllegalArgumentException("wrong 2nd argument[" + args[1] + "], please provide positive integer.");
        }
    }


}
