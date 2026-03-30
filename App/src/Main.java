import java.util.*;

public class Main {

    // =======================
    // Problem 1 - Transaction
    // =======================
    static class Transaction {
        int id;
        double fee;
        String timestamp;

        Transaction(int id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }
    }

    public static void bubbleSortTransactions(List<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // =======================
    // Problem 2 - Clients
    // =======================
    static class Client {
        String name;
        int riskScore;

        Client(String name, int riskScore) {
            this.name = name;
            this.riskScore = riskScore;
        }
    }

    public static void bubbleSortClients(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // =======================
    // Problem 3 - Merge Sort
    // =======================
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }

    // =======================
    // Problem 5 - Searching
    // =======================
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // =======================
    // MAIN METHOD
    // =======================
    public static void main(String[] args) {

        // Test Problem 1
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(1, 10.5, "10:00"));
        list.add(new Transaction(2, 25.0, "09:30"));
        list.add(new Transaction(3, 5.0, "10:15"));

        bubbleSortTransactions(list);
        for (Transaction t : list) {
            System.out.println(t.id + " " + t.fee);
        }

        // Test Problem 5
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(arr, 5));
    }
}
// PR test changegit add .

