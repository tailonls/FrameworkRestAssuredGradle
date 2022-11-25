package br.com.steps;

import br.com.features.MyFeature;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class MyFeatureStep {

    @Autowired
    MyFeature myFeature;

    @Dado("que monto um body para a minha requisição")
    public void queMontoUmBodyParaAMinhaRequisicao() {
        Assert.assertTrue(myFeature.isMyBodybuiltWithSucess());
    }

    @Quando("realizo o request para o endpoint")
    public void realizoORequestParaOEndpoint() {
        Assert.assertTrue(myFeature.isRequestSendWithSuccess());
    }

    @Entao("o status do retorno deve ser {int}")
    public void oStatusDoRetornoDeveSer(int status) {
        Assert.assertTrue(myFeature.isStatusRequestEqualTo(status));
    }
}
