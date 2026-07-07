package src;

/**
 * Test class demonstrating the Command Pattern for home automation.
 */
public class CommandTest {

    public static void main(String[] args) {
        // Receivers
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight    = new Light("Kitchen");

        // Commands
        Command livingRoomOn  = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);
        Command kitchenOn     = new LightOnCommand(kitchenLight);
        Command kitchenOff    = new LightOffCommand(kitchenLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        System.out.println("=== Evening routine ===");
        remote.setCommand(livingRoomOn);
        remote.pressButton();

        remote.setCommand(kitchenOn);
        remote.pressButton();

        System.out.println("\n=== Bedtime routine ===");
        remote.setCommand(kitchenOff);
        remote.pressButton();

        remote.setCommand(livingRoomOff);
        remote.pressButton();
    }
}
