package mypack;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\batch235\\gmailbdd\\src\\test\\resources\\features\\feature1.feature",
		                   "E:\\batch235\\gmailbdd\\src\\test\\resources\\features\\feature2.feature"},
                plugin={"pretty","html:target\\stres"},
                monochrome=true,
                tags={"@smoketest"})
public class Smoketest 
{

}







