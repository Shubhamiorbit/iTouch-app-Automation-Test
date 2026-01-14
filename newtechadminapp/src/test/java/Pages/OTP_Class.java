package Pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTP_Class {
//	String otp;
//	String otp1;
//	WebDriver driver2;
//	public void OTPfrommailinatorpublic() throws InterruptedException 
//	{
//	driver2 = new ChromeDriver();
//	WebDriverWait wait = new WebDriverWait(driver2,Duration.ofSeconds(10));
//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"inbox-link\"]")));
//	element.click();
////	driver2.findElement(By.xpath("//a[@class=\"inbox-link\"]")).click();
//	driver2.findElement(By.id("inbox_field")).sendKeys("ethix");
//	driver2.findElement(By.className("primary-btn")).click();
//	Thread.sleep(3000);
//	driver2.findElement(By.xpath("(//*[contains(text(),'2-factor authentication Email')])[1]")).click();
//	Thread.sleep(2000);
//	try {
//		WebElement iframeElement = driver2.findElement(By.xpath("html/body/div/main/div/div/div[3]/div/div[2]/iframe"));
//		driver2.switchTo().frame(iframeElement);
//		WebElement otpElement = driver2.findElement(By.xpath("//body[contains(text(), 'OTP')]"));
//		String otpText = otpElement.getText();
//
//       
//        Pattern pattern = Pattern.compile("\\d{6}");
//        Matcher matcher = pattern.matcher(otpText);
//
//        if (matcher.find()) {
//             otp = matcher.group(0);
//            System.out.println("Extracted OTP: " + otp);
//        } else {
//            System.out.println("OTP not found in the email.");
//        }
//
//    }  catch (NoSuchElementException n) {
//        System.out.println("Email containing OTP not found.");
//    } 
//	
//	System.out.println("Stored OTP: " + otp);
//	driver2.close();
//	  otp1 = otp;
//
//		driver2.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")).sendKeys(otp1.substring(0, 1));
//		driver2.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys(otp1.substring(1, 2));
//		driver2.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")).sendKeys(otp1.substring(2, 3));
//		driver2.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")).sendKeys(otp1.substring(3, 4));
//		driver2.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[5]")).sendKeys(otp1.substring(4, 5));
//		driver2.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[6]")).sendKeys(otp1.substring(5, 6));
//		Thread.sleep(2000);
//		driver2.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Submit\"]")).click();
//}

    private static final String API_TOKEN = "3160d94b60c0474f8db4ffb88beedbf4";
    private static final String DOMAIN = "private";
    private static final OkHttpClient client = new OkHttpClient();

    //it will wait 20 seconds for getting the latest OTP
    public static String fetchLatestOTP() throws Exception {
        String inboxName = "automation1";
        long latestSeenTime = 0;
        String otp = null;

        // Step 1: Get current latest message time (before requesting OTP)
        JSONArray initialMessages = getInboxMessages(inboxName);
        if (initialMessages != null && initialMessages.length() > 0) {
            JSONObject latestMsg = initialMessages.getJSONObject(0);
            latestSeenTime = latestMsg.optLong("time", 0);
        }

        System.out.println("Initial message timestamp: " + latestSeenTime);

        int totalWaitTime = 20000;
        int pollInterval = 2000;
        int attempts = totalWaitTime / pollInterval;

        for (int i = 1; i <= attempts; i++) {
            JSONArray messages = getInboxMessages(inboxName);

            if (messages != null && messages.length() > 0) {
                JSONObject newestMsg = messages.getJSONObject(0);
                long msgTime = newestMsg.optLong("time", 0);
                String msgId = newestMsg.getString("id");

                // Step 3: Only process if new message arrived after starting
                if (msgTime > latestSeenTime) {
                    String body = getMessageBody(msgId);

                    if (body != null && body.toLowerCase().contains("otp")) {
                        otp = extractOTP(body);
                        if (otp != null) {
                            System.out.println("Latest OTP fetched: " + otp);
                            return otp;
                        }
                    }
                }
            }

            System.out.println("Waiting for new OTP email... (" + i + ")");
            Thread.sleep(pollInterval);
        }

        throw new Exception("No new OTP email arrived within 20 seconds.");
    }

    // --- Fetch inbox messages ---
    private static JSONArray getInboxMessages(String inboxName) throws IOException {
        String url = "https://api.mailinator.com/api/v2/domains/" + DOMAIN + "/inboxes/" 
                   + inboxName + "?token=" + API_TOKEN;
        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) return null;

            String resp = response.body().string();
            if (!resp.trim().startsWith("{")) return null;

            JSONObject json = new JSONObject(resp);
            return json.optJSONArray("msgs");
        }
    }

    // --- Fetch message body ---
    private static String getMessageBody(String messageId) throws IOException {
        String url = "https://api.mailinator.com/api/v2/domains/" + DOMAIN + "/messages/" 
                   + messageId + "?token=" + API_TOKEN;
        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) return null;

            String resp = response.body().string();
            if (!resp.trim().startsWith("{")) return null;

            JSONObject json = new JSONObject(resp);

            if (json.has("body")) return json.getString("body");

            if (json.has("parts")) {
                JSONArray parts = json.getJSONArray("parts");
                for (int i = 0; i < parts.length(); i++) {
                    JSONObject part = parts.getJSONObject(i);
                    if (part.has("body")) return part.getString("body");
                }
            }

            return null;
        }
    }

    // --- Extract OTP ---
    private static String extractOTP(String body) {
        if (body == null || body.isEmpty()) return null;

        // Clean HTML but keep line breaks
        body = body.replaceAll("<br\\s*/?>", "\n")
                   .replaceAll("<[^>]+>", "")
                   .replaceAll("&nbsp;", " ")
                   .trim();

        // Split into lines and find line with OTP
        String[] lines = body.split("\\r?\\n");
        for (String line : lines) {
            if (line.toLowerCase().contains("otp")) {
                Matcher matcher = Pattern.compile("\\b(\\d{6})\\b").matcher(line);
                if (matcher.find()) return matcher.group(1);
            }
        }

        // Fallback: any 6-digit number
        Matcher matcher = Pattern.compile("\\b(\\d{6})\\b").matcher(body);
        return matcher.find() ? matcher.group(1) : null;
    }
}
