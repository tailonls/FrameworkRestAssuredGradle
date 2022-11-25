package br.com.features;

import br.com.core.BaseFeature;
import br.com.core.ReportGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;


@Slf4j
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyFeature extends BaseFeature {

    @Value("${url}")
    private String url;

    @Autowired
    ReportGenerator reportGenerator;

    private JSONObject algoBody;
    private static Response response;


    public boolean isMyBodybuiltWithSucess() {
        try {
            algoBody = new JSONObject()
                    .put("name", "Dalton")
                    .put("age", 30)
                    .put("salary", 4000.0);

            reportGenerator.logInfo("Body montado com sucesso!");
            reportGenerator.logJson(algoBody.toString());
            return true;

        } catch (Exception e) {
            reportGenerator.logFail("Erro montar body: " + e.getMessage());
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public boolean isMyComplexBodybuiltWithSucess() {
        try {
            algoBody = new JSONObject()
                    .put("algo", "algotmb")
                    .put("algo2", "algotmb2")

                    .put("meuObjeto", new JSONObject()
                            .put("algoNoObjeto", "algotmb"))

                    .put("minhaArray", new JSONArray()
                            .put(new JSONObject()
                                    .put("algoNaArray", "algoNaArray")
                                    .put("algoNaArray2", "algoNaArray2")
                            )
                            .put(new JSONObject()
                                    .put("algoNaArray", "algoNaArray")
                                    .put("algoNaArray2", "algoNaArray2")));

            reportGenerator.logInfo("Body criado com sucesso!");
            reportGenerator.logJson(algoBody.toString());
            return true;

        } catch (Exception e) {
            reportGenerator.logFail("Erro montar body: " + e.getMessage());
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public boolean isRequestSendWithSuccess() {
        try {
            response = given()
                    .log().all()
                    .header("Algo", "algo")
                    .header("Accept-Language", "algo")
                    .body(algoBody.toString())
                    .contentType(ContentType.JSON)
                    .when()
                    .post(url)
                    .then().log().all().extract().response();

            reportGenerator.logPass("Request enviada com sucesso:");
            reportGenerator.logLabel("POST: " + url);
            return true;

        } catch (Exception e) {
            reportGenerator.logFail("Erro ao enviar request: " + e.getMessage());
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public boolean isStatusRequestEqualTo(int status) {
        try {
            if (response.statusCode() == status) {
                reportGenerator.logPass("Request retornou com status esperado: " + status);
                return true;
            }
            reportGenerator.logFail("Request retornou com status diferente do esperado: " + status);

        } catch (Exception e) {
            reportGenerator.logFail("Erro ao validar status da request: " + e.getMessage());
            log.error(e.getMessage(), e);
        }
        return false;
    }
}