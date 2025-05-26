import java.util.*;
import java.io.*;
import static spark.Spark.*;

public class MainPage {
    public static void main(String[] args) {
        port(Integer.parseInt(System.getenv().getOrDefault("PORT", "4567")));
        staticFiles.location("/public");

        post("/submit", (req, res) -> {
            String username = req.queryParams("name");
            String password = req.queryParams("password");

            if ("admin".equals(username) && "pass123".equals(password)) {
                res.redirect("/dashboard.html");
            } else {
                res.status(401);
                return "Invalid credentials";
            }
            return null;
        });

        get("/dashboard", (req, res) -> "Welcome to the dashboard!");
    }

        /*User u=signIn(s, users);
        System.out.println("Welcome "+u.toString());
        Inventory i=readInventoryData(); 
        if (u instanceof Teacher){
            System.out.println("You are a teacher");
        }else if (u instanceof Student){
            System.out.println("You are a student");
            System.out.println("Your group number is "+((Student)u).getGroup().getTeamNum());
        }
        //Split menus
        //Student or Teacher
        s.close();*/
    }
    public static Map<String, String[]> readUserData(){
        Map<String, String[]> users=new HashMap<String,String[]>();
        BufferedReader file=null;
        try{
            file=new BufferedReader (new FileReader("UserData"));
        }catch(FileNotFoundException e){
            System.out.println("FILE Unavailable");
        }
        try {
            while (file.ready()){
                String line=file.readLine()+"";
                String[] parts=line.split(" ");
                String[] strs={parts[1],parts[2]};
                users.put(parts[0],strs);
            }
        } catch (IOException e) {}
        return users;
    }
    public static Inventory readInventoryData(){
        Inventory i=new Inventory();
        BufferedReader file=null;
        try{
            file=new BufferedReader (new FileReader("InventoryData"));
        }catch(FileNotFoundException e){
            System.out.println("FILE Unavailable");
        }
        try {
            while (file.ready()){
                String line=file.readLine()+"";
                String[] parts=line.split(" ");
                Electronic e=new Electronic(parts[0], Boolean.parseBoolean(parts[1]), new group(Integer.parseInt(parts[2])), Integer.parseInt(parts[3]));
                i.addItem(e);
            }
        } catch (IOException e) {}
        return i;
    }
    public static void viewInventory(Inventory i){
        System.out.println(i);
    }
    public static void viewInventory(Inventory i, String type){
        System.out.println(i.statistics(type));
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
