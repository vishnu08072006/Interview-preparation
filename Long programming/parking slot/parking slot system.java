import java.util.Scanner;

class Slot {
    static final int TOTAL_SLOTS = 20;
    static int occupiedSlots = 0;
}

class Vehicle extends Slot {
    String vehicleNumber;
    String driverName;

    Vehicle(String vNum, String dName) {
        vehicleNumber = vNum;
        driverName = dName;
    }
}

public class Parking {
    static Vehicle[] parking = new Vehicle[20];
    static Scanner sc = new Scanner(System.in);

    static void parkVehicle() {
        if (Slot.occupiedSlots == Slot.TOTAL_SLOTS) {
            System.out.println("Parking Full!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String vNum = sc.nextLine();

        System.out.print("Enter Driver Name: ");
        String dName = sc.nextLine();

        for (int i = 0; i < 20; i++) {
            if (parking[i] == null) {
                parking[i] = new Vehicle(vNum, dName);
                Slot.occupiedSlots++;
                System.out.println("Parked at slot: " + (i + 1));
                break;
            }
        }

        System.out.println("Free slots: " + (Slot.TOTAL_SLOTS - Slot.occupiedSlots));
    }

    static void removeVehicle() {
        System.out.print("Enter Slot Number: ");
        int slot = sc.nextInt();
        sc.nextLine(); 

        if (slot < 1 || slot > 20) {
            System.out.println("Invalid slot!");
            return;
        }

        if (parking[slot - 1] != null) {
            System.out.println("Removed Vehicle: " + parking[slot - 1].vehicleNumber);
            parking[slot - 1] = null;
            Slot.occupiedSlots--;
        } else {
            System.out.println("Slot already empty!");
        }

        System.out.println("Free slots: " + (Slot.TOTAL_SLOTS - Slot.occupiedSlots));
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Free Slots");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    parkVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    System.out.println("Free slots: " + (Slot.TOTAL_SLOTS - Slot.occupiedSlots));
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}