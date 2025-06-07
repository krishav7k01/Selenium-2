package com.selenium.design;

import org.openqa.selenium.By;

public interface Browser {
	

    /**
     * Switch to a browser window using its title.
     * @param windowTitle Title of the window to switch to.
     * @throws RuntimeException if the window with the given title is not found.
     */
    void switchToWindow(String windowTitle);

    /**
     * Accept the currently displayed alert.
     * @throws RuntimeException if no alert is present.
     */
    void acceptAlert();

    /**
     * Dismiss the currently displayed alert.
     * @throws RuntimeException if no alert is present.
     */
    void dismissAlert();

    /**
     * Get the text from the alert popup.
     * @return Text content of the alert.
     * @throws RuntimeException if no alert is present.
     */
    String getAlertText();

    /**
     * Switch to an iframe using a locator.
     * @param frameLocator By locator of the iframe.
     * @throws RuntimeException if the frame is not found or switch fails.
     */
    void switchToFrame(By frameLocator);

    /**
     * Switch back to the main/default content from any iframe.
     */
    void switchToDefaultContent();

    /**
     * Get the current page title.
     * @return The page title.
     */
    String getPageTitle();

    /**
     * Get the current URL.
     * @return The current page URL.
     */
    String getCurrentUrl();

    /**
     * Refresh the current page.
     */
    void refreshPage();

    /**
     * Navigate back in browser history.
     */
    void navigateBack();

    /**
     * Navigate forward in browser history.
     */
    void navigateForward();

}
