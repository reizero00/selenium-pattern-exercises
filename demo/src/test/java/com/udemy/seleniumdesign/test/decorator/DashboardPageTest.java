package com.udemy.seleniumdesign.test.decorator;

import java.util.function.Consumer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import com.udemy.seleniumdesign.test.BaseTest;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setDashboardPage() {
        this.dashboardPage = new DashboardPage(driver);
    }
    
    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> role) {
        this.dashboardPage.goTo();
        role.accept(dashboardPage);

    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
            Decorators.guestPage,
            Decorators.superUserPage,
            Decorators.adminPage
        };
    }

}
