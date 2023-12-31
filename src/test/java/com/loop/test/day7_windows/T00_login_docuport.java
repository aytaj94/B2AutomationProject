package com.loop.test.day7_windows;
import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T00_login_docuport extends TestBase {
    @Test
    public void test_login_docuport() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT1);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.USERNAME_ADVISOR1);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.USERNAME_EMPLOYEE1);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.USERNAME_SUPERVISOR1);
        DocuportUtils.logOut(driver);
    }
}