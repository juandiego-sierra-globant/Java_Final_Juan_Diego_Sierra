public abstract class Teacher {
        private String name;
        private double baseSalary;
        private int experienceYears;

        public Teacher(String name) {
                this.name = name;
        }


        public  String getName() {
                return name;
        }

        public abstract double calculateSalary();

        public abstract String getTeacherType();
        public void  displayInfo() {
                System.out.println("Name: " + getName());
                System.out.println("Teacher Type: " + getTeacherType());
                System.out.println("Salary: $" + calculateSalary());
                System.out.println();
        }


}
