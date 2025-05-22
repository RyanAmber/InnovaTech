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
        Map<String, String[]> users=new HashMap<String,String[]>();
        try {
            while (file.ready()){
                String line=file.readLine()+"";
                String[] parts=line.split(" ");
                String[] strs={parts[1],parts[2]};
                users.put(parts[0],strs);
            }
        } catch (IOException e) {}
        User u=signIn(s, users);
        System.out.println("Welcome "+u.toString());
        if (u instanceof Teacher){
            System.out.println("You are a teacher");
        }else if (u instanceof Student){
            System.out.println("You are a student");
            System.out.println("Your group number is "+((Student)u).getGroup().getTeamNum());
        }
        
        s.close();
    }
    public static void createUser(String username, String password, Map<String, String[]> users){
        String[] str={password," Non-Verified"};
        users.put(username,str);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("UserData", true));
            writer.newLine();
            writer.write(username+" "+password+" Non-Verified");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static User signIn(Scanner s, Map<String, String[]> users){
        System.out.println("What is your name");
        String username=s.next();
        if (!users.containsKey(username)||users.get(username)[1].equals("Non-Verified")){
            System.out.println("User Not Found");
            System.out.println("Would you like to create a new user? (Y/N)");
            String createUser=s.next();
            if (createUser.equals("Y")){
                System.out.println("What is your password?");
                String password=s.next();
                createUser(username, password, users);
            }else if (createUser.equals("N")){
                return signIn(s, users);
            }
        }else{
            System.out.println("What is your password");
            String password=s.next();
            if (!users.get(username)[0].equals(password)){
                System.out.println("Wrong Password");
            }else{
                if (users.get(username)[1].equals("Teacher")){
                    return new Teacher(username, password);
                }else if (users.get(username)[1].equals("Student")){
                    System.out.println("What is your group number?");
                    int groupNum=s.nextInt();
                    return new Student(username, password, groupNum);
                }
            }
        }
        return signIn(s, users);
    }
}
