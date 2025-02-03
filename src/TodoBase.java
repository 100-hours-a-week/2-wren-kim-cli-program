// 기본 할 일 (상위 클래스)
public class TodoBase {
    private final int id;
    private final String task;

    public TodoBase(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }
}
