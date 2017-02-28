package minhna.compositeandroid.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import minhna.compositeandroid.model.ActivityBehaviour;
import minhna.compositeandroid.model.ActivityState;

/**
 * Created by Administrator on 28-Feb-17.
 */

public class CompositeActivity extends AppCompatActivity {

    private final ArrayList<ActivityBehaviour> behaviours = new ArrayList<>();

    @Override
    @CallSuper
    protected void onCreate(@Nullable  Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        for (ActivityBehaviour activityBehaviour : behaviours) {
            activityBehaviour.onActivityEvent(ActivityState.onCreate);
        }
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        for (ActivityBehaviour activityBehaviour : behaviours) {
            activityBehaviour.onActivityEvent(ActivityState.onStart);
        }
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        for (ActivityBehaviour activityBehaviour : behaviours) {
            activityBehaviour.onActivityEvent(ActivityState.onResume);
        }
    }

    @Override
    @CallSuper
    protected void onStop() {
        for (ActivityBehaviour activityBehaviour : behaviours) {
            activityBehaviour.onActivityEvent(ActivityState.onStop);
        }
        removeBehaviors();
        super.onStop();
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        for (ActivityBehaviour activityBehaviour : behaviours) {
            activityBehaviour.onActivityEvent(ActivityState.onDestroy);
        }
        removeBehaviors();
        super.onDestroy();
    }

    protected void addBehaviour(ActivityBehaviour activityBehaviour) {
        behaviours.add(activityBehaviour);
    }

    protected void removeBehaviors() {
        behaviours.clear();
    }

}
