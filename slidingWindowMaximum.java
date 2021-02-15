import java.util.*;
public class slidingWindowMaximum {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<arr.length;i++) {
		arr[i] = sc.nextInt();
	}
	int k = sc.nextInt();
	
	Stack<Integer> st = new Stack<>();
	int[] nge = new int[arr.length];
	st.push(arr.length-1);
	nge[arr.length-1] = arr.length;
	for(int i=arr.length-2;i>=0;i--) {
		while(st.size()>0 && arr[i]>=arr[st.peek()]) {
			st.pop();
		}
		if(st.size()==0) {
			nge[i] = arr.length;
		}
		else {
			nge[i] = st.peek();
		}
		st.push(i);
	}
	int j = 0;
	for(int i=0;i<=arr.length-k;i++) {
		if(j<i) {
			j = i;
		}
		while(nge[j]<i+k) {
			j = nge[j];
		}
		System.out.println(arr[j]);
	}
}
}
