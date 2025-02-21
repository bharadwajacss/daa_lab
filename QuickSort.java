import java.util.Arrays;

class QuickSort {
    
    static void swap(int[] arr, int i , int j ){
       
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }
    
    
    static int pivot(int[] arr, int low , int high){
        int p = arr[low];
        int i = low;
        int j = high;

        while(i <= j){
            while(arr[i]<= p ){
                i++;
            } 
            while(arr[j] > p){
                j--;
            }

            if(i < j){
                swap(arr,i,j);
            }
        }
        
        swap(arr, low, j);

        return j;
    }

    static void quickSort(int[] arr, int low, int high){

        if(low >= high) return;

        int pi = pivot(arr,low,high);

        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);

    }


    public static void main(String[] args){
        int[] arr = {2,4,21,19,4,20,6};
        int n = arr.length;
        quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));