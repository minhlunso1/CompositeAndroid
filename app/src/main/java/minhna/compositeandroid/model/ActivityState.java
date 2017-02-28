package minhna.compositeandroid.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 28-Feb-17.
 */

@IntDef({ActivityState.onCreate, ActivityState.onStart, ActivityState.onResume, ActivityState.onStop, ActivityState.onDestroy})
@Retention(RetentionPolicy.SOURCE)
public @interface ActivityState {
    int onCreate = 0;
    int onStart = 1;
    int onResume = 2;
    int onStop = 3;
    int onDestroy = 4;
}
