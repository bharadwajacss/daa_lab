import java.util.Arrays;

class MergeSort{


    static int[] merge(int[] arr1, int[] arr2, int size1, int size2){
        int i = 0 ; 
        int j = 0 ;
        int k = 0;
        int[] arr = new int[size1 + size2];
        while( i < size1 && j < size2){
            if(arr1[i]<=arr2[j]){
                arr[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr[k] = arr2[j];
                j++;
                k++;
            }
           
        }
     
        
        while(i < size1){
            arr[k] = arr1[i];
            k++;
            i++;
        }
         
        while(j < size2){

            arr[k] = arr2[j];
            k++;
            j++;
        }
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        // System.out.println(Arrays.toString(arr));

        return arr;
    }



    static int[] mergeSort(int[] arr,int low, int high){
        if(low >= high){
            int[] single = {arr[0]};
            return single;
        }
        int mid = (low + high) / 2;
        int[] left = new int[mid+1];
        int[] right = new int[high-mid];
        for(int i = 0 ; i <= mid ; i++){
            left[i] = arr[i];
            
        }
        
        for(int i = 0; i < high - mid; i++){
            right[i] = arr[mid + i + 1];
        }
        

        

        left = mergeSort(left, 0, mid);
        right = mergeSort(right, 0, high-mid-1);

        return merge(left, right, mid + 1, high - mid);

    }




    public static void main(String[] args){
        int[] arr = {2,4,21,19,4,20,6};
        int n = arr.length;
        arr = mergeSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }


}