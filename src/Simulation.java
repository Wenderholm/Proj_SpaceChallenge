import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("phase1.txt");
        File file2 = new File("phase2.txt");
        ArrayList<Item> items = loadItems(file);
        ArrayList<Item> items2 = loadItems(file2);

        ArrayList<U1> u1p1 = loadU1(items);
        System.out.println(u1p1);
        ArrayList<U1> u1p2 = loadU1(items2);
        System.out.println(u1p2);

        ArrayList<U2> u2p1 = loadU2(items);
        System.out.println(u2p1);
        ArrayList<U2> u2p2 = loadU2(items);
        System.out.println(u2p2);

        long missionCostForU1Type = runSimulationU1(u1p1, u1p2);
        long missionCostForU2Type = runSimulationU2(u2p1, u2p2);

        System.out.println("Mission cost for U1 rockets: " + missionCostForU1Type);
        System.out.println("Mission cost for U2 rockets: " + missionCostForU2Type);
    }

    private static long runSimulationU1(ArrayList<U1> u1p1, ArrayList<U1> u1p2) {
        long missionBudget = 0;

        for (U1 u1 : u1p1) {
            if(u1.launch() && u1.land()){
                missionBudget += u1.getRocketCost();
            }else{

            }
        }
        for (U1 u1 : u1p2) {
            if(u1.launch() && u1.land()){
                missionBudget += u1.getRocketCost();
            }
        }

        return missionBudget;
    }


    private static long runSimulationU2(ArrayList<U2> u2p1, ArrayList<U2> u2p2) {
        long missionBudget = 0;
        for (U2 u2 : u2p1) {
            if(u2.launch() && u2.land()){
                missionBudget += u2.getRocketCost();
            }
        }

        for (U2 u2 : u2p2) {
            if(u2.launch() && u2.land()){
                missionBudget += u2.getRocketCost();
            }
        }

        return missionBudget;
    }
    private static ArrayList<U1> loadU1(ArrayList<Item> items) {


        ArrayList<U1> u1Rockets = new ArrayList<>();
        U1 u1 = new U1(0, 18_000);
        int freePlace = u1.cargoLimit;
        for (Item item : items) {
            if (u1.canCarry(item) && (freePlace >= item.getWeight())) {
                u1.carry(item);
                freePlace -= item.getWeight();
            } else {
                u1Rockets.add(u1);
                u1 = new U1(0, 18_000);
                freePlace = u1.cargoLimit;
                u1.carry(item);
                freePlace -= item.getWeight();
            }
        }
        return u1Rockets;
    }


    private static ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> u2Rockets = new ArrayList<>();
        U2 u2 = new U2(0, 29_000);
        int freePlace = u2.cargoLimit;
        for (Item item : items) {
            if (u2.canCarry(item) && (freePlace >= item.getWeight())) {
                u2.carry(item);
                freePlace -= item.getWeight();
            } else {
                u2Rockets.add(u2);
                u2 = new U2(0, 29_000);
                freePlace = u2.cargoLimit;
                u2.carry(item);
                freePlace -= item.getWeight();
            }
        }
        return u2Rockets;
    }
    private static ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split("=");
            Item newItem = new Item(split[0], Integer.parseInt(split[1]));
            items.add(newItem);
        }
        return items;
    }


}
