import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join
        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them
        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."
        Store all these 3 objects in a collection and print them
        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */
        int students = 0;
        int numberOfMathStudents = 0;
        int numberOfScienceStudents = 0;

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> listOfStudents = new ArrayList<>();

        while (students < 3) {
            System.out.println(UserQuestions.askToJoin);
            if (scanner.nextLine().toLowerCase().startsWith("y")) {
                System.out.println(UserQuestions.askFirstName);
                String firstName = scanner.nextLine();
                System.out.println(UserQuestions.askLastName);
                String lastName = scanner.nextLine();
                System.out.println(UserQuestions.askAge);
                int age = scanner.nextInt();
                try {
                    Permission.checkAge(age);
                } catch (RuntimeException c) {
                    c.printStackTrace();
                    scanner.nextLine();
                    continue;
                }
                System.out.println(UserQuestions.askGender);
                scanner.nextLine();
                String gender = scanner.nextLine();
                System.out.println(UserQuestions.askClassName);
                String className = scanner.nextLine();
                try {
                    Permission.checkClassName(className);
                } catch (RuntimeException c) {
                    c.printStackTrace();
                    continue;
                }

                if (className.equalsIgnoreCase("Math")) {
                    MathStudent mathStudent = new MathStudent(firstName, lastName, age, gender, className);
                    listOfStudents.add(mathStudent);
                    students++;
                    numberOfMathStudents++;
                } else {
                    MathStudent scienceStudents = new MathStudent(firstName, lastName, age, gender, className);
                    listOfStudents.add(scienceStudents);
                    students++;
                    numberOfScienceStudents++;
                }
                System.out.println("Congratulations! You are registered for " + className + " class.");
            }

        }
        for (Student listOfStudent : listOfStudents) {
            System.out.println(listOfStudent);
        }
        System.out.println("Math students = " + numberOfMathStudents);
        System.out.println("Science students = " + numberOfScienceStudents);

    }
}