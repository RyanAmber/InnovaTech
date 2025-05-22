public class Teacher extends User{
    public Teacher(String username, String password){
        super(username,password);
    }
    public String toString(){
        return "Teacher:"+super.toString();
    }
    public void checkOut(group g){
        for (Electronic e:g.getTray()){
            g.borrow(e);
        }
    }
    public void markBroken(Electronic e){
        e.setWorking(false);
        e.setCheck(false);
    }
    public void markWorking(Electronic e){
        e.setWorking(true);
        e.setCheck(false);
    }
}
