import java.io.*;
import java.util.*;

public class prefixEvaluationConversion{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    Stack<Integer> valueStack = new Stack<>();
    Stack<String> infixStack = new Stack<>();
    Stack<String> postfixStack = new Stack<>();
    
    for(int i=exp.length()-1;i>=0;i--){
        char ch = exp.charAt(i);
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            int valueStackv1 = valueStack.pop();
            int valueStackv2 = valueStack.pop();
            valueStack.push(operation(valueStackv1,valueStackv2,ch));
            
            String infixStackv1 = infixStack.pop();
            String infixStackv2 = infixStack.pop();
            infixStack.push('('+infixStackv1+ch+infixStackv2+')');
            
            String postfixStackv1 = postfixStack.pop();
            String postfixStackv2 = postfixStack.pop();
            postfixStack.push(postfixStackv1+postfixStackv2+ch);
            
        }else{
            valueStack.push(ch-'0');
            infixStack.push(ch+"");
            postfixStack.push(ch+"");
        }
    }
    System.out.println(valueStack.peek());
    System.out.println(infixStack.peek());
    System.out.println(postfixStack.peek());
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