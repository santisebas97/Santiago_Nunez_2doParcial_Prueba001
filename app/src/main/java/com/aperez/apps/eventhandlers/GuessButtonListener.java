package com.aperez.apps.eventhandlers;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.aperez.apps.androidfunwithflags.NUNEZ_MainActivityFragment;
import com.aperez.apps.androidfunwithflags.R;
import com.aperez.apps.androidfunwithflags.NUNEZ_ResultsDialogFragment;
import com.aperez.apps.lifecyclehelpers.QuizViewModel;

public class GuessButtonListener implements OnClickListener {
    private NUNEZ_MainActivityFragment NUNEZMainActivityFragment;
    private Handler handler;

    public GuessButtonListener(NUNEZ_MainActivityFragment NUNEZMainActivityFragment) {
        this.NUNEZMainActivityFragment = NUNEZMainActivityFragment;
        this.handler = new Handler();
    }

    @Override
    public void onClick(View v) {
        Button guessButton = ((Button) v);
        String guess = guessButton.getText().toString();
        String answer = this.NUNEZMainActivityFragment.getQuizViewModel().getCorrectCountryName();
        this.NUNEZMainActivityFragment.getQuizViewModel().setTotalGuesses(1);

        if (guess.equals(answer)) {
            this.NUNEZMainActivityFragment.getQuizViewModel().setCorrectAnswers(1);
            this.NUNEZMainActivityFragment.getAnswerTextView().setText(answer + "!");
            this.NUNEZMainActivityFragment.getAnswerTextView().setTextColor(
                    this.NUNEZMainActivityFragment.getResources().getColor(R.color.correct_answer));

            this.NUNEZMainActivityFragment.disableButtons();

            if (this.NUNEZMainActivityFragment.getQuizViewModel().getCorrectAnswers()
                    == QuizViewModel.getFlagsInQuiz()) {
                NUNEZ_ResultsDialogFragment quizResults = new NUNEZ_ResultsDialogFragment();
                quizResults.setCancelable(false);
                try {
                    quizResults.show(this.NUNEZMainActivityFragment.getChildFragmentManager(), "Quiz Results");
                } catch (NullPointerException e) {
                    Log.e(QuizViewModel.getTag(),
                            "GuessButtonListener: this.NUNEZMainActivityFragment.getFragmentManager() " +
                                    "returned null",
                            e);
                }
            } else {
                this.handler.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                NUNEZMainActivityFragment.animate(true);
                            }
                        }, 2000);
            }
        } else {
            this.NUNEZMainActivityFragment.incorrectAnswerAnimation();
            guessButton.setEnabled(false);
        }
    }
}
