package com.desafiolatam.desafio_02_01_pregunta_dinamica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(int number,
                                           String category,
                                           String difficulty,
                                           String question,
                                           String correctAnswer,
                                           List<String> incorrectAnswers){

        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putInt("NUMBER", number);
        arguments.putString("CATEGORY", category);
        arguments.putString("DIFFICULTY", difficulty);
        arguments.putString("QUESTION", question);
        arguments.putString("CORRECT_ANSWER", correctAnswer);
        arguments.putStringArrayList("INCORRECT_ANSWERS", (ArrayList<String>) incorrectAnswers);

        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final int number = Objects.requireNonNull(getArguments().getInt("NUMBER"));
        final String category = Objects.requireNonNull(getArguments().getString("CATEGORY"));
        final String difficulty = Objects.requireNonNull(getArguments().getString("DIFFICULTY"));
        final String question = Objects.requireNonNull(getArguments().getString("QUESTION"));
        final String correctAnswer = Objects.requireNonNull(getArguments().getString("CORRECT_ANSWER"));
        final List<String> incorrectAnswers = Objects.requireNonNull(getArguments().getStringArrayList("INCORRECT_ANSWERSXA"));

        //TODO initializeViews

        return  null;
    }


}
