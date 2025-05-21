public class Teacher extends User{
    public Teacher(String username, String password){
        super(username,password);
    }
    public void checkOut(group g){
        for (Electronic e:g.getTray()){
            g.borrow(e);
        }
    }
    public void markBroken(Electronic e){
        e.setWorking(false);
    }
    public void markWorking(Electronic e){
        e.setWorking(true);
    }
}
