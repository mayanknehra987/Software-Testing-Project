
public class FindMaximumsumSubarray {


	public static void main(String[] args) {
        int[] arr = {2, -1, 3, -4, 5, -2};

        int maxSum = arr[0];     // Pehla number se shuru
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Agar current sum negative ho gaya to naya start karte hain
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // Ab tak ka sabse bada sum yaad rakhte hain
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Maximum subarray sum is: " + maxSum);
    }
	}
