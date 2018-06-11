package base;


import common.Capability;

public class setCap {

    public static void main(String[] args) {
        Capability cap1 = new Capability("local");
        System.out.println("Child Size Local : "+cap1.getChildNodes().size());
        System.out.println("-----------------------------");
        cap1.getDesiredCapabilities();
        System.out.println("-----------------------------");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Capability cap2 = new Capability("sauce");
        System.out.println("Child Size sauce : "+cap2.getChildNodes().size());
        System.out.println("-----------------------------");
        cap2.getDesiredCapabilities();
        System.out.println("-----------------------------");

    }
}
