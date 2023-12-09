import java.util.ArrayList;
import java.util.List;

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