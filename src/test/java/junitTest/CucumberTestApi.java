package junitTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        plugin = {"pretty", "html:reports/cucumber-api.html", "json:reports/cucumber-api.json"},
        glue = {"stepdef/api"},
        tags = "@api"
)
public class CucumberTestApi {
    @AfterClass
    public static void addGitHubActionsLink() {
        try {
            // Ambil URL dari environment variables GitHub Actions
            String githubRunUrl = System.getenv("GITHUB_SERVER_URL") + "/" +
                    System.getenv("GITHUB_REPOSITORY") + "/actions/runs/" +
                    System.getenv("GITHUB_RUN_ID");

            // Validasi environment variables
            if (githubRunUrl.contains("null")) {
                System.err.println("Environment variables untuk GitHub Actions tidak ditemukan. Pastikan Anda menjalankan ini di GitHub Actions.");
                return;
            }

            // Periksa apakah file laporan HTML ada
            if (Files.exists(Paths.get("reports/cucumber-api.html"))) {
                // Tambahkan tautan ke laporan HTML
                String reportFooter = "<p>Test executed from GitHub Actions: <a href='" + githubRunUrl + "'>" + githubRunUrl + "</a></p>";
                Files.write(Paths.get("reports/cucumber-api.html"), reportFooter.getBytes(), StandardOpenOption.APPEND);
            } else {
                System.err.println("Laporan HTML tidak ditemukan. Pastikan laporan dibuat sebelum menambahkan tautan.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
