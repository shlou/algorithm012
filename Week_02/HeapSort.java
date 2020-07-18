// Heap sort is a comparison based sorting technique based on Binary Heap data structure.
// A Binary Heap is a Complete Binary Tree (binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible)
public class HeapSort implements Testable {

    public void run () {
        int[] arr = {4, 10, 3, 5, 1};
        Solution runner = new Solution();
        runner.sort(arr);
        for (var a : arr)
            System.out.println(a);
    }
    
    class Solution {
        public void sort (int arr[]) {
            int n = arr.length;

            // build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--) 
                heapify(arr, n, i);

            // one by one extract an element from heap 
            for (int i = n - 1; i > 0; i--) {
                // move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // call max heapify on the reduced heap
                heapify(arr, i, 0); 
            }
        }

        // tp heapify a subtree rooted with node i which is 
        // an index in arr[], n is size of heap.
        private void heapify (int[] arr, int n, int i) {
            int largest = i;  // initialize largest as root
            int l = 2 * i + 1;  // left 
            int r = 2 * i + 2;  // right

            // if left child is larger than root
            if (l < n && arr[l] > arr[largest]) 
                largest = l;
            
            // if right child is larger than largest so far
            if (r < n && arr[r] > arr[largest])
                largest = r;

            // if largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // recursively heapify the affected sub-tree
                heapify(arr, n, largest);
            }
        } 
    }

}