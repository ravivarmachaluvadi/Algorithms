package com.example.techiedelight.Algorithms.DynamicProgramming;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BoxStackingProblem
{
    // Function to generate rotations of all the boxes
    public static List<Box> createAllRotations(List<Box> boxes)
    {
        // stores all rotations of each box
        List<Box> rotations = new ArrayList<>();
 
        // do for each box
        for (Box box: boxes)
        {
            // push the original box: {L x W x H}
            rotations.add(box);
 
            // push the first rotation: {max(L, H) x Math.min(L, H) x W}
            rotations.add(new Box(Math.max(box.length, box.height),
                                Math.min(box.length, box.height),
                                box.width));
 
            // push the second rotation: {max(W, H) x Math.min(W, H) x L}
            rotations.add(new Box(Math.max(box.width, box.height),
                                Math.min(box.width, box.height),
                                box.length));
        }
 
        return rotations;
    }
 
    // Create a stack of boxes which is as tall as possible
    public static int maxHeight(List<Box> boxes)
    {
        // generate rotations of each box
        List<Box> rotations = createAllRotations(boxes);
 
        // sort the boxes in descending order of area(L x W)
        Collections.sort(rotations, (x, y) -> (y.length * y.width - x.length * x.width));
 
        // max_height[i] stores the maximum possible height when i'th box is on the top
        int[] max_height = new int[rotations.size()];
 
        // fill max_height[] in bottom-up manner
        for (int i = 0; i < rotations.size(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                // dimensions of the lower box are each strictly larger than those
                // of the higher box
                if (rotations.get(i).length < rotations.get(j).length &&
                            rotations.get(i).width < rotations.get(j).width)
                {
                    max_height[i] = Math.max(max_height[i], max_height[j]);
                }
            }
 
            max_height[i] += rotations.get(i).height;
        }
 
        // return the maximum value in max_height[]
        return Arrays.stream(max_height).max().getAsInt();
    }
 
    public static void main(String[] args)
    {
        // input boxes
        List<Box> boxes = Arrays .asList(new Box(4, 2, 5),
                                        new Box(3, 1, 6),
                                        new Box(3, 2, 1),
                                        new Box(6, 3, 8));
 
        System.out.println("The maximum height is " + maxHeight(boxes));
    }
}



// Data structure to store a box (L x W x H)
class Box {
    // constraint: width is never more than length
    int length, width, height;

    Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
}