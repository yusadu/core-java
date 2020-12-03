package demo1;

public class Student {

    public Student(){
        super();
    }

    public Student(String name,Integer age,String sex,String address){
        super();
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.address=address;
    }

    private String name;
    private Integer age;
    private String sex;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "学生姓名："+name+"\n"+"学生年龄："+age+"\n"
                +"学生性别："+sex+"\n"+"家庭住址："+address;
    }

    public static void main(String[] args) {
        Student student=new Student("张三",18,"女","广东韶关");
        System.out.println(student);
    }
}
