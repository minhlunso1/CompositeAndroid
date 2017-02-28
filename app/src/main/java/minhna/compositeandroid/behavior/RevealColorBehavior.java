package minhna.compositeandroid.behavior;

import android.app.Activity;

import java.lang.ref.WeakReference;

import minhna.compositeandroid.R;
import minhna.compositeandroid.model.ActivityBehaviour;
import minhna.compositeandroid.model.ActivityClass;
import minhna.compositeandroid.model.ActivityState;
import minhna.compositeandroid.view.MainActivity;

/**
 * Created by Administrator on 28-Feb-17.
 */

public class RevealColorBehavior implements ActivityBehaviour {

    private WeakReference<MainActivity> mainActivity;
    private @ActivityClass int activityClass;

    public RevealColorBehavior(Activity activity, @ActivityClass int activityClass) {
        this.activityClass = activityClass;
        switch (activityClass) {
            case ActivityClass.MAIN:
                this.mainActivity = new WeakReference<>((MainActivity) activity);
                break;
        }
    }

    @Override
    public void onActivityEvent(@ActivityState int activityState) {
        switch (activityState) {
            case ActivityState.onCreate:

                switch (activityClass) {
                    case ActivityClass.MAIN:
                        MainActivity activity = mainActivity.get();
                        if (activity != null)
                            activity.colorTag = activity.getString(R.string.color_resume);
                        break;
                }

                break;

            case ActivityState.onStart:

                switch (activityClass) {
                    case ActivityClass.MAIN:
                        MainActivity activity = mainActivity.get();
                        if (activity != null)
                            activity.colorTag = activity.getString(R.string.color_start);
                        break;
                }

                break;

            case ActivityState.onResume:

                switch (activityClass) {
                    case ActivityClass.MAIN:
                        MainActivity activity = mainActivity.get();
                        if (activity != null) {
                            if (activity.onStartDone)
                                activity.colorTag = activity.getString(R.string.color_resume);
                        }
                        break;
                }

                break;

            case ActivityState.onStop:

                switch (activityClass) {
                    case ActivityClass.MAIN:
                        MainActivity activity = mainActivity.get();
                        if (activity != null) {
                            if (activity.onResumeDone)
                                activity.colorTag = activity.getString(R.string.color_create);
                        }
                        break;
                }

                break;

            case ActivityState.onDestroy:
                break;

        }
    }

}
