import java.io.*;
import java.util.*;
public class largestAreaHistogram {
public static void main(String args[]) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[] heights = new int[n];
	    for(int i = 0; i < n; i++){
	       heights[i] = Integer.parseInt(br.readLine());
	    }
	    int[] rightBoundry = new int[heights.length];//nse index on the right
	    Stack<Integer> st = new Stack<>();
	    st.push(heights.length-1);
	    rightBoundry[heights.length-1] = heights.length;
	    for(int i=heights.length-2;i>=0;i--){
	        while(st.size()>0 && heights[i]<=heights[st.peek()]){
	            st.pop();
	        }
	        if(st.size()==0){
	            rightBoundry[i] = heights.length;
	        }else{
	            rightBoundry[i] = st.peek();
	        }
	        st.push(i);
	    }
	   
	   int[] leftBoundry = new int[heights.length]; //nse index on the left
	   st = new Stack<>();
	    st.push(0);
	    rightBoundry[0] = -1;
	    for(int i=1;i<heights.length;i++){
	        while(st.size()>0 && heights[i]<=heights[st.peek()]){
	            st.pop();
	        }
	        if(st.size()==0){
	            leftBoundry[i] = -1;
	        }else{
	            leftBoundry[i] = st.peek();
	        }
	        st.push(i);
	    }
	   
	   int maxArea = 0;
	   for(int i=0;i<heights.length;i++){
	       int width = rightBoundry[i]-leftBoundry[i]-1;
	       int area  = heights[i]*width;
	       if(area>maxArea){
	           maxArea = area;
	       }
	   }
	   System.out.println(maxArea);
}
}
