package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

public class RevenueCalculatorPage {
	private WebDriver driver;

	public RevenueCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='range']")
	private WebElement slider;

	@FindBy(css = ".MuiSlider-root")
	private WebElement sliderTrack;

	@FindBy(xpath = "//input[@id=':r0:']")
	private WebElement textBox;

	@FindBy(css = "p:nth-child(4) p:nth-child(1)")
	private WebElement TotalreimbursementElement;

	public void scrollToSlider() {
		Actions act = new Actions(driver);
		act.scrollToElement(textBox).perform();
	}

	public String adjustSliderToValue(int value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(slider));

		int sliderWidth = sliderTrack.getSize().getWidth();
		int currentValue = Integer.parseInt(slider.getAttribute("aria-valuenow"));
		int minValue = 0;
		int maxValue = 2000;

		int targetValue = value;
		int pixelOffset = (targetValue - currentValue) * sliderWidth / (maxValue - minValue);

		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, pixelOffset, 0).perform();

		return textBox.getAttribute("value");
	}

	public String updateTextFieldAndValidateSlider(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(textBox));

		Actions act = new Actions(driver);
		act.moveToElement(textBox).click().perform();
		for (int i = 0; i < 5; i++) {
			act.sendKeys(Keys.BACK_SPACE).perform(); // Clear text
		}

		act.sendKeys(value).perform();

		String updatedSliderValue = slider.getAttribute("aria-valuenow");

		return updatedSliderValue;
	}

	public void selectCPTCodes(String[] cptCodes) {
		for (String cptCode : cptCodes) {
			WebElement cptElement = driver.findElement(By.xpath("//p[text()='" + cptCode.trim() + "']"));
			List<WebElement> checkboxList = cptElement
					.findElements(By.xpath("./following::input[@type='checkbox'][1]"));

			if (!checkboxList.isEmpty()) {
				WebElement checkbox = checkboxList.get(0);
				if (!checkbox.isSelected()) {
					checkbox.click();
					System.out.println("Selected CPT code: " + cptCode);
				}
			}
		}
	}

	public void validateTotalRecurringReimbursement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(TotalreimbursementElement));

		String reimburseText = TotalreimbursementElement.getText().trim();

		if (!reimburseText.equals("$110700")) {
			throw new AssertionError("Expected value '$110700' but found " + reimburseText);
		}

		System.out.println("Total Recurring Reimbursement for all Patients Per Month: " + reimburseText);
	}
}
