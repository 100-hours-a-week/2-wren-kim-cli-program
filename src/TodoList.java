import java.util.ArrayList;

// 할 일 목록 관리
public class TodoList {
    private final ArrayList<TodoItem> todoItems;
    private int counter;

    public TodoList() {
        this.todoItems = new ArrayList<>();
        this.counter = 1;
    }

    public void addTask(String task) {
        TodoItem newItem = new TodoItem(counter++, task);
        todoItems.add(newItem);
        System.out.println(ConsoleColor.GREEN + "✔ 할 일이 추가되었습니다: " + task + ConsoleColor.RESET);
    }

    public void addTaskWithDeadline(String task, String dueDate) {
        DeadlineTodoItem newItem = new DeadlineTodoItem(counter++, task, dueDate);
        todoItems.add(newItem);
        System.out.println(ConsoleColor.GREEN + "✔ 마감 기한이 있는 할 일이 추가되었습니다: " + task + " (마감일: " + dueDate + ")" + ConsoleColor.RESET);
    }

    public void showTasks() {
        if (todoItems.isEmpty()) {
            System.out.println(ConsoleColor.RED + "🚫 할 일이 없습니다." + ConsoleColor.RESET);
        } else {
            System.out.println(ConsoleColor.CYAN + "-------------------- [할 일 목록] --------------------" + ConsoleColor.RESET);
            System.out.println("| ID  | 할 일                | 상태      | 마감일       |");
            System.out.println("|-----|----------------------|----------|-------------|");
            for (TodoItem item : todoItems) {
                System.out.println(item);
            }
            System.out.println("----------------------------------------------------");
        }
    }

    public void markTaskDone(int taskId) {
        for (TodoItem item : todoItems) {
            if (item.getId() == taskId) {
                item.markDone();
                System.out.println(ConsoleColor.GREEN + "✔ 할 일이 완료되었습니다: " + item.getTask() + ConsoleColor.RESET);
                return;
            }
        }
        System.out.println(ConsoleColor.RED + "🚫 해당 번호의 할 일을 찾을 수 없습니다." + ConsoleColor.RESET);
    }

    public void deleteTask(int taskId) {
        if (todoItems.removeIf(item -> item.getId() == taskId)) {
            System.out.println(ConsoleColor.RED + "❌ 할 일이 삭제되었습니다: " + taskId + ConsoleColor.RESET);
        } else {
            System.out.println(ConsoleColor.RED + "🚫 해당 번호의 할 일을 찾을 수 없습니다." + ConsoleColor.RESET);
        }
    }
}
