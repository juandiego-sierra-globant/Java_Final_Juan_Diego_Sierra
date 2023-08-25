public class partTime extends Teacher{
    private double salary;

    private String name;
    private int activeHoursPerWeek;


    public partTime(String name, double salary, int activeHoursPerWeek) {
        super(name);
        this.salary = salary;
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return salary * activeHoursPerWeek;
    }

    @Override
    public String getTeacherType() {
        return "Part-Time";
    }


}





