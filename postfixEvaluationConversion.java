import java.io.*;
import java.util.*;

public class postfixEvaluationConversion{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> valueStack = new Stack<>();
    Stack<String> infixStack = new Stack<>();
    Stack<String> prefixStack = new Stack<>();
    
    for(int i=0;i<exp.length();i++)
    {
        char ch = exp.charAt(i);
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            int v2 = valueStack.pop();
            int v1 = valueStack.pop();
            valueStack.push(operation(v1,v2,ch));
            
            String infixv2 = infixStack.pop();
            String infixv1 = infixStack.pop();
            infixStack.push('('+infixv1+ch+infixv2+')');
            
            String prefixv2 = prefixStack.pop();
            String prefixv1 = prefixStack.pop();
            prefixStack.push(ch+prefixv1+prefixv2);
            
            
        }else{
            valueStack.push(ch-'0');
            infixStack.push(ch+"");
            prefixStack.push(ch+"");
        }
    }
    System.out.println(valueStack.peek());
    System.out.println(infixStack.peek());
    System.out.println(prefixStack.peek());
 }
 public static int operation(int v1, int v2, char op){
     if(op=='+'){
         return v1+v2;
     }else if(op=='-'){
         return v1-v2;
     }else if(op=='*'){
         return v1*v2;
     }else{
         return v1/v2;
     }
     
 }
}