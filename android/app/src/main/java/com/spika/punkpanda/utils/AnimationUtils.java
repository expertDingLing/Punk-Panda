package com.spika.punkpanda.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

public class AnimationUtils {
    public static void tripleScale(View view, float f, float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f2, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleY", f, f2);
        ofFloat3.setStartDelay((long) i);
        ofFloat4.setStartDelay((long) i);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "scaleX", f2, f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "scaleY", f2, f);
        ofFloat5.setStartDelay((long) (i * 2));
        ofFloat6.setStartDelay((long) (i * 2));
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(view, "scaleY", f, f2);
        ofFloat7.setStartDelay((long) (i * 3));
        ofFloat8.setStartDelay((long) (i * 3));
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, "scaleX", f2, f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(view, "scaleY", f2, f);
        ofFloat9.setStartDelay((long) (i * 4));
        ofFloat10.setStartDelay((long) (i * 4));
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(view, "scaleY", f, f2);
        ofFloat11.setStartDelay((long) (i * 5));
        ofFloat12.setStartDelay((long) (i * 5));
        if (animatorListenerAdapter != null) {
            ofFloat11.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        ofFloat2.start();
        ofFloat3.start();
        ofFloat4.start();
        ofFloat5.start();
        ofFloat6.start();
        ofFloat7.start();
        ofFloat8.start();
        ofFloat9.start();
        ofFloat10.start();
        ofFloat11.start();
        ofFloat12.start();
    }

    public static void animateViewToOpenCollapse(boolean z, final View view, Context context) {
        if (z) {
            view.measure(-1, -2);
            final int measuredHeight = view.getMeasuredHeight();
            view.getLayoutParams().height = 1;
            view.setVisibility(View.VISIBLE);
            Animation r0 = new Animation() {
                public boolean willChangeBounds() {
                    return true;
                }

                /* access modifiers changed from: protected */
                public void applyTransformation(float f, Transformation transformation) {
                    view.getLayoutParams().height = f == 1.0f ? -2 : (int) (((float) measuredHeight) * f);
                    view.requestLayout();
                }
            };
            r0.setDuration((long) ((int) (((float) measuredHeight) / context.getResources().getDisplayMetrics().density)));
            view.startAnimation(r0);
            return;
        }
        final int measuredHeight2 = view.getMeasuredHeight();
        Animation r02 = new Animation() {
            public boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    view.setVisibility(View.GONE);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i = measuredHeight2;
                layoutParams.height = i - ((int) (((float) i) * f));
                view.requestLayout();
            }
        };
        r02.setDuration((long) ((int) (((float) measuredHeight2) / context.getResources().getDisplayMetrics().density)));
        view.startAnimation(r02);
    }

    public static ObjectAnimator translateX(View view, float f, float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f, f2);
        ofFloat.setDuration((long) i);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        return ofFloat;
    }

    public static ObjectAnimator translateX(View view, float f, float f2, int i, int i2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f, f2);
        ofFloat.setDuration((long) i);
        ofFloat.setStartDelay((long) i2);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        return ofFloat;
    }

    public static ObjectAnimator translateY(View view, float f, float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", f, f2);
        ofFloat.setDuration((long) i);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        return ofFloat;
    }

    public static ObjectAnimator fade(View view, float f, float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        ofFloat.setDuration((long) i);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        return ofFloat;
    }

    public static ObjectAnimator fade(View view, float f, float f2, int i, int i2, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        ofFloat.setDuration((long) i);
        ofFloat.setStartDelay((long) i2);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        return ofFloat;
    }

    public static ObjectAnimator fadeThenGoneOrVisible(View view, float f, float f2, int i) {
        return fadeThenGoneOrVisible(view, f, f2, i, (AnimatorListenerAdapter) null);
    }

    public static ObjectAnimator fadeThenGoneOrVisible(final View view, float f, final float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        if (f == 0.0f) {
            view.setVisibility(View.VISIBLE);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        ofFloat.setDuration((long) i);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f2 == 0.0f) {
                    view.setVisibility(View.GONE);
                }
            }
        });
        ofFloat.start();
        return ofFloat;
    }

    public static ObjectAnimator rotateX(View view, float f, float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", f, f2);
        ofFloat.setDuration((long) i);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        return ofFloat;
    }

    public static void scale(View view, float f, float f2, float f3, float f4, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        view.setPivotX(f3);
        view.setPivotY(f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f, f2);
        long j = (long) i;
        ofFloat.setDuration(j);
        ofFloat2.setDuration(j);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        ofFloat2.start();
    }

    public static void scale(View view, float f, float f2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f, f2);
        long j = (long) i;
        ofFloat.setDuration(j);
        ofFloat2.setDuration(j);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
        ofFloat2.start();
    }

    public static AnimatorSet fadingInfinite(View view, long j) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(j);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(j);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animatorSet.start();
            }
        });
        animatorSet.play(duration).before(duration2);
        animatorSet.start();
        return animatorSet;
    }

    public static void crossfadeViews(View view, final View view2, int i, final boolean z) {
        view.setAlpha(0.0f);
        view.setVisibility(View.VISIBLE);
        long j = (long) i;
        view.animate().alpha(1.0f).setDuration(j).setListener((Animator.AnimatorListener) null);
        view2.animate().alpha(0.0f).setDuration(j).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view2.setVisibility(z ? View.GONE : View.INVISIBLE);
            }
        });
    }

    public static void animateLeftMargin(final int i, final int i2, final View view, int i3) {
        Animation r0 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
//                int i = i;
//                int i2 = i2;
                layoutParams.leftMargin = (int) ((((float) (i - i2)) * f) + ((float) i2));
                view.setLayoutParams(layoutParams);
            }
        };
        r0.setDuration((long) i3);
        view.startAnimation(r0);
    }

    public static void animateRightMargin(final int i, final int i2, final View view, int i3) {
        Animation r0 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
//                int i = i;
//                int i2 = i2;
                layoutParams.rightMargin = (int) ((((float) (i - i2)) * f) + ((float) i2));
                view.setLayoutParams(layoutParams);
            }
        };
        r0.setDuration((long) i3);
        view.startAnimation(r0);
    }
}
