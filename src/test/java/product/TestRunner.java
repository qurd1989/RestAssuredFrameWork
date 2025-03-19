package product;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
            features = "src/features",
            glue = {"steps"},
            plugin = {"pretty", "html:target/cucumber-reports"},
            monochrome = true
    )
    public class TestRunner  extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
}
