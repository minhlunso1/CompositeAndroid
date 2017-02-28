package minhna.compositeandroid.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 28-Feb-17.
 */

@IntDef({ActivityClass.MAIN})
@Retention(RetentionPolicy.SOURCE)
public @interface ActivityClass {
    int MAIN = 0;
}
