class StackFullException extends Exception
 {
    public StackFullException() 
    {
        super();
    }
    public StackFullException(String message) 
    {
        super(message);
    }
    public String toString()
    {
        return "STACK IS FULL";
    }
}
class StackEmptyException extends Exception 
{
    public StackEmptyException() 
    {
        super();
    }
    public StackEmptyException(String message) 
    {
        super(message);
    }
    public String toString()
    {
        return "STACK IS EMPTY";
    }
}

////////////////////////////////////////////////////////////////////////////////////////

class Stack 
{
    private int[] data;    
    private int top;       
    private int capacity;  

    Stack(int capacity) 
    {
        this.capacity = capacity;
        data = new int[capacity];
        top = -1; 
    }

    void push(int element) throws StackFullException 
    {
        if (top == capacity - 1) 
            throw new StackFullException("Stack is full. Cannot push " + element);
        data[++top] = element;
    }

    void pop() throws StackEmptyException 
    {
        if (top < 0)
            throw new StackEmptyException("Stack is empty. Cannot pop.");
        top--;
    }
    public void show() 
    {
        if (top < 0) 
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements (bottom -> top): ");
        for (int i = 0; i <= top; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }
}

////////////////////////////////////////////////////////////////////////

public class Stack_Exception
{
    public static void main(String[] args) 
    {
        Stack stack = new Stack(3);
        try 
        {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println(stack.toString());
            stack.show();
            stack.push(40);
        } 
        catch (StackFullException e) 
        {
            System.out.println("Exception caught: " + e.getMessage());
        }
        try 
        {
            stack.pop();
            System.out.println("\nAfter one pop:");
            System.out.println(stack.toString());
            stack.show();
            
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (StackEmptyException e) 
        {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
