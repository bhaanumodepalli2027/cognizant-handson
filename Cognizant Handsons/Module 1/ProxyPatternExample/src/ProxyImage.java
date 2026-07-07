package src;

/**
 * ProxyImage - virtual proxy with lazy initialization and caching.
 * The RealImage is only created on the first call to display().
 * Subsequent calls reuse the cached instance.
 */
public class ProxyImage implements Image {

    private final String filename;
    private RealImage    cachedImage;   // null until first access (lazy init)

    public ProxyImage(String filename) {
        this.filename    = filename;
        this.cachedImage = null;
    }

    @Override
    public void display() {
        if (cachedImage == null) {
            System.out.println("ProxyImage: Cache miss — creating RealImage for \"" + filename + "\"");
            cachedImage = new RealImage(filename);   // expensive — done only once
        } else {
            System.out.println("ProxyImage: Cache hit — reusing cached image for \"" + filename + "\"");
        }
        cachedImage.display();
    }
}
