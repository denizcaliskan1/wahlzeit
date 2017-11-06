package org.wahlzeit.services;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.services.mailing.MailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	EmailAddressTest.class,
	LogBuilderTest.class,
	MailingTestSuite.class
})

public class ServicesTestSuite {/**do nothing*/}
