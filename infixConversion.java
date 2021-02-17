import java.util.*;
public class infixConversion{
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String exp = sc.nextLine();  
    Stack<Character> operators = new Stack<>();
    Stack<String> preOperands = new Stack<>();
    Stack<String> postOperands = new Stack<>();
    for(int i =0;i<exp.length();i++){
        char ch = exp.charAt(i);
        if(ch=='('){
            operators.push(ch);
        }else if((ch>='0' && ch<=9)|| (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
            preOperands.push(ch+"");
            postOperands.push(ch+"");
        }else if(ch==')'){
            while(operators.size()>0 && operators.peek()!='('){
                char opv = operators.pop();
                String  prev2 = preOperands.pop();
                String  prev1 = preOperands.pop();
                String preValue = opv + prev1+prev2;
                preOperands.push(preValue);
                
                String  post2 = postOperands.pop();
                String  post1 = postOperands.pop();
                String postValue =  post1+post2+opv;
                postOperands.push(postValue);
                
            }
            operators.pop();
        }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            while(operators.size()>0 && operators.peek()!='(' && precedence(ch)<=precedence(operators.peek())){
                 char opv = operators.pop();
                String  prev2 = preOperands.pop();
                String  prev1 = preOperands.pop();
                String preValue = opv + prev1+prev2;
                preOperands.push(preValue);
                
                String  post2 = postOperands.pop();
                String  post1 = postOperands.pop();
                String postValue =  post1+post2+opv;
                postOperands.push(postValue);
            }
            operators.push(ch);
        }
    }
    while(operators.size()!=0){
                 char opv = operators.pop();
                String  prev2 = preOperands.pop();
                String  prev1 = preOperands.pop();
                String preValue = opv + prev1+prev2;
                preOperands.push(preValue);
                
                String  post2 = postOperands.pop();
                String  post1 = postOperands.pop();
                String postValue =  post1+post2+opv;
                postOperands.push(postValue);
                
            }
            System.out.println(postOperands.peek());
            System.out.println(preOperands.peek());   
 }
 
 public static int precedence(char operator) {
    if (operator == '+') {
      return 1;
    } else if (operator == '-') {
      return 1;
    } else if (operator == '*') {
      return 2;
    } else {
      return 2;
    }
  }
 
} 