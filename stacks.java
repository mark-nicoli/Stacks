import java.util.Arrays;
import java.util.Scanner;
public class Stacks
{

    private String [] stackArray;
    private int stackSize;
    private int topOfStack = -1;   //empty stack
    private Stacks(int size)
    {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray,"-1");
    }

    private void push(String input)
    {
        if(topOfStack+1<stackSize)
        {
            topOfStack++;
            stackArray[topOfStack] = input;
        }
        else
        {
            System.out.println("sorry but the stack is full");
        }
        displayTheStack();
        System.out.println("PUSH "+input+" was added to the stack");
    }
    private String pop()  //remove last item from the stack
    {
        if(topOfStack>=0)
        {
            displayTheStack();
            System.out.println(" POP "+ stackArray[topOfStack]+"was removed form the stack");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        }
        else
        {
            displayTheStack();
            System.out.println("the stack is empty");
            return "-1";
        }
    }

    private String peek()   //see what is at the top of the stack
    {
        displayTheStack();
        System.out.println("peek "+stackArray[topOfStack]+" is at the top of the stack");
        return stackArray[topOfStack];
    }

    private void pushMany(String multipleValues)   //push more than one value
    {
        String[] tempString = multipleValues.split(" ");
        for(int i = 0;i<tempString.length;i++) {
            push(tempString[i]);
        }
    }

    private void popAll()      //empty the stack
    {
        for (int i = topOfStack; i >= 0; i--) {
            pop();
        }
    }

    private void popDisplayAll() {
        String theReverse = "";
        for (int i = topOfStack; i >= 0; i--) {
            theReverse += stackArray[i];
        }
        System.out.println("The Reverse: " + theReverse);
        popAll();
    }

    private void displayTheStack()
    {
        for(int n = 0; n < 61; n++)System.out.print(" ");
        System.out.println();
        for(int n = 0; n < stackSize; n++)
        {
            System.out.printf("%2s "+ " ", n);
        }
        System.out.println(" ");
        for(int n = 0; n < 61; n++)System.out.print(" ");
        System.out.println();
        for(int n = 0; n < stackSize; n++)
        {
            if(stackArray[n].equals("-1")) System.out.print(" ");
            else System.out.print(String.format("%2s "+ " ", stackArray[n]));
        }
        System.out.println(" ");
        for(int n = 0; n < 61; n++)System.out.print(" ");
        System.out.println();
    }


    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        Stacks stack = new Stacks(10);
        //String array[] = new String[size];
        stack.push(scan.nextLine());   //1
        stack.push(scan.nextLine());   //2
        stack.push(scan.nextLine());   //3

        stack.peek();      // tells you what is at the top of the stack

        stack.pop();
        stack.pop();
        stack.pop();

        stack.pushMany("S T A C K S");
        stack.popDisplayAll();
        stack.displayTheStack();
    }
}
