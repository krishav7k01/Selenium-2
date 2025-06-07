package com.selenium.design;

import org.openqa.selenium.WebElement;

public interface Elements {
	 /**
     * Click on a WebElement after waiting for it to be clickable.
     * @param element WebElement to click.
     * @throws RuntimeException if click fails.
     */
    void click(WebElement element);

    /**
     * Send text input to a WebElement.
     * @param element WebElement to send input to.
     * @param text Text to send.
     * @throws RuntimeException if sending text fails.
     */
    void sendKeys(WebElement element, String text);

    /**
     * Get text content of a WebElement.
     * @param element WebElement to get text from.
     * @return Text content.
     * @throws RuntimeException if getting text fails.
     */
    String getText(WebElement element);

    /**
     * Get the attribute value from a WebElement.
     * @param element WebElement to get attribute from.
     * @param attribute Attribute name.
     * @return Attribute value.
     * @throws RuntimeException if getting attribute fails.
     */
    String getAttribute(WebElement element, String attribute);

    /**
     * Submit a form element.
     * @param element WebElement representing the form or submit button.
     * @throws RuntimeException if submission fails.
     */
    void submit(WebElement element);

    /**
     * Check if element is displayed.
     * @param element WebElement to check.
     * @return true if displayed, false otherwise.
     */
    boolean isDisplayed(WebElement element);

    /**
     * Check if element is enabled.
     * @param element WebElement to check.
     * @return true if enabled, false otherwise.
     */
    boolean isEnabled(WebElement element);

    /**
     * Check if element is selected (used for checkboxes, radio buttons, etc.).
     * @param element WebElement to check.
     * @return true if selected, false otherwise.
     */
    boolean isSelected(WebElement element);

    /**
     * Wait for element to be visible and return it.
     * @param element WebElement to wait for.
     * @return WebElement after visibility.
     * @throws RuntimeException if timeout or visibility issue occurs.
     */
    WebElement waitForVisibility(WebElement element);

    /**
     * Wait for element to become invisible.
     * @param element WebElement to wait for invisibility.
     * @throws RuntimeException if timeout occurs.
     */
    void waitForInvisibility(WebElement element);

    /**
     * Click an element after waiting for it to be clickable.
     * @param element WebElement to click.
     * @throws RuntimeException if timeout occurs or element not clickable.
     */
    void waitForClickability(WebElement element);

}
