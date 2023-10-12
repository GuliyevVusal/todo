package toDo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nAdvanced ToDo List Menu: ");
            System.out.println("1) Add Task");
            System.out.println("2) View Tasks");
            System.out.println("3) Mark Task as Completed");
            System.out.println("4) Quit");
            System.out.print("Enter your choice (1/2/3/4): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = sc.nextLine();
                    System.out.print("Enter due date (dd/MM/yyyy): ");
                    String dueDateStr = sc.nextLine();
                    try {
                        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDateStr);
                        tasks.add(new Task(taskDescription, dueDate));
                        System.out.println("Task aded !");
                    } catch (java.text.ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    }
                    break;
                case 2:
                    System.out.println("\nTask List: ");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskNumber = sc.nextInt();
                    if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                        Task task = tasks.get(taskNumber - 1);
                        task.markAsCompleted();
                        System.out.println("Task marked as completed !");
                    } else {
                        System.out.println("Invalid task number !!");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!!!!!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.. Please choose 1 , 2, 3, 4. ");
            }
        }
    }
}
