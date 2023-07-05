package Adapter;

import android.os.Environment;

import com.example.shayari.R;

import java.io.File;

public class config
{
    public static int gradArr[]={R.drawable.bg_gradient,R.drawable.bg_gradient1,R.drawable.bg_gradient2,
            R.drawable.bg_gradient3,R.drawable.bg_gradient4,
            R.drawable.bg_gradient5,R.drawable.bg_gradient6,
            R.drawable.bg_gradient7,R.drawable.bg_gradient8,
            R.drawable.bg_gradient9};

    public static int color[]={R.color.color1,R.color.color2,R.color.color3,R.color.color4,
            R.color.color5,R.color.color6,R.color.color7,R.color.color8,R.color.color9,R.color.color10
            ,R.color.color11,R.color.color12,R.color.color13,R.color.color14,R.color.color15,R.color.color16
            ,R.color.color17,R.color.color18,R.color.color19,R.color.color20,R.color.color21,R.color.color22
            ,R.color.color23,R.color.color24};
    public static String[] fontsArr={"ARLRDBD.TTF","BRITANIC.TTF","cour.ttf","BRUSHSCI.TTF","FRSCRIPT.TTF","ITCEDSCR.TTF","JOKERMAN.TTF",};

   public static String[] emojiArr={"😀😁😂🤣😃😄","😋😊😉😆😅😍","😘🥰😗😙🥲🤔","🤩🤗🙂☺😚🤨","😐😑😶😶‍🌫🙄","😯🤐😮😥😣😏","❣💕💞💓💗💖","❤🧡💛💚💙💜"};
   public static File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
}
