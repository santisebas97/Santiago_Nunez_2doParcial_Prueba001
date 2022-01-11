package com.aperez.apps.eventhandlers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.widget.Toast;

import com.aperez.apps.androidfunwithflags.NUNEZ_MainActivity;
import com.aperez.apps.androidfunwithflags.R;

import java.util.Set;

public class PreferenceChangeListener implements OnSharedPreferenceChangeListener {
    private NUNEZ_MainActivity NUNEZMainActivity;

    public PreferenceChangeListener(NUNEZ_MainActivity NUNEZMainActivity) {
        this.NUNEZMainActivity = NUNEZMainActivity;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.NUNEZMainActivity.setPreferencesChanged(true);

        if (key.equals(this.NUNEZMainActivity.getREGIONS())) {
            this.NUNEZMainActivity.getQuizViewModel().setGuessRows(sharedPreferences.getString(
                    NUNEZ_MainActivity.CHOICES, null));
            this.NUNEZMainActivity.getQuizFragment().resetQuiz();
        } else if (key.equals(this.NUNEZMainActivity.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.NUNEZMainActivity.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.NUNEZMainActivity.getQuizViewModel().setRegionsSet(regions);
                this.NUNEZMainActivity.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.NUNEZMainActivity.getString(R.string.default_region));
                editor.putStringSet(this.NUNEZMainActivity.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.NUNEZMainActivity, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.NUNEZMainActivity, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
