package code.String;

class Reversee 
{
    public static void main(String args[])
    {
        String str1 = "hi how are you";

        StringBuffer sb = new StringBuffer(str1);
        if(str1.equals(sb.reverse().toString())) System.out.println("true");
        else System.out.println("false");
    }
}