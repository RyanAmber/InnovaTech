public class Student extends User{
    private group myGroup;
    public Student(String name, String password, group myGroup){
        super(name,password);
        this.myGroup=myGroup;
    }
    public Student(String name, String password, int teamNum){
        super(name,password);
        myGroup=new group(teamNum);
    }
    public String toString(){
        return "Student:"+super.toString();
    }
    public group getGroup(){
        return myGroup;
    }
    public boolean addToTray(Electronic e){
        if(e.getGroup().getTeamNum()==0 && e.getWorking() == true) {
            myGroup.add(e);
            return true;
        }
        else {
            return false;
        }
    }
    public void toBreak(Electronic e){
       e.setCheck(true); 
    }
}

