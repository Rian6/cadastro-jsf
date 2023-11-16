package com.consulta.cnpj.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultApiRequest {
    public String get(String urlChamada) throws Exception {
        try {
            URL url = new URL(urlChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }
            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String json = converterJsonEmString(resposta);

            return json;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }

    private String converterJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
