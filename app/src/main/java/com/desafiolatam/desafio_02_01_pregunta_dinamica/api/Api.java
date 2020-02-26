package com.desafiolatam.desafio_02_01_pregunta_dinamica.api;

import com.desafiolatam.desafio_02_01_pregunta_dinamica.pojos.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<QuestionList> getQuestion();
}
