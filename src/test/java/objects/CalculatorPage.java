package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.util.HashMap;

public class CalculatorPage {

    WebDriver driver;

    private By button_0 = By.name("0");
    private By button_1 = By.name("1");
    private By button_2 = By.name("2");
    private By button_3 = By.name("3");
    private By button_4 = By.name("4");
    private By button_5 = By.name("5");
    private By button_6 = By.name("6");
    private By button_7 = By.name("7");
    private By button_8 = By.name("8");
    private By button_9 = By.name("9");
    private By button_plus = By.name("+");
    private By button_minus = By.name("-");
    private By button_divide = By.name("/");
    private By button_multiply = By.name("x");
    private By button_clear = By.name("C");
    private By button_dot = By.name(".");
    private By button_equal = By.name("=");
    private By result_box = By.id("resultsbox");

    private HashMap<String, WebElement> buttons= new HashMap<>();

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private void locateButtons() {
        buttons.put("0", driver.findElement(button_0));
        buttons.put("1", driver.findElement(button_1));
        buttons.put("2", driver.findElement(button_2));
        buttons.put("3", driver.findElement(button_3));
        buttons.put("4", driver.findElement(button_4));
        buttons.put("5", driver.findElement(button_5));
        buttons.put("6", driver.findElement(button_6));
        buttons.put("7", driver.findElement(button_7));
        buttons.put("8", driver.findElement(button_8));
        buttons.put("9", driver.findElement(button_9));
        buttons.put(".", driver.findElement(button_dot));
        buttons.put("+", driver.findElement(button_plus));
        buttons.put("-", driver.findElement(button_minus));
        buttons.put("x", driver.findElement(button_multiply));
        buttons.put("/", driver.findElement(button_divide));
        buttons.put("C", driver.findElement(button_clear));
        buttons.put("=", driver.findElement(button_equal));
    }

    @Step
    public String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            buttons.get(""+ expression.charAt(i)+"").click();
        }
        buttons.get("=").click();
        return driver.findElement(result_box).getAttribute("value");
    }

    @Step
    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());
        locateButtons();
    }

    @Step
    public void clear() {
        buttons.get("C").click();
    }
}