package com.desafiolatam.desafio_02_01_pregunta_dinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.desafiolatam.desafio_02_01_pregunta_dinamica.api.Api;
import com.desafiolatam.desafio_02_01_pregunta_dinamica.api.RetrofitClient;
import com.desafiolatam.desafio_02_01_pregunta_dinamica.pojos.Question;
import com.desafiolatam.desafio_02_01_pregunta_dinamica.pojos.QuestionList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<QuestionList> call = service.getQuestion();
        call.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();

                if(list != null){
                    Question question = list.getQuestionList().get(0);

                    MainFragment fragment = MainFragment.newInstance(
                            question.getCategory(),
                            question.getDifficulty(),
                            question.getQuestion(),
                            question.getCorrectAnswer(),
                            question.getIncorrectAnswers()
                    );

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container, fragment, "FRAGMENTO").commit();
                }
            }
            @Override
            public void onFailure(Call<QuestionList>call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: no pudimos recuperar los datos deopentdb", Toast.LENGTH_LONG).show();
            }
        });
    }


}
