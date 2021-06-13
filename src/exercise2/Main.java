package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please provide dimensions");
        WarehouseFloor floor = new WarehouseFloor();
        floor.setFloorSize(scanner.nextLine());

        List<VacuumCleaner> cleaners = new ArrayList<>();

        while (true) {
            System.out.println("please provide vacuum cleaner initial coordinates and direction.Or empty line for end");
            String startPointLine = scanner.nextLine();
            if ("".equals(startPointLine)) {
                break;
            }

            VacuumCleaner vc = new VacuumCleaner(startPointLine);

            System.out.println("please provide vacuum cleaner commands");
            String commandsLine = scanner.nextLine();
            vc.doCommands(commandsLine);

            cleaners.add(vc);
        }

        for (VacuumCleaner vc : cleaners) {
            System.out.println(vc.getOutput());
        }
    }
}
