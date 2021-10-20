import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Testing {
    public static void main(String[] args) {
        /*List<Integer> lst = new ArrayList<>();
        Optional<Integer> first = lst.stream().findFirst();
        System.out.println();
        */

        List<Employee> empList = new ArrayList<>(Arrays.asList(new Employee(25,"ABC"), new Employee(30,"DEF")));

        List<Employee> collect = empList.stream().map(Testing::enrichAge).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    private static Employee enrichAge(Employee employee) {
        employee.setAge(45);
        employee.setName("DEG");
        return employee;
    }

    static class Employee {
        public Employee(int age, String name) {
            this.age = age;
            this.name = name;
        }
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
