import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/resources/firstScenario.feature", "src/main/resources/secondScenario.feature"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"}
        , glue = {"ru.aplana.autotests.steps"})
public class RunCucumberTest {

}