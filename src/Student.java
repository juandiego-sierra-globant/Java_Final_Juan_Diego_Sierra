public class Student {
    private String name;
    private int id;
    private int age;
    private static int totalStudents = 0;
    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        totalStudents++;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public int getAge(){
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Age:" + getAge());
        System.out.println();
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}
