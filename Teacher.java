public class Teacher extends User{
    public Teacher(String username, String password){
        super(username,password);
    }
    public void checkOut(group g){
        for (Electronic e:g.getTray()){
            g.borrow(e);
        }
    }
}
