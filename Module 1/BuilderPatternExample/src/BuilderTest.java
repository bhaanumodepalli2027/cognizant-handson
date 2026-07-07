package src;

/**
 * Test class demonstrating different Computer configurations via the Builder Pattern.
 */
public class BuilderTest {

    public static void main(String[] args) {

        // Configuration 1: Basic office PC
        Computer officePC = new Computer.Builder("Intel Core i5", "8GB DDR4")
                .storage("256GB SSD")
                .wifi(true)
                .build();

        // Configuration 2: High-end gaming rig
        Computer gamingPC = new Computer.Builder("Intel Core i9", "32GB DDR5")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .wifi(true)
                .bluetooth(true)
                .build();

        // Configuration 3: Minimal server node (no GUI peripherals)
        Computer server = new Computer.Builder("AMD EPYC 7763", "128GB ECC DDR4")
                .storage("4TB HDD RAID")
                .build();

        System.out.println("=== Office PC ===");
        System.out.println(officePC);

        System.out.println("\n=== Gaming PC ===");
        System.out.println(gamingPC);

        System.out.println("\n=== Server Node ===");
        System.out.println(server);
    }
}
