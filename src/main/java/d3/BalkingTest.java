package d3;

/**
 * @Description:
 * @Author: LiYang
 * @Date: 2025/2/28 21:32
 */
public class BalkingTest {

    volatile boolean initialized = false;

    void init() {
        if(initialized) {
            return;
        }
        doInit();
        initialized = true;
    }

    private void doInit() {

    }
}
