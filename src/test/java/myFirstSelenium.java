import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class myFirstSelenium {
    WebDriver edgeDriver;
    @BeforeAll
    public  static  void  initSelenium(){
        WebDriverManager.edgedriver().setup();

    }

    @BeforeEach
    public void initDriver(){
        if(edgeDriver == null)
            edgeDriver= new EdgeDriver();
    }

    @Test
    public void myFirstSeleniumTest(){
        edgeDriver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDownDriver(){
        edgeDriver.quit();
    }
}
