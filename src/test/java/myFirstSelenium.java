import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class myFirstSelenium {
    static WebDriver driver;
    static  final String WEBSITE="https://the-internet.herokuapp.com/dropdown";
    @BeforeAll
    public  static  void  initSelenium(){
        WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();

    }


    @Nested
    @DisplayName("Testing on Edge Browser")
    public  class EdgeTesting{
        @BeforeAll
        public static void initEdge(){
            driver = new EdgeDriver();
        }
        @Test
        public  void toggle(){
            driver.get(WEBSITE);
           WebElement dropdownMenu = driver.findElement(By.id("dropdown"));
           WebElement optionOne = dropdownMenu.findElement(By.cssSelector("option[value='1']"));
           WebElement optionTwo = dropdownMenu.findElement(By.cssSelector("option[value='2']"));
           dropdownMenu.click();
           optionOne.click();
           assertTrue(optionOne.isSelected());
           assertFalse(optionTwo.isSelected());

        }

    }
    @Nested
    @DisplayName("Testing on Chrome Browser")
    public  class ChromeTesting{
        @BeforeAll
        public static void initEdge(){
            driver = new ChromeDriver();
        }
        @Test
        public  void toggle(){
            driver.get(WEBSITE);
            WebElement dropdownMenu = driver.findElement(By.id("dropdown"));
            WebElement optionOne = dropdownMenu.findElement(By.cssSelector("option[value='1']"));
            WebElement optionTwo = dropdownMenu.findElement(By.cssSelector("option[value='2']"));
            dropdownMenu.click();
            optionOne.click();
            assertTrue(optionOne.isSelected());
            assertFalse(optionTwo.isSelected());

        }

    }

    @AfterEach
    public void tearDownDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
