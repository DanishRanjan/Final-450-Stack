import java.io.*;
import java.util.*;

public class celebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }
        while(st.size()>=2){
            int i =st.pop();
            int j = st.pop();
            
            if(arr[i][j]==1) //i, j ko jaanta h , means i is not celebrity
            {
               st.push(j);
            }else            //i, j ko nhi jaanta, means j is not a celebrity
            {
                st.push(i);
            }
        }
        
        int pot = st.peek();  //the left over in stack is potential answer but we have to verify it by traversing 
        for(int i=0;i<arr.length;i++){ //in row and column
            if(i!=pot){// diagonal are always zero so we ignored  it
                if(arr[pot][i]==1 && arr[i][pot]==0){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }

}