package MergeSort;

public class mergeSort {
    public static void main(String args[]){

        int[] intArray = {20, 35, -15, 7, 55, 1 -22};

        mergeSortFunc(intArray, 0,intArray.length);

        for(int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }

    }

    public static void mergeSortFunc(int[] input, int start, int end){
        //if the array - input has just one element then return else do logical partition and sort
        if(end - start < 2){
            return;
        }

        int mid = (start+end)/2;
        //Recursively call Left logical partitioned array to sort - end index is always 1 greater than last valid index
        //Hence sending mid nd not (mid-1)
        mergeSortFunc(input, start, mid);
        //Recursively call Right logical partitioned array to sort
        mergeSortFunc(input, mid, end);
        //After both Right and Left are sorted they need to e merged as below
        merge(input, start, mid, end);

    }

    public static void merge(int[] input, int start, int mid, int end){
        //If the last element in Left partition is < first element in Right then that means all elements are sorted and hence we can
        //copy directy left array first into temp array and then right array into temp array and then copy temp array into original
        //array
        //= sign in comparision means this is in stable sorting and maintains the order of elements in sorted array
        if(input[mid-1] <= input[mid]){
                return;
        }
        //If the last element in Left partition is isNOT LESS THAN the first element in Right then that means some elemenst in right
        //smaller than those in Left array, hence it needs aorting within
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        //when i = mid we have finished traversing left array and we would want o drop out of while loop for merging into tem array
        //when j = end we have finished traversing right array and we would want o drop out of while loop for merging into tem array
        while(i<mid && j< end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        //For elements remainign in right array we dont have to do anything, but if we have elements left over in Left array we have
        //to copy those elements into temp array
        //Consider eg -> {32, 33} and {34, 36} - after executing while loop on line # 48, we have totally copied left array and now
        // only 36 remains which need to be copied from right array in temp array as all of the remaining elements are greater
        // than all elements copied so far - actually No we dont need to copy these ae there position remains same as in
        //original array
        //Consider eg -> {32, 36} and {33, 34} - after executing while loop on line # 48, we have totally copied right array and now
        // only 36 from left array remains which need to be copied from left array in to temp array and we need to handle them as
        //thier positions might change as they might be less than those in original array - Actually no we copy them in input array
        // directly instead of first copying into temp and then to original
        //Below is left array copy to input array
        System.arraycopy(input, i, input, start+tempIndex, mid -i);
        //Explnation of aray copy above - copying source array, copy at position, dest array, desti posi = jump over all elements
        // that have been copied into temp array and start adding at next position in original array, length that we need to
        // copy from left partition- if left array was copied then mid - 1 = 0 which means we need not copy anything from
        // left partition
        System.arraycopy(temp, 0, input, start, tempIndex);
        //Explnation of aray copy above - copy all sorted elemenst from temp array into input array

    }

}
