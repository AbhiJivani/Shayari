package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayari.R;

import Activity.Edit_activity;

public class Gradient_Edit_Adapter extends BaseAdapter
{
    Edit_activity edit_activity;
    int gradArr[];
    public Gradient_Edit_Adapter(Edit_activity edit_activity, int[] gradArr) {
        this.edit_activity = edit_activity;
        this.gradArr = gradArr;
    }

    @Override
    public int getCount() {
        return gradArr.length;
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
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        view= LayoutInflater.from(edit_activity).inflate(R.layout.gradient_layout_item,viewGroup,false);
        TextView textView=view.findViewById(R.id.txtGrad);
        textView.setBackgroundResource(gradArr[position]);
        return view;
    }
}
