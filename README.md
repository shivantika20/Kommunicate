# Kommunicate

Scenorios that are Automated:
1. Open the website "https://test.kommunicate.io/"
2. Click on the chat icon which is shown on the bottom right corner
3. Then click on the FAQ icon
4. Count the FAQs listed.
5. If FAQ count < 20, trigger a mail to yourself with the actual FAQ count.
If there are any errors which come in any of the above steps, then the mail must mention which step failed. (For this please change the xpath of chat or faq and run,
the email will be triggered)

Selenium installation process:

1.Install Java SDK
2.Install IntelliJidea
3.Install Selenium Driver Files
4.Configure Eclipse IDE with WebDriver
5. Add External JARs.
6. Download the driver for chrome use : ChromeDriver

Jars Required:
1. guava-21.0
2. jcommander-1.78
3. json-path4
4. selenium-java-2.42
5. Selenium Webdriver libraries - Libraries which allows you use all the Selenium functions and classes

Running the testcases:
Once all these are configured, run the main program.

In the java class four imports are required
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

PRE-REQUISITES:
Please add you email, password and recievers email.
