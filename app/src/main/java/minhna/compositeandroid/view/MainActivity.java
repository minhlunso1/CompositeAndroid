package minhna.compositeandroid.view;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import minhna.compositeandroid.R;
import minhna.compositeandroid.behavior.RevealColorBehavior;
import minhna.compositeandroid.model.ActivityClass;

public class MainActivity extends CompositeActivity {

    public String colorTag;
    private Handler handler;
    public boolean onStartDone = false;
    public boolean onResumeDone = false;

    @BindView(R.id.reveal)
    RevealColorView revealColorView;
    @BindView(R.id.view_point)
    View viewPoint;

    public MainActivity() {
        addBehaviour(new RevealColorBehavior(this, ActivityClass.MAIN));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        handler = new Handler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPoint.setTag(colorTag);
                viewPoint.callOnClick();
                onStartDone=true;
                onResume();
            }
        }, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (onStartDone) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewPoint.setTag(colorTag);
                    viewPoint.callOnClick();
                    onResumeDone=true;
                    onStop();
                }
            }, 1000);
        }
    }

    @Override
    protected void onStop() {
        if (onResumeDone) {
            super.onStop();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewPoint.setTag(colorTag);
                    viewPoint.callOnClick();
                }
            }, 1000);
        }
    }

    private void revealColor() {
        final int color = getColor(viewPoint);
        final Point p = getLocationInView(revealColorView, viewPoint);
        revealColorView.reveal(p.x, p.y, color, viewPoint.getHeight() / 2, 340, null);
    }

    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    private int getColor(View view) {
        return Color.parseColor((String) view.getTag());
    }

    public void revealColor(View view) {
        revealColor();
    }
}
