import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* Daniel Frost
 * CSC501
 * Data Structures and Computer Systems
 * April, 2017
 *
 * HEAP DATA STRUCTURE IMPLEMENTATION
 *
 * This assignment was developed in order to demonstrate the use of heaps and the methods that are usually
 * associated with heaps.  This will be accomplished by using two text files, input1 and input3 (named so
 * because of a previous project).  These files will be read in the order they appear in the text file, and added
 * to an array of a size equal to the amount of integers that will be used as temporary storage.
 *
 * The input from the text file will then be added to a heap of the same size, and the implementation of the heap
 * will determine the structure of the heap.  Then, the items will be deleted in order, and printed.*/
public class UserProgram {

    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\Daniel\\IdeaProjects\\FrostProgram5.2\\src\\input1.txt"; //change file here to change input
            FileInputStream in = new FileInputStream(path);
            BufferedReader sizeReader = new BufferedReader(new InputStreamReader(in));
            String x; int i = 0; //various variables used for reading in values
            int amount = 0;
            while (sizeReader.readLine() != null) { //This while loop is used to count how many items are in the
                amount++;                             //file, and will later be used to instantiate the array
            }

            in = new FileInputStream(path); //we reset the FileInputStream and bufferedReader to go back through and actually read the values in
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            int[] tempArray = new int[amount]; //this array is used for temporary storage and eventual transfer to the heap
            while ((x = reader.readLine()) != null) { //while there is input to read, we will store it in x
                tempArray[i] = Integer.parseInt(x); //and parse it into an Integer, and add it to the temporary Array
                i++;    //and increment i so that we always add the new value to the end of the array (based on size)
            }

            Heap heap = new Heap(100); //we use the heap constructor that takes a number as input for the size instantiation
            for (int number : tempArray) { //this forreach loop loops through all of the numbers in tempArray and adds them
                heap.insert(number);        //to the heap
                //System.out.println(number);
            }
            while (!heap.isEmpty()) {   //while there are still things left in the heap, we call delete and print out
                System.out.println(heap.delete());      //the value that was deleted.
            }
        } catch (Exception ex) {
            String s = "";
        }

    }
}
