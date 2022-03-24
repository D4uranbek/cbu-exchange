import ui.BaseUI;

/**
 * @author D4uranbek чт. 10:04. 24.03.2022
 */
public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {

        BaseUI baseUI = BaseUI.getInstance();
        baseUI.exchange();

    }
}
