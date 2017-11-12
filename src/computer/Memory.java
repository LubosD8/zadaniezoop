package computer;

class Memory {
   private int capacity = 10;
    private int[][] place = new int[capacity][2];

    int[][] getPlace() {
        return place;
    }

    int getCapacity() {
        return capacity;
    }
}
