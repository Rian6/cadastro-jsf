package com.integracao.cnpj.api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
        } catch (IOException | RuntimeException e) {
            throw new Exception("ERRO: " + e);
        }
    }

    public String post(String urlChamada, Object postData) throws Exception {
        try {
            Gson gson = new Gson();
            URL url = new URL(urlChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true);

            String jsonData = gson.toJson(postData);

            try (OutputStream os = conexao.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (conexao.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }

            try (BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
                return converterJsonEmString(resposta);
            }

        } catch (IOException | RuntimeException e) {
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
