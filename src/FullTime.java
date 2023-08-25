public class FullTime extends Teacher {
    private String name;

    private double baseSalary;
    private int experienceYears;

    public FullTime(String name, double baseSalary, int experienceYears) {
        super(name);
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    @Override
    public double calculateSalary() {
        return baseSalary * (1 + 0.1 * experienceYears);
    }

    @Override
    public String getTeacherType() {
        return "Full-Time";
    }
}
