package exercise2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VacuumCleaner {

    private int positionX;
    private int positionY;
    private Direction direction;

    public VacuumCleaner(int positionX, int positionY, Direction direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public VacuumCleaner(String line) {
        initFromLine(line);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void initFromLine(String line) {
        String[] args = line.split(" ");

        if (args.length != 3) {
            throw new IllegalArgumentException("wrong arguments, please provide 2 positive integers and direction.");
        }

        Direction dir = Direction.findByName(args[0]);
        if (dir != null) {
            this.direction = dir;

            positionX = Integer.parseInt(args[1]);
            if (positionX < 0) {
                throw new IllegalArgumentException(
                        "wrong 2nd argument[" + args[1] + "], please provide positive integer.");
            }
            positionY = Integer.parseInt(args[2]);
            if (positionY < 0) {
                throw new IllegalArgumentException(
                        "wrong 3rd argument[" + args[2] + "], please provide positive integer.");
            }
            return;
        }

        dir = Direction.findByName(args[2]);
        if (dir != null) {
            this.direction = dir;

            positionX = Integer.parseInt(args[0]);
            if (positionX < 0) {
                throw new IllegalArgumentException(
                        "wrong 1st argument[" + args[0] + "], please provide positive integer.");
            }
            positionY = Integer.parseInt(args[1]);
            if (positionY < 0) {
                throw new IllegalArgumentException(
                        "wrong 2nd argument[" + args[1] + "], please provide positive integer.");
            }
            return;
        }

        throw new IllegalArgumentException("wrong arguments, direction should be either 1st or 3rd argument");
    }

    public void doCommandLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case E:
                direction = Direction.N;
                break;
            case S:
                direction = Direction.E;
                break;
            case W:
                direction = Direction.S;
                break;
        }
    }

    public void doCommandRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.S;
                break;
            case S:
                direction = Direction.W;
                break;
            case W:
                direction = Direction.N;
                break;
        }
    }

    public void doCommandForward() {
        //todo validate floor size and check if position is empty
        switch (direction) {
            case N:
                positionY++;
                break;
            case E:
                positionX++;
                break;
            case S:
                positionY--;
                break;
            case W:
                positionX--;
                break;
        }
    }

    public void doOneCommand(String command) {
        switch (command) {
            case "L":
                doCommandLeft();
                break;
            case "R":
                doCommandRight();
                break;
            case "F":
                doCommandForward();
                break;

            default:
                throw new IllegalArgumentException("wrong command: " + command);
        }
    }

    public void doCommand(String command) {

        if (command.length() == 1) {
            doOneCommand(command);

        } else if (command.length() == 2) {
            int count = Integer.parseInt(command.substring(0, 1));
            String cmd = command.substring(1, 2);
            for (int i = 0; i < count; i++) {
                doOneCommand(cmd);
            }

        } else if (command.length() == 3) {
            int count = Integer.parseInt(command.substring(0, 2));
            String cmd = command.substring(2, 3);
            if (count < 0) {
                throw new IllegalArgumentException("must be positive count: " + count);
            } else if (count > 20) {
                throw new IllegalArgumentException("too many command repetitions: " + count);
            }
            for (int i = 0; i < count; i++) {
                doOneCommand(cmd);
            }

        } else {
            throw new IllegalArgumentException("unknown command: " + command);
        }
    }

    public void doCommands(String command) {
        Pattern pattern = Pattern.compile("(\\d{0,2})([LRF])");
        Matcher matcher = pattern.matcher(command);

        while (matcher.find()) {
            String cmd = matcher.group(0);
            doCommand(cmd);
        }
    }

    public String getOutput() {
        return positionX + " " + positionY + " " + direction;
    }
}
