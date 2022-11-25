package br.com.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Objects;

@Slf4j
@Configuration
public class ReportGenerator {

    private final File reports;
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private ExtentSparkReporter extentSparkReporter;

    public ReportGenerator(@Value("${report.path}") String reportPath,
                           @Value("${report.name}") String reportName) {

        reports = new File(reportPath);

        if (extentSparkReporter == null && extentReports == null) {
            reports.mkdir();

            extentSparkReporter = new ExtentSparkReporter(reportPath + reportName);
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
    }

    public void addScenarioInReport(Scenario scenario) {
        log.debug("add scenario - {}", scenario.getName());
        if (Objects.nonNull(extentSparkReporter) && Objects.nonNull(extentReports)) {
            extentTest = extentReports.createTest(scenario.getName());
            refreshReport();
        }
    }

    public void refreshReport() {
        extentReports.flush();
    }

    public void logPass(String log) {
        if (Objects.nonNull(extentSparkReporter) && Objects.nonNull(extentReports)) {
            extentTest.pass(log);
            refreshReport();
        }
    }

    public void logFail(String log) {
        if (Objects.nonNull(extentSparkReporter) && Objects.nonNull(extentReports)) {
            extentTest.fail(log);
            refreshReport();
        }
    }

    public void logInfo(String log) {
        if (Objects.nonNull(extentSparkReporter) && Objects.nonNull(extentReports)) {
            extentTest.info(log);
            refreshReport();
        }
    }

    public void logJson(String json) {
        if (Objects.nonNull(extentSparkReporter) && Objects.nonNull(extentReports)) {
            extentTest.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
            refreshReport();
        }
    }

    public void logLabel(String label) {
        if (Objects.nonNull(extentSparkReporter) && Objects.nonNull(extentReports)) {
            extentTest.info(MarkupHelper.createLabel(label, ExtentColor.ORANGE));
            refreshReport();
        }
    }
}