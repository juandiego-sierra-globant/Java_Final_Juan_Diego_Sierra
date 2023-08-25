import java.util.ArrayList;
public class Subject {
    private String className;
    private String name;
    private String classroom;
    ArrayList<Student> students;
    public Subject(String className, String name, ArrayList<Student> students, String classroom){
        this.className=className;
        this.name = name;
        this.students = students;
        this.classroom = classroom;
    }
    public String getClassName(){

        return className;
    }
    public void getSubjectName(){
        System.out.println("Class: " + getClassName());
        System.out.println();
    }

    public void printData(){
        System.out.println(getClassName() + " Teacher: " + name + " Classroom: " + classroom + " Students: ");
        for (Student student : students) {
            System.out.println(" - " + student.getName());
        }
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
}
