/*This is the heap class, that demonstrates the heap Data Structure.  The purpose of the heap is to represent
* a heap of values in descending order in a tree-like structure.  Though visually a heap is often thought of as
* a binary tree, it is actually stored as an array.  The member variables included in the Heap class are:
*
* . Size: The current size of the heap that represents how many items are actually present in the heap,
* . maxSize: The maximum size the heap can be, which is determined by the number passed in by the constructor,
* . and items: The array that contains the actual values that are inserted and present on the heap
*
* The methods included in this implementation of the heap are:
*
* . a Constructor: takes in an int value that is used to instantiate the underlying array, as well as set the maxSize
*                  and the size to 0.
* . isEmpty(): a method that lets us determine if there are 0 or more >= 1 elements in the heap
* . insert(): Allows you to insert a value v into the heap
* . delete(): Allows you to delete the root node from the heap, and takes NO parameter
* . min(): Takes two values and returns the value of the smaller
* . getSize(): Returns the current amount of elements in the heap
* . getMaxSize(): Returns the maximum amount of room in the heap*/
public class Heap {
    private int size;
    private int maxSize;
    public int[] items;

    /*Constructor, that in this case takes an int s as a parameter, sets the maxSize,
    * current size, and instantiates the Array to the size passed in.*/
    Heap(int s) {
        this.size = 0;
        this.maxSize = s;
        items = new int[s];
    }

    /*Returns a bool depending on the value of size.  Used to check the status of the heap in userProgram*/
    public boolean isEmpty() {
        return size == 0;
    }

    /*Takes in a value v as a parameter, and inserts it into the correct place in the heap*/
    public void insert(int v) {
        items[size] = v; //adds the value v to the end of the array which indicates the actual insertion, though we may move things around
        int place = size; //placeholder for the index of the new item, which will be used to compare it to parent
        int parent = (place - 1)/2; //placeholder for the index of the parent of the new item
        while ((place > 0) && (items[place] > items[parent])) { //we will loop while the new item isn't the root, and the child is greater than the parent (meaning we will perform swaps)
            int temp = items[parent]; //following lines are used to swap the values, which will happen if the child is smaller than the parent.  This will happen up to root level
            items[parent] = items[place];
            items[place] = temp;
            place = parent; //and we will replace the placeholders with the new values
            parent = (place - 1) / 2;
        }
        size++; //and since we added a new value, we increment currentSize to be able to keep track
    }


    /*Delete takes no parameter, and returns the value of the root which will be deleted.  We use this to delete the root
    * and then replace root with the smallest child.  We then will down-trickle the smallest child to it's corresponding
    * spot.*/
    public int delete() {
        try {
            int temp = items[0]; //we copy the value of the item we're deleting into a temporary variable to be later returned
            items[0] = items[size - 1]; //and we replace this value with the smallest child
            int root = 0; //the root will always be items[0] so we use this variable for clarity
            int left = 2 * root + 1; //the left child's index is calculated by 2(root)+1
            int right = left + 1; //and we add one to this to get the right child
            while ((root < size / 2) && ((items[root] < max(items[left], items[right])))) { //while the value at root is less than the smallest child, we will want to downtrickle
                int x = items[root]; //and we will use this for both cases for a swap, so we put it in a variable
                if (items[left] > items[right]) { //depending on which child is smaller, we'll swap the root with the greater of the two
                    items[root] = items[left];
                    items[left] = x;
                    root = 2 * root + 1; //and increment the root so we can keep trickling down to verify
                    left = 2 * root + 1;
                    right = left + 1;
                } else {
                    items[root] = items[right]; //case is reached if the right child is larger than the left child
                    items[right] = x;
                    root = 2 * root + 2;
                    left = 2 * root + 1;
                    right = left + 1;
                }
            }
            size--;
            return temp;
        } catch (Exception ex) {
            String s = "";
        }
        return -1;
    }




    /*This is used in the delete function, and simply returns the lesser of two values*/
    private int max(int a, int b) {
        return a > b ? a : b ;
    }

    /*Returns current size*/
    public int getSize() {
        return size;
    }

    /*Returns the max size*/
    public int getMaxSize() {
        return maxSize;
    }
}
