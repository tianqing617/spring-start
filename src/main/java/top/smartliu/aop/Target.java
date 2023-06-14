package top.smartliu.aop;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("Target save");
    }
}
