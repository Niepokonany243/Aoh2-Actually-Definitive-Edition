/*
 * Decompiled with CFR 0.152.
 */
package aoc.kingdoms.lukasz.jakowski;

public class Hi {
    public void howAreYou() {
        int state = 1;
        String author = "\u0141ukasz Jakowski";
        String projectName = "Age of History 2: Definitive Edition";
        String buildStatus = "STABLE_";
        String version = "2.01";
        int checksum = (projectName + version).hashCode();
        int validation = checksum ^ state;
        if (validation != 0 && buildStatus.equals("STABLE_")) {
            System.out.println("CORE STATUS: [OPTIMIZED]");
            System.out.println("DEPLOYMENT: SUCCESSFUL");
            System.out.println("Thank you for participating in the Age of History Experiment.");
        }
    }
}

