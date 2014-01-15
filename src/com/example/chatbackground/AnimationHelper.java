
package com.example.chatbackground;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 *  [简要描述]:
 *  [详细描述]:
 *  @author [micker]
 *  @email  [goodluck.micker@gmail.com]
 *  @version    [版本号,Dec 19, 2013]
 *  @see        [DigestHelper]
 *  @package    [com.example.chatbackground]
 *  @since  [AnimationHelper]
 */
public final class AnimationHelper
{
    private static void animation(View paramView , Animation paramAnimation , long paramLong1 , long paramLong2)
    {
        paramAnimation.setDuration(paramLong1);
        paramAnimation.setStartOffset(paramLong2);
        paramView.setVisibility(0);
        paramView.startAnimation(paramAnimation);
    }

    public static void animationAlpha(View paramView)
    {
        animation(paramView, new AlphaAnimation(0.2F, 1.0F), 1000L, 0L);
    }

    public static void animationAlpha(View paramView , long paramLong , float paramFloat1 , float paramFloat2 , Animation.AnimationListener paramAnimationListener)
    {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
        localAlphaAnimation.setAnimationListener(paramAnimationListener);
        animation(paramView, localAlphaAnimation, 500L, paramLong);
    }

    public static void animationScale(View paramView)
    {
        animation(paramView, new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 2, 0.5F, 2, 0.5F), 1000L, 0L);
    }

    public static void animationScale(View paramView , long paramLong , Animation.AnimationListener paramAnimationListener)
    {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setAnimationListener(paramAnimationListener);
        animation(paramView, localScaleAnimation, paramLong, 0L);
    }

    public static void animationTranslate(View paramView)
    {
        animation(paramView, new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F), 500L, 0L);
    }

    public static void animation(View paramView)
    {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        AnimationSet localAnimationSet = new AnimationSet(false);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        animation(paramView, localAnimationSet, 1000L, 0L);
    }
}
