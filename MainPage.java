import java.util.*;
import java.io.*;
public class MainPage {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        FileReader file=new FileReader("UserData");
        System.out.println("What is your name");
        String name=s.next();
        s.close();
    }
}
