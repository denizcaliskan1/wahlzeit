import org.junit.runner.*;
import org.junit.runners.*;

import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlersTestSuite.class,
	ModelTestSuite.class,
	ServicesTestSuite.class,
	UtilsTestSuite.class
})

public class AllTests {/**do nothing*/}
