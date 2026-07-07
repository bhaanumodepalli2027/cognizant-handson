package src;

/**
 * RealImage - loads image data from a remote server (expensive operation).
 */
public class RealImage implements Image {

    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("RealImage: Loading \"" + filename + "\" from remote server...");
    }

    @Override
    public void display() {
        System.out.println("RealImage: Displaying \"" + filename + "\"");
    }
}
