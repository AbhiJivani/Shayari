package Adapter;

import android.annotation.SuppressLint;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayari.R;

import Activity.Edit_activity;

public class Gradient_colorAdapter extends BaseAdapter
{
    Edit_activity edit_activity;

    int color[];

    public Gradient_colorAdapter(Edit_activity edit_activity, int[] color) {
        this.edit_activity = edit_activity;
        this.color = color;
    }

    @Override
    public int getCount() {
        return color.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        view= LayoutInflater.from(edit_activity).inflate(R.layout.gradient_color_item,parent,false);
        TextView textView =view.findViewById(R.id.grad_color_item);
        textView.setBackgroundResource(color[position]);
        textView.setTextColor(color[position]);

        return view;
    }
}
