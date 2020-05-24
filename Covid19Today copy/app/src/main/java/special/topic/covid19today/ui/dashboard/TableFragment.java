package special.topic.covid19today.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import special.topic.covid19today.ExampleAdapter;
import special.topic.covid19today.ExampleItem;
import special.topic.covid19today.R;

public class TableFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMannager;

    Button button;

    public static String key[] = new String[77];
    public static String data[] = new String[77];

    public static String chooseName= "Province";

    ArrayList<ExampleItem> exampleList = new ArrayList<>();

    public static TableFragment newInstance() {
        return new TableFragment();
    }

    public static String getChooseName(){
        return chooseName;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_table, container, false);

        System.out.println("Table---------"+key [0]);

        button = root.findViewById(R.id.button);
        button.setText(getChooseName());

        mRecyclerView = root.findViewById(R.id.recycler_view);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i=0; i < data.length; i++) {
            exampleList.add(new ExampleItem(key[i], data[i]));
        }

        mRecyclerView.setHasFixedSize(true);
        mLayoutMannager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutMannager);
        mRecyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(getActivity() , button);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        chooseName = (String) item.getTitle();
                        button.setText(getChooseName());

                        DashboardFetch process = new DashboardFetch();
                        process.execute();

                        clear(exampleList);

                        for (int i=0; i < data.length; i++) {
                            exampleList.add(new ExampleItem(key[i], data[i]));
                        }

                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.setLayoutManager(mLayoutMannager);
                        mRecyclerView.setAdapter(mAdapter);

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    public  void clear(ArrayList<ExampleItem> data) {
        int size = data.size();
        data.clear();
        mAdapter.notifyItemRangeRemoved(0, size);
    }

}
