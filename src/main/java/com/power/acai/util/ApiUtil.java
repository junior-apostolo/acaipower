package com.power.acai.util;

import java.util.Arrays;
import java.util.List;

public class ApiUtil {
    
    private ApiUtil() {
    }

    public static <T>Response<T> criarResponseDeErro(String erro) {
        return criaResponseErros(Arrays.asList(erro));
    }

    public static <T> Response<T> criarResponseDeErro(List<String> erros) {
        return criaResponseErros(erros);
    }

    private static <T> Response<T> criaResponseErros(List<String> erros) {
        Response<T> response = new Response<>();
        response.setErrors(erros);
        return response;
    }

    public static <T> Response<T> criaResponseBody(T t) {
        Response<T> response = new Response<>();
        response.setData(t);

        return response;
    }
}
