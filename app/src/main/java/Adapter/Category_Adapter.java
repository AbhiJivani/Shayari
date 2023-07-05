package Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.R;

import Activity.List_Activity;
import Activity.Main_Activity;


public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.CategoryHolder> {
    Main_Activity mainActivity;
    String[] name;
    int[] imgArr;

    public Category_Adapter(Main_Activity mainActivity, String[] name, int[] img) {
        this.mainActivity = mainActivity;
        this.name = name;
        this.imgArr = img;

    }

    @NonNull
    @Override
    public Category_Adapter.CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.first_item_list, parent, false);
        CategoryHolder holder = new CategoryHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.textView.setText("" + name[position]);
        holder.imageView.setImageResource(imgArr[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        RecyclerView recyclerView;

        public CategoryHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.main_item_name);
            imageView = view.findViewById(R.id.main_item_img);
            recyclerView = view.findViewById(R.id.recyclerList);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mainActivity, List_Activity.class);
                    intent.putExtra("pos", getAdapterPosition());
                    intent.putExtra("name", name);

                    intent.putExtra("img", imgArr[getAdapterPosition()]);
                    mainActivity.startActivity(intent);
                }
            });
        }
    }
}
                   


       
   


//    @Override
//    public int getCount() {
//        return name.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        view= LayoutInflater.from(mainActivity).inflate(R.layout.first_item_list,parent,false);
//
//        imageView=view.findViewById(R.id.main_item_img);
//        textView=view.findViewById(R.id.main_item_name);
//
//        textView.setText(""+name[position]);
//        imageView.setImageResource(imgArr[position]);
//
//        return view;
//    }
//}
