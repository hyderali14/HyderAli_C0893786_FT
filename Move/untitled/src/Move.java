// Hyder Ali //
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

