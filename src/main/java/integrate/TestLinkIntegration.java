package integrate;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	public static final String API_TESTLINK_KEYS="f16e52f2a8dea0be1bd51a6d113fa6c0"; // Replace your TestLink API Key here
	public static final String TESTLINK_URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";// Replace your TestLink url
	public static final String TEST_PROJECT_NAME=""; // Provide Project Name form TestLink
	public static final String TEST_PLAN_NAME=""; // Provide Test Plan Name form TestLink
	public static final String TEST_CASE_NAME="";// Provide Test case Name form TestLink
	public static final String BUILD_NAME="";// Provide Build Name form TestLink

	public static void updateResult(String exception, String results) throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(API_TESTLINK_KEYS, TESTLINK_URL);
		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME,TEST_CASE_NAME, BUILD_NAME,exception,results);


	}

}
