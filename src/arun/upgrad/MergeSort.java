package arun.upgrad;

class MergeSort {
    public static void main(String args[]) {
        int arr[] = {9, 3, 1, 5, 13, 12};
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);
        ob.display(arr);
    }

    void display(int arr[])                 //display the array
    {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    void mergeSort(int arr[], int left, int right)       //helper function that creates the sub cases for sorting
    {
        int middle;
        if (left < right) {                             //sort only if the left index is lesser than the right index (meaning that sorting is done)
            middle = (left + right) / 2;

            mergeSort(arr, left, middle);                    //left subarray
            mergeSort(arr, middle + 1, right);               //right subarray

            merge(arr, left, middle, right);
        }
    }

    void merge(int arr[], int left, int middle, int right) {
        int low = middle - left + 1;                    //size of the left subarray
        int high = right - middle;                      //size of the right subarray

        int L[] = new int[low];                             //create the left and right subarray
        int R[] = new int[high];

        int i = 0, j = 0;

        for (i = 0; i < low; i++)                               //copy elements into left subarray
        {
            L[i] = arr[left + i];
        }
        for (j = 0; j < high; j++)                              //copy elements into right subarray
        {
            R[j] = arr[middle + 1 + j];
        }


        int k = left;                                           //get starting index for sort
        i = 0;                                             //reset loop variables before performing merge
        j = 0;

        while (i < low && j < high)                     //merge the left and right subarrays
        {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < low)                             //merge the remaining elements from the left subarray
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < high)                           //merge the remaining elements from right subarray
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

class MyMergeSort {
    public static void main(String[] args) {
        int arr[] = {9, 3, 1, 5, 13, 12};
        System.out.println("Given array");
        display(arr);

        System.out.println();

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array");
        display(arr);
    }

    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void mergeSort(int arr[], int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int arr[], int left, int mid, int right) {
        int lsaSize = mid - left + 1;
        int rsaSize = right - mid;

        int LSA[] = new int[lsaSize];
        int RSA[] = new int[rsaSize];

        int i, j;
        for (i = 0; i < lsaSize; i++) {
            LSA[i] = arr[left + i];
        }

        for (j = 0; j < rsaSize; j++) {
            RSA[j] = arr[mid + 1 + j];
        }

        int k = left;
        i = 0;
        j = 0;
        while (i < lsaSize && j < rsaSize) {
            if (LSA[i] <= RSA[j]) {
                arr[k] = LSA[i];
                i++;
            } else {
                arr[k] = RSA[j];
                j++;
            }
            k++;
        }

        while (i < lsaSize) {
            arr[k] = LSA[i];
            i++;
            k++;
        }

        while (j < rsaSize) {
            arr[k] = RSA[j];
            j++;
            k++;
        }
    }
}
