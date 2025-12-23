
public class utilities {
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ReportManager {
	    private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	            extent = new ExtentReports();
	            extent.attachReporter(sparkReporter);
	        }
	        return extent;
	    }
	}
}
