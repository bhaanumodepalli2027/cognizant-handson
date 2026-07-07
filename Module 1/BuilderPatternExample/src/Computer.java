package src;

/**
 * Computer - product class with multiple optional attributes.
 * Construction is managed entirely through the nested Builder.
 */
public class Computer {

    // Required attributes
    private final String cpu;
    private final String ram;

    // Optional attributes
    private final String storage;
    private final String gpu;
    private final boolean hasWifi;
    private final boolean hasBluetooth;

    // Private constructor — only the Builder can instantiate Computer
    private Computer(Builder builder) {
        this.cpu          = builder.cpu;
        this.ram          = builder.ram;
        this.storage      = builder.storage;
        this.gpu          = builder.gpu;
        this.hasWifi      = builder.hasWifi;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {
        return "Computer {" +
               "\n  CPU         = " + cpu +
               "\n  RAM         = " + ram +
               "\n  Storage     = " + (storage != null ? storage : "N/A") +
               "\n  GPU         = " + (gpu != null ? gpu : "N/A") +
               "\n  WiFi        = " + hasWifi +
               "\n  Bluetooth   = " + hasBluetooth +
               "\n}";
    }

    // ----------------------------------------------------------------
    // Static nested Builder class
    // ----------------------------------------------------------------
    public static class Builder {

        // Required
        private final String cpu;
        private final String ram;

        // Optional — default values
        private String  storage      = null;
        private String  gpu          = null;
        private boolean hasWifi      = false;
        private boolean hasBluetooth = false;

        /** Builder constructor requires the mandatory fields. */
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder wifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Builder bluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        /** Builds and returns the Computer instance. */
        public Computer build() {
            return new Computer(this);
        }
    }
}
