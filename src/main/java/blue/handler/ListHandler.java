package blue.handler;

import blue.TaskList;

public class ListHandler extends CommandHandler {
    public ListHandler(TaskList taskList) {
        super(taskList);
    }

    @Override
    public String handle(String input) {
        String response = "Here are the tasks in your list:\n";
        String[] lines = new String[taskList.getSize()];
        for (int i = 1; i <= taskList.getSize(); i++) {
            lines[i - 1] = i + ". " + taskList.get(i);
        }
        response += String.join("\n", lines);
        return response;
    }
}
