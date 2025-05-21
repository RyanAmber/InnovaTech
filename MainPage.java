import java.util.*;
import java.io.*;
public class MainPage {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        BufferedReader file=null;
        try{
            file=new BufferedReader (new FileReader("UserData"));
        }catch(FileNotFoundException e){
            System.out.println("FILE Unavailable");
        }
        Map<String, String> users=new HashMap<String,String>();
        try {
            String line=file.readLine()+"";
            String[] parts=line.split(" ");
            users.put(parts[0],parts[1]);
        } catch (IOException e) {}
        System.out.println("What is your name");
        String username=s.next();
        if (!users.containsKey(username)){
            System.out.println("User Not Found");
        }else{
            System.out.println("What is your password");
            String password=s.next();
            if (!users.get(username).equals(password)){
                System.out.println("Wrong Password");
            }
        }
        s.close();
    }
}
