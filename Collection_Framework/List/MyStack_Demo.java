package code.Collection_Framework.List;
import java.util.*;

public class MyStack_Demo {
    public static void main(String args[]) {
        Stack<String> st = new Stack<>();   // only vs code error works fine else where
        st.push("Hello");
        st.push("World");
        System.out.println(st.pop());
    }
}
