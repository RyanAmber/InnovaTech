public class Student extends User{
    private group myGroup;
    public Student(String name, String password, group myGroup){
        super(name,password);
        this.myGroup=myGroup;
    }
    //public boolean request(Electronic e){

    //}
}
