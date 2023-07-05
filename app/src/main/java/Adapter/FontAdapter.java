package Adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.shayari.R;

import Activity.Edit_activity;

public class FontAdapter extends BaseAdapter
{
    Edit_activity edit_activity;
    public FontAdapter(Edit_activity edit_activity) {
        this.edit_activity=edit_activity;
    }

    @Override
    public int getCount() {
        return config.fontsArr.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(edit_activity).inflate(R.layout.font_layout_item,parent,false);
        TextView textView=convertView.findViewById(R.id.fontName);
        Typeface face = Typeface.createFromAsset(edit_activity.getAssets(), config.fontsArr[position]);
        textView.setTypeface(face);
        return convertView;
    }
}
