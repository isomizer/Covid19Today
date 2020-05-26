package special.topic.covid19today;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ExampleViewHolder> {
    private ArrayList<ListViewItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder( View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.text_view_1);
            mTextView2 = itemView.findViewById(R.id.text_view_2);
        }
    }

    public ListViewAdapter(ArrayList<ListViewItem> exampleList){
        mExampleList = exampleList;
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ListViewItem currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }




}
