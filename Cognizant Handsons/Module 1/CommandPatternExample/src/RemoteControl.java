package src;

/**
 * RemoteControl - invoker that holds a command and triggers its execution.
 */
public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("RemoteControl: No command assigned.");
        }
    }
}
