package com.udemy.seleniumdesign.test.decorator;

import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.udemy.seleniumdesign.decorator.DashboardPage;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    // Ingredients

    public static final Consumer<DashboardPage> adminComponentPresence = (dp) -> shouldDisplay(dp.getAdminComponents());
    public static final Consumer<DashboardPage> adminComponentNotPresence = (dp) -> shouldNotDisplay(dp.getAdminComponents());

    public static final Consumer<DashboardPage> superUserComponentPresence = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    public static final Consumer<DashboardPage> superUserComponentNotPresence = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());

    public static final Consumer<DashboardPage> guestComponentPresence = (dp) -> shouldDisplay(dp.getGuestComponents());
    public static final Consumer<DashboardPage> guestComponentNotPresence = (dp) -> shouldNotDisplay(dp.getGuestComponents());

    // Role Selector

    private static final Consumer<DashboardPage> SelectAdmin = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> SelectSuperUser = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> SelectGuest = (dp) -> dp.selectRole("guest");

    // User Role Pages

    public static final Consumer<DashboardPage> 
        guestPage = SelectGuest
        .andThen(guestComponentPresence)
        .andThen(superUserComponentNotPresence)
        .andThen(adminComponentNotPresence);

    public static final Consumer<DashboardPage>
        superUserPage = SelectSuperUser
        .andThen(superUserComponentPresence)
        .andThen(guestComponentPresence)
        .andThen(adminComponentNotPresence);

    public static final Consumer<DashboardPage>
        adminPage = SelectAdmin
        .andThen(adminComponentPresence)
        .andThen(superUserComponentPresence)
        .andThen(guestComponentPresence);


}
