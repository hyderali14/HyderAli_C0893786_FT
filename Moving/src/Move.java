// Hyder Ali//
// C0893786 //

import java.util.ArrayList;
import java.util.List;

class SingleObject {
    private String name;

    public SingleObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Move {
    private List<Box> boxes = new ArrayList<>();

    // Constructor for Move class
    public Move(int numBoxes) {
        for (int i = 1; i <= numBoxes; i++) {
            boxes.add(new Box(0, i));
        }
    }

    // Method to add a box to the move
    public void addBox(Box box) {
        boxes.add(box);
    }

    // Method to print the contents of the move
    public void print() {
        System.out.println("The objects of my move are:");
        for (Box box : boxes) {
            box.printObjects();
        }
    }

    // Method to find the number of the outermost cardboard containing a specific item
    public int find(String itemName) {
        for (Box box : boxes) {
            int result = box.findItem(itemName);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    // Main method for testing the Move class
    public static void main(String[] args) {
        // Create a move with 2 main boxes
        Move move = new Move(2);

        // Create and fill 3 boxes with different items
        Box box1 = new Box(1, 1);
        box1.addItem(new SingleObject("scissors"));

        Box box2 = new Box(1, 2);
        box2.addItem(new SingleObject("book"));

        Box box3 = new Box(2, 3);
        box3.addItem(new SingleObject("compass"));

        Box box4 = new Box(1, 4);
        box4.addItem(new SingleObject("scarf"));
        box3.addItem(box4);

        // Add the three boxes to the first box of move
        Box box5 = new Box(3, 5);
        box5.addItem(box1);
        box5.addItem(box2);
        box5.addItem(box3);

        // Add one box containing 3 objects to move
        Box box6 = new Box(3, 6);
        box6.addItem(new SingleObject("pencils"));
        box6.addItem(new SingleObject("pens"));
        box6.addItem(new SingleObject("rubber"));

        // Add the two most external boxes to the move
        move.addBox(box5);
        move.addBox(box6);

        // Print all the contents of the move
        move.print();

        // Print the number of the outermost cardboard containing the item "scarf"
        System.out.println("The scarf is in the cardboard number " + move.find("scarf"));
    }
}

class Box {
    private int capacity;
    private int number;
    private List<Object> items = new ArrayList<>();

    // Constructor for the Box class
    public Box(int capacity, int number) {
        this.capacity = capacity;
        this.number = number;
    }