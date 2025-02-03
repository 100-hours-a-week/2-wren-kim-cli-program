import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println(ConsoleColor.CYAN + "\n========= TODO LIST =========" + ConsoleColor.RESET);
            System.out.println(" 1. 할 일 추가");
            System.out.println(" 2. 마감 기한 할 일 추가");
            System.out.println(" 3. 할 일 목록 보기");
            System.out.println(" 4. 할 일 완료 체크");
            System.out.println(" 5. 할 일 삭제");
            System.out.println(" 6. 종료");
            System.out.println(ConsoleColor.CYAN + "=============================" + ConsoleColor.RESET);
            System.out.print(" 선택 >> ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 클리어

            switch (choice) {
                case 1:
                    System.out.print("할 일을 입력하세요: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;

                case 2:
                    System.out.print("할 일을 입력하세요: ");
                    String taskWithDeadline = scanner.nextLine();
                    System.out.print("마감일을 입력하세요 (예: 2025-01-31): ");
                    String dueDate = scanner.nextLine();
                    todoList.addTaskWithDeadline(taskWithDeadline, dueDate);
                    break;

                case 3:
                    todoList.showTasks();
                    break;

                case 4:
                    System.out.print("완료할 할 일 번호를 입력하세요: ");
                    int doneId = scanner.nextInt();
                    scanner.nextLine();
                    todoList.markTaskDone(doneId);
                    break;

                case 5:
                    System.out.print("삭제할 할 일 번호를 입력하세요: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    todoList.deleteTask(deleteId);
                    break;

                case 6:
                    System.out.println(ConsoleColor.YELLOW + "프로그램을 종료합니다." + ConsoleColor.RESET);
                    scanner.close();
                    return;

                default:
                    System.out.println(ConsoleColor.RED + "🚫 올바른 번호를 입력하세요." + ConsoleColor.RESET);
            }
        }
    }
}
