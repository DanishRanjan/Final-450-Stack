import java.io.*;
import java.util.*;

public class mergerOverlappingUsingStack {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int j = 0; j < n; j++) {
			String line = br.readLine();
			arr[j][0] = Integer.parseInt(line.split(" ")[0]);
			arr[j][1] = Integer.parseInt(line.split(" ")[1]);
		}

		meetingOverlap(arr);
	}

	public static void meetingOverlap(int[][] array) {

		Stack<Integer> startingTime = new Stack<>();
		Stack<Integer> endingTime = new Stack<>();

		int[][] Sarr = sort2d(array, 0);

		startingTime.push(Sarr[0][0]);
		endingTime.push(Sarr[0][1]);

		for (int i = 1; i < Sarr.length; i++) {
			if (endingTime.peek() >= Sarr[i][0]) {
				int v2 = endingTime.pop();
				int max = Math.max(Sarr[i][1], v2);
				endingTime.push(max);

			} else {
				startingTime.push(Sarr[i][0]);
				endingTime.push(Sarr[i][1]);

			}

		}
		Stack<String> st = new Stack<>();
		while (startingTime.size() > 0) {
			int k = startingTime.pop();
			int l = endingTime.pop();
			st.push(k + " " + l);

		}

		while (st.size() > 0) {
			System.out.println(st.pop());

		}
	}

	public static int[][] sort2d(int[][] arr, int col) {
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] val1, int[] val2) {
				if (val1[col] > val2[col]) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		return arr;
	}

}

//mergerOverlappingUsingStack