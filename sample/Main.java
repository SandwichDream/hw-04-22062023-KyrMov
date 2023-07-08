package sample;

import sample.exceptions.GroupOverflowException;
import sample.exceptions.StudentNotFoundException;
import sample.exceptions.SameIdException;

public class Main {
    public static void main(String[] args) {
        try {
            Group group = new Group("Group A");

            for (int i = 0; i < 5; i++) {
                group.addStudent(new Student("Nick#" + i, "Last#" + i, Gender.MALE, i + 15, i + 1,
                        group.getGroupName()));
            }

            group.addStudent(new Student("Luna", "Crime", Gender.FEMALE, 17, 6, group.getGroupName()));
            group.addStudent(new Student("Jane", "Smith", Gender.FEMALE, 18, 7, group.getGroupName()));
            group.addStudent(new Student("Mike", "Johnson", Gender.MALE, 19, 8, group.getGroupName()));
            group.addStudent(new Student("July", "Rich", Gender.FEMALE, 17, 9, group.getGroupName()));
            group.addStudent(new Student("Steve", "Adams", Gender.MALE, 18, 10, group.getGroupName()));
            // group.addStudent(new Student("John", "Doe", Gender.MALE, 11,
            // group.getGroupName()));

            System.out.println(group);

            System.out.println();

            System.out.println("Found Student(s):" + System.lineSeparator() + group.searchStudentByLastName("Smith"));

            System.out.println(group.removeStudentByID(5));

            System.out.println();

            System.out.println(group);

            System.out.println(System.lineSeparator() + "After sorting by last name:");

            group.sortStudentsByLastName();

            System.out.println(group);

            System.out.println();

            System.out.println("Add student");

            HelloStudent ws = new HelloStudent();
            ws.writeStudent(group);

            System.out.println();

            group.sortStudentsByLastName();

            System.out.println(group);

        } catch (GroupOverflowException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SameIdException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}