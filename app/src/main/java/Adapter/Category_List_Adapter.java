package Adapter;




import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.R;

import Activity.Full_activity;
import Activity.List_Activity;


public class Category_List_Adapter extends RecyclerView.Adapter<Category_List_Adapter.Category_list_Holder> {

    List_Activity list_activity;


    String[] temp;
    String[] temp1;
    int imgArr;

    public Category_List_Adapter(List_Activity list_activity, String[] temp, String[] temp1, int img) {
        this.list_activity = list_activity;
        this.temp = temp;
        this.temp1=temp1;
        this.imgArr = img;

    }

    @NonNull
    @Override
    public Category_List_Adapter.Category_list_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(list_activity).inflate(R.layout.sec_item_list,parent,false);
        Category_list_Holder holder=new Category_list_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Category_List_Adapter.Category_list_Holder holder, int position) {
        holder.imageView.setImageResource(imgArr);
        holder.textView.setText(temp[position]);
    }

    @Override
    public int getItemCount() {
        return temp.length;
    }

    public class Category_list_Holder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        RecyclerView recyclerView;
        public Category_list_Holder(@NonNull View view) {
            super(view);
            textView= view.findViewById(R.id.other_item_name);
            imageView=view.findViewById(R.id.other_item_img);
            recyclerView=view.findViewById(R.id.recyclerList);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(list_activity, Full_activity.class);

                    intent.putExtra("pos",getAdapterPosition() );
                    intent.putExtra("temp1",temp1);
                    list_activity.startActivity(intent);
                }
            });

        }
    }
}



