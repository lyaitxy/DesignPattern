package DesignPattern.桥接模式;

/**
 * 实体桥接实现类
 */
public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ",x " + x + ", y:" + y + "]");
    }
}
