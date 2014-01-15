
package com.example.chatbackground;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 *  [简要描述]:
 *  [详细描述]:
 *  @author [micker]
 *  @email  [goodluck.micker@gmail.com]
 *  @version    [版本号,Dec 19, 2013]
 *  @see        [DigestHelper]
 *  @package    [com.example.chatbackground]
 *  @since  [MainActivity]
 */
public class MainActivity extends Activity implements OnClickListener
{
    private LinearLayout resizeLayout;
    private ImageView backgroundImageView;
    private Button backgroundButton;
    private EditText editText;
    public int paremItemsss;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resizeLayout = (LinearLayout) findViewById(R.id.rootLayout);
        backgroundImageView = (ImageView) findViewById(R.id.backgroundImageView);
        backgroundButton = (Button) findViewById(R.id.backgroundButton);
        editText = (EditText) findViewById(R.id.editContent);
        resetLayout();
        onClick(null);
    }

    private void resetLayout()
    {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) this.backgroundImageView.getLayoutParams();
        localLayoutParams.height = (DigestHelper.height(this) - DigestHelper.statesheight(this) - this.backgroundButton.getMeasuredHeight() - this.editText.getMeasuredHeight());
        this.backgroundImageView.setLayoutParams(localLayoutParams);
        backgroundButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        paremItemsss = flag ? R.drawable.group_room_default_bg1 : R.drawable.group_room_default_bg;
        setBackgroundResource(paremItemsss);
        flag = !flag;
    }

    private void setBackgroundResource(int paramInt)
    {
        if (this.backgroundImageView.getBackground() != null)
        {
            AnimationHelper.animationAlpha(this.backgroundImageView, 100, 0.9f, 0.2f, animationListener);
            return;
        }
        this.backgroundImageView.setBackgroundResource(paramInt);
        this.backgroundImageView.getBackground().setAlpha(200);
    }
    private AnimationListener animationListener = new AnimationListener()
    {
        @Override
        public void onAnimationStart(Animation animation)
        {
        }

        @Override
        public void onAnimationRepeat(Animation animation)
        {
        }

        @Override
        public void onAnimationEnd(Animation animation)
        {
            backgroundImageView.setBackgroundResource(paremItemsss);
            backgroundImageView.getBackground().setAlpha(200);
            AnimationHelper.animationAlpha(backgroundImageView, 0, 0.2f, 0.9f, null);
        }
    };
}
