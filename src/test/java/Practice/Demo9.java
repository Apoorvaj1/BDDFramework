package Practice;

public class Demo9 {
    String name;
    int age;
    public int hashCode(){
        return age;
    }
    public Demo9(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args) {
        Demo9 a = new Demo9("Apoorv",46);
        System.out.println(a.name);
        System.out.println(a.age);
        System.out.println(a);


    }
}
