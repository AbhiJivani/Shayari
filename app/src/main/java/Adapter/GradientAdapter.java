package Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.shayari.R;

import Activity.Full_activity;

public class GradientAdapter extends BaseAdapter
{

    Full_activity full_activity;
    int gradArr[];
    public GradientAdapter(Full_activity full_activity,int[] gradArr)
    {

        this.full_activity=full_activity;
        this.gradArr=gradArr;
    }


    @Override
    public int getCount() {
        return gradArr.length;
    }

    @Override
    public Object getItem(int i) {

        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(full_activity).inflate(R.layout.gradient_layout_item,viewGroup,false);
        TextView textView=view.findViewById(R.id.txtGrad);
        textView.setBackgroundResource(gradArr[i]);
        return view;
    }
}
