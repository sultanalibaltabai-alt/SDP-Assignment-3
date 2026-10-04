public class Main {
    static int passed = 0;
    static int total = 0;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    static void runDemo() {
        Circle c1 = new Circle("C1", 2, new VectorRenderer());
        check("T1", "Circle + VectorRenderer", c1.execute(), "VECTOR circle radius=2");

        Circle c2 = new Circle("C2", 2, new RasterRenderer());
        check("T2", "Circle + RasterRenderer", c2.execute(), "RASTER pixels of circle radius=2");

        Square s3 = new Square("S3", 3, new VectorRenderer());
        check("T3", "Square + VectorRenderer", s3.execute(), "VECTOR square side=3");

        Square s4 = new Square("S4", 3, new RasterRenderer());
        check("T4", "Square + RasterRenderer", s4.execute(), "RASTER pixels of square side=3");

        checkSwitch();

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    static void checkSwitch() {
        Circle original = new Circle("C5", 2, new VectorRenderer());
        String before = original.execute();

        Circle afterSwitch = original;
        afterSwitch.setImplementation(new RasterRenderer());
        String after = afterSwitch.execute();

        boolean sameObject = (original == afterSwitch);
        boolean stateUnchanged = original.getId().equals("C5") && original.getRadius() == 2;

        String expectedBefore = "VECTOR circle radius=2";
        String expectedAfter = "RASTER pixels of circle radius=2";

        boolean pass = sameObject && stateUnchanged
                && before.equals(expectedBefore) && after.equals(expectedAfter);

        total++;
        String status = "FAIL";
        if (pass) {
            passed++;
            status = "PASS";
        }

        System.out.println("T5 " + status + " | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        System.out.println("   before=" + before + " | after=" + after);
        if (!pass) {
            System.out.println("   expected before=" + expectedBefore + " | after=" + expectedAfter);
        }
    }

    static void check(String id, String classes, String actual, String expected) {
        total++;
        if (actual.equals(expected)) {
            passed++;
            System.out.println(id + " PASS | " + classes + " | result=" + actual);
        } else {
            System.out.println(id + " FAIL | " + classes + " | result=" + actual);
            System.out.println("   expected=" + expected);
        }
    }
}