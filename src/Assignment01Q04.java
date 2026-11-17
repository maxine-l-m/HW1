import java.util.Arrays;


/**
 * ShiftQueue
 * a fixed size queue that allows only shifting
 */
class ShiftQueue {
    private int[] queue;
    int index = 0;

    public ShiftQueue(int size) {
        this.queue = new int[size];
    }

    /**
     * pop the bottom element of the queue and push onto it a new element
     * @param value value to shift onto the queue
     * @return value that we unshifted from the queue
     */
    public int shiftOnto(int value) {
        int currentValue = this.queue[this.index];
        this.queue[this.index] = value;
        this.index = (this.index + 1) % this.queue.length;
        return currentValue;
    }
}

public class Assignment01Q04 {

    private static int clamp(int value, int max) {
        return (value + max) % max;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (array.length == 0)
            return array;
        switch (direction) {
            case 'L':
                move *= -1;
                break;
            case 'R':
                break;
            default:
                return array;
        }

        // used to increment a counter in the direction of "move"
        int increment = Integer.signum(move);
        move = Math.abs(move) % array.length;
        if (move == 0) {
            return array;
        }

        ShiftQueue queue = new ShiftQueue(move);
        int index = 0;
        for (int i = 0; i < move + array.length; i++) {
            array[index] = queue.shiftOnto(array[index]);
            index = clamp(index + increment, array.length);
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 0, 8, 9, 5, 6 }, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] {}, 3, 'R'))); // []
    }
}