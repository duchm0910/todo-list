package integrate;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	public static final String API_TESTLINK_KEYS="f16e52f2a8dea0be1bd51a6d113fa6c0";
	public static final String TESTLINK_URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME="todo-list";
	public static final String TEST_PLAN_NAME="Todo-List Selenium";
	public static final String TEST_CASE_NAME="Login, Create, Delete";
	public static final String BUILD_NAME="";

	public static void updateResult(String testcaseName, String exception, String results) throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(API_TESTLINK_KEYS, TESTLINK_URL);
		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME,testcaseName, BUILD_NAME,exception,results);


	}

}
