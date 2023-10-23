package org.spaceship;

public class CodeWars {
    /**
     * Calculates the sum of allowed free spaces between boxes in a spaceship.
     * This method was created for the implementation of the code wars task from Sofixit.
     * The method is resistant only to input data containing arrays, each element of which is non-negative.
     *
     * @param spaceship     an array of boxes, which elements are expressed in a unit equal to the height of the box.
     * @return material     sum of allowed free space, expressed in a unit equal to the height of the box.
     */
    public int material(int[] spaceship){
        final int arraySize = spaceship.length;
        if (arraySize <= 2){
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = arraySize - 1;
        int leftMaxBox = spaceship[leftIndex];
        int rightMaxBox = spaceship[rightIndex];

        int material = 0;
        while (leftIndex < rightIndex) {
            if (rightMaxBox > leftMaxBox) {
                material += leftMaxBox - spaceship[leftIndex];
                leftIndex++;
                leftMaxBox = Math.max(leftMaxBox, spaceship[leftIndex]);
            } else {
                material += rightMaxBox - spaceship[rightIndex];
                rightIndex--;
                rightMaxBox = Math.max(rightMaxBox, spaceship[rightIndex]);
            }
        }
        return material;
    }
}
