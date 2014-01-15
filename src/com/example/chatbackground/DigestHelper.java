/*
 * [文 件 名]:DigestHelper.java
 * [创 建 人]:allenwang
 * [创建时间]:Dec 19, 2013
 * [编　　码]:UTF-8
 * [版　　权]:Copyright © 2012 B5Msoft Co,Ltd. 
*/

package com.example.chatbackground;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 *	[简要描述]:
 *	[详细描述]:
 *	@author	[micker]
 *	@email	[goodluck.micker@gmail.com]
 *	@version	[版本号,Dec 19, 2013]
 *	@see		[DigestHelper]
 *	@package	[com.example.chatbackground]
 *	@since	[DigestHelper]
 */
public class DigestHelper
{
    public static int height(Context paramContext)
    {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        if (!(paramContext instanceof Activity))
            return paramContext.getResources().getDisplayMetrics().heightPixels;
        WindowManager localWindowManager = ((Activity) paramContext).getWindowManager();
        if (localWindowManager == null)
            return paramContext.getResources().getDisplayMetrics().heightPixels;
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.heightPixels;
    }

    public static int statesheight(Context paramContext)
    {
        try
        {
            Class<?> localClass = Class.forName("com.android.internal.R$dimen");
            Object localObject = localClass.newInstance();
            int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
            int j = paramContext.getResources().getDimensionPixelSize(i);
            return j;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return 0;
    }
}
