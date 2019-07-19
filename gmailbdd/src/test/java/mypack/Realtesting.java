package mypack;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features={
		                   "src/test/resources/features"},
                plugin={"pretty","html:target\\rtres",
		                "rerun:target\\ftests.txt"},
                monochrome=true,tags = {"@smoketest"}) 
public class Realtesting
{

}






