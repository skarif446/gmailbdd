package mypack;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features={"~@target\\ftests.txt"},
            plugin={"pretty","html:target\\regtestres"},
            monochrome=true)
public class Regressiontest
{

}








