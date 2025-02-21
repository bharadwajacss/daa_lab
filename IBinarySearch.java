class IBinarySearch {
    public static boolean search(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-5, -1, 0, 3, 7, 12, 18, 25};
        int key = -50;
        System.out.println(search(arr, key, 0, arr.length - 1));
    }
}