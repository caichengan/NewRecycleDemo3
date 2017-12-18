package com.diandianguanjia.newrecycledemo3.view;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by an on 2017/8/1.
 */

public class FootBehavior extends CoordinatorLayout.Behavior<View> {

    private int directionChange;
    FootBehavior(Context mContext, AttributeSet attrs){
        super(mContext,attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {

        return (nestedScrollAxes & View.SCROLL_AXIS_VERTICAL)!=0;
    }


    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {

        if (dy>0 && directionChange<0 ||dy<0 && directionChange>0){
            child.animate().cancel();
            directionChange=0;
        }

        directionChange +=dy;
        if (directionChange>child.getHeight() && child.getVisibility()==View.VISIBLE){
            hide(child);
        }else if(directionChange<0 && child.getVisibility()==View.GONE){
            show(child);
        }

        //super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }

    private void hide(final View child) {

        ViewPropertyAnimator animator=child.animate().translationY(child.getHeight()).setInterpolator(new FastOutSlowInInterpolator()).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                child.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }


        });

        animator.start();
    }

    private void show(final View child) {
        ViewPropertyAnimator animator=child.animate().translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator()).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                child.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animator.start();
    }


}
