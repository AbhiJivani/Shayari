package Activity;

import static Adapter.config.emojiArr;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayari.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import Adapter.Emoji_Adapter;
import Adapter.FontAdapter;
import Adapter.Gradient_Edit_Adapter;
import Adapter.Gradient_colorAdapter;
import Adapter.config;

public class Edit_activity extends AppCompatActivity implements View.OnClickListener {


    Gradient_Edit_Adapter adapter;
    TextView textView, bgd, textcolor, font, share, emoji, textsize;
    String temp1[];

    ImageView btn1, btn2;

    private int position;
    private int progress;
    private File downloadFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        textView = findViewById(R.id.txt1);
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        bgd = findViewById(R.id.b_g);
        font = findViewById(R.id.front);
        textcolor = findViewById(R.id.t_c);
        share = findViewById(R.id.share);
        emoji = findViewById(R.id.emoji);
        textsize = findViewById(R.id.t_s);


        position = getIntent().getIntExtra("pos", 0);
        temp1 = getIntent().getStringArrayExtra("temp1");
        textView.setText("" + emojiArr[position] + "\n" + temp1[position] + "\n" + emojiArr[position]);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        bgd.setOnClickListener(this);
        textcolor.setOnClickListener(this);
        font.setOnClickListener(this);
        share.setOnClickListener(this);
        emoji.setOnClickListener(this);
        textsize.setOnClickListener(this);
        //share.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn1.getId()) {
            BottomSheetDialog dialog = new BottomSheetDialog(Edit_activity.this);
            dialog.setContentView(R.layout.gradient_layout);
            dialog.findViewById(R.id.gridView_gradient);
            GridView gridView = dialog.findViewById(R.id.gridView_gradient);
            adapter = new Gradient_Edit_Adapter(Edit_activity.this, config.gradArr);
            gridView.setAdapter(adapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setBackgroundResource(config.gradArr[position]);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (v.getId() == btn2.getId()) {
            int min = 0, max = config.gradArr.length;
            int r = new Random().nextInt(max - min) + min;
            textView.setBackgroundResource(config.gradArr[r]);
        }
        if (v.getId() == bgd.getId()) {
            BottomSheetDialog dialog = new BottomSheetDialog(Edit_activity.this);
            dialog.setContentView(R.layout.gradient_color);
            dialog.findViewById(R.id.gradcolor);
            GridView gridview = dialog.findViewById(R.id.gradcolor);
            Gradient_colorAdapter adapter = new Gradient_colorAdapter(Edit_activity.this, config.color);
            gridview.setAdapter(adapter);

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setBackgroundResource(config.color[position]);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (v.getId() == textcolor.getId()) {
            BottomSheetDialog dialog = new BottomSheetDialog(Edit_activity.this);
            dialog.setContentView(R.layout.gradient_color);
            dialog.findViewById(R.id.gradcolor);
            GridView gridView = dialog.findViewById(R.id.gradcolor);
            Gradient_colorAdapter adapter = new Gradient_colorAdapter(Edit_activity.this, config.color);
            gridView.setAdapter(adapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setTextColor(getResources().getColor(config.color[position]));
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (v.getId() == font.getId()) {
            BottomSheetDialog dialog = new BottomSheetDialog(Edit_activity.this);
            dialog.setContentView(R.layout.font_layout);
            GridView listView = dialog.findViewById(R.id.fontlist);
            listView.setNumColumns(config.fontsArr.length);
            FontAdapter adapter = new FontAdapter(Edit_activity.this);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //textView.setText("ShayriApp");
                    Typeface typeface = null;
                    Typeface face = Typeface.createFromAsset(getAssets(), config.fontsArr[position]);
                    textView.setTypeface(face);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (v.getId() == emoji.getId()) {
            BottomSheetDialog dialog = new BottomSheetDialog(Edit_activity.this);
            dialog.setContentView(R.layout.emoji_layout);
            ListView listView = dialog.findViewById(R.id.emoji_list);
            Emoji_Adapter adapter = new Emoji_Adapter(Edit_activity.this, emojiArr);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    textView.setText("" + emojiArr[i] + "\n" + temp1[position] + "\n" + emojiArr[i]);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (v.getId() == textsize.getId()) {
            BottomSheetDialog dialog = new BottomSheetDialog(Edit_activity.this);
            dialog.setContentView(R.layout.font_size);
            SeekBar seekBar = dialog.findViewById(R.id.seekBar);
            seekBar.setProgress(progress);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if (progress == 0) {
                        //seekBar.setProgress(0);
                        textView.setTextSize(2, 30 + i);
                    } else {

                        textView.setTextSize(2, 30 + i);
                    }

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    //dialog.dismiss();
                    progress = seekBar.getProgress();
                }

            });
            dialog.show();
            seekBar.setActivated(true);
        }
        share.setOnClickListener(view -> {
            Bitmap icon = getBitmapFromView(textView);
            //Intent share = new Intent(Intent.ACTION_SEND);
            Intent share =new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int num=new Random().nextInt(2000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());

            downloadFile= new File(config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpeg");
            try
            {
                downloadFile.createNewFile();
                FileOutputStream fo = new FileOutputStream(downloadFile);
                fo.write(bytes.toByteArray());
                Toast.makeText(Edit_activity.this,"File Downloaded",Toast.LENGTH_LONG).show();
            }
            catch (IOException e)
            {
                Log.d("TTT", "onClick: "+e.getLocalizedMessage());
                e.printStackTrace();

            }

            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(downloadFile.getAbsolutePath()));
            startActivity(Intent.createChooser(share, "Share Image"));

        });
    }

    private Bitmap getBitmapFromView(TextView textView)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(textView.getWidth(), textView.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = textView.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        textView.draw(canvas);
        //return the bitmap
        return returnedBitmap;

    }
}



