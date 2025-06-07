package com.hybridframework.utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridframework.base.DriverManager;
import com.selenium.design.Browser;
import com.selenium.design.Elements;

public class BaseUtil implements Browser,Elements{
	
	private WebDriver driver() {
	    return DriverManager.getDriver();
	}
	
	public static final int PAGE_LOAD_TIME=5;

	// Switch to a window by title
	public void switchToWindow(String windowTitle) {
	    try {
	        Set<String> handles = driver().getWindowHandles();
	        for (String handle : handles) {
	            driver().switchTo().window(handle);
	            if (driver().getTitle().equals(windowTitle)) {
	                return;
	            }
	        }
	        throw new NoSuchWindowException("No window with title: " + windowTitle);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to switch to window with title: " + windowTitle, e);
	    }
	}
	
	public void switchToNextWindow() {
	    try {
	        String currentHandle = driver().getWindowHandle();
	        Set<String> allHandles = driver().getWindowHandles();

	        for (String handle : allHandles) {
	            if (!handle.equals(currentHandle)) {
	                driver().switchTo().window(handle);
	                return;
	            }
	        }

	        throw new NoSuchWindowException("No new window found to switch to.");
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to switch to the next window", e);
	    }
	}


	// Switch to a window by handle
	public void switchToWindowByHandle(String handle) {
	    try {
	        Set<String> handles = driver().getWindowHandles();
	        if (handles.contains(handle)) {
	            driver().switchTo().window(handle);
	        } else {
	            throw new NoSuchWindowException("Window handle not found: " + handle);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to switch to window with handle: " + handle, e);
	    }
	}

	// Get current window handle
	public String getCurrentWindowHandle() {
	    try {
	        return driver().getWindowHandle();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to get current window handle", e);
	    }
	}

	// Alert operations
	public void acceptAlert() {
	    try {
	        driver().switchTo().alert().accept();
	    } catch (NoAlertPresentException e) {
	        throw new RuntimeException("No alert present to accept", e);
	    }
	}

	public void dismissAlert() {
	    try {
	        driver().switchTo().alert().dismiss();
	    } catch (NoAlertPresentException e) {
	        throw new RuntimeException("No alert present to dismiss", e);
	    }
	}

	public String getAlertText() {
	    try {
	        return driver().switchTo().alert().getText();
	    } catch (NoAlertPresentException e) {
	        throw new RuntimeException("No alert present to get text from", e);
	    }
	}

	// Frame operations
	public void switchToFrame(By frameLocator) {
	    try {
	        WebElement frame = driver().findElement(frameLocator);
	        driver().switchTo().frame(frame);
	    } catch (NoSuchFrameException | NoSuchElementException e) {
	        throw new RuntimeException("Failed to switch to frame: " + frameLocator, e);
	    }
	}

	public void switchToDefaultContent() {
	    try {
	        driver().switchTo().defaultContent();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to switch to default content", e);
	    }
	}

	// Page info
	public String getPageTitle() {
	    try {
	        return driver().getTitle();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to get page title", e);
	    }
	}

	public String getCurrentUrl() {
	    try {
	        return driver().getCurrentUrl();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to get current URL", e);
	    }
	}

	// Navigation
	public void refreshPage() {
	    try {
	        driver().navigate().refresh();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to refresh the page", e);
	    }
	}

	public void navigateBack() {
	    try {
	        driver().navigate().back();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to navigate back", e);
	    }
	}

	public void navigateForward() {
	    try {
	        driver().navigate().forward();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to navigate forward", e);
	    }
	}

	    @Override
	    public void click(WebElement element) {
	        try {
	            waitForClickability(element);
	            element.click();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to click on element: " + element, e);
	        }
	    }

	    @Override
	    public void sendKeys(WebElement element, String text) {
	        try {
	            WebElement visibleElement = waitForVisibility(element);
	            visibleElement.clear();
	            visibleElement.sendKeys(text);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to send keys to element: " + element, e);
	        }
	    }

	    @Override
	    public String getText(WebElement element) {
	        try {
	            return waitForVisibility(element).getText();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to get text from element: " + element, e);
	        }
	    }

	    @Override
	    public String getAttribute(WebElement element, String attribute) {
	        try {
	            return element.getDomAttribute(attribute);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to get attribute [" + attribute + "] from element: " + element, e);
	        }
	    }

	    @Override
	    public void submit(WebElement element) {
	        try {
	            waitForVisibility(element).submit();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to submit element: " + element, e);
	        }
	    }

	    @Override
	    public boolean isDisplayed(WebElement element) {
	        try {
	            return waitForVisibility(element).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    @Override
	    public boolean isEnabled(WebElement element) {
	        try {
	            return waitForVisibility(element).isEnabled();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    @Override
	    public boolean isSelected(WebElement element) {
	        try {
	            return waitForVisibility(element).isSelected();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    @Override
	    public WebElement waitForVisibility(WebElement element) {
	        try {
	            return new WebDriverWait(driver(), Duration.ofSeconds(10))
	                    .until(ExpectedConditions.visibilityOf(element));
	        } catch (TimeoutException e) {
	            throw new RuntimeException("Timeout: Element not visible: " + element, e);
	        }
	    }

	    @Override
	    public void waitForInvisibility(WebElement element) {
	        try {
	            new WebDriverWait(driver(), Duration.ofSeconds(10))
	                    .until(ExpectedConditions.invisibilityOf(element));
	        } catch (TimeoutException e) {
	            throw new RuntimeException("Timeout: Element did not become invisible: " + element, e);
	        }
	    }

	    @Override
	    public void waitForClickability(WebElement element) {
	        try {
	            new WebDriverWait(driver(), Duration.ofSeconds(10))
	                    .until(ExpectedConditions.elementToBeClickable(element));
	        } catch (TimeoutException e) {
	            throw new RuntimeException("Timeout: Element not clickable: " + element, e);
	        }
	    }
	   

}
