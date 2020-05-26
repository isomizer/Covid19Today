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

import special.topic.covid19today.ListViewAdapter;
import special.topic.covid19today.ListViewItem;
import special.topic.covid19today.R;

public class TableFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMannager;

    Button button;

    public static String pKey[] = new String[77];
    public static String pData[] = new String[77];
    public static String gKey[] = new String[77];
    public static String gData[] = new String[77];
    public static String nKey[] = new String[77];
    public static String nData[] = new String[77];

    public static String chooseName= "Province";

    ArrayList<ListViewItem> exampleList = new ArrayList<>();

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

        button = root.findViewById(R.id.button);
        button.setText(getChooseName());

        mRecyclerView = root.findViewById(R.id.recycler_view);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String key[] = new String[77];
        String data[] = new String[77];

        switch (getChooseName()) {
            case "Province": key = pKey; data = pData; break;
            case "Gender": key = gKey; data = gData; break;
            case "Nation": key = nKey; data = nData; break;
        }

        for (int i=0; i < data.length; i++) {
            exampleList.add(new ListViewItem(key[i], data[i]));
        }

        mRecyclerView.setHasFixedSize(true);
        mLayoutMannager = new LinearLayoutManager(getActivity());
        mAdapter = new ListViewAdapter(exampleList);
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

                        clear(exampleList);

                        String key[] = new String[77];
                        String data[] = new String[77];

                        switch (getChooseName()) {
                            case "Province": key = pKey; data = pData; break;
                            case "Gender": key = gKey; data = gData; break;
                            case "Nation": key = nKey; data = nData; break;
                        }

                        for (int i=0; i < data.length; i++) {
                            exampleList.add(new ListViewItem(key[i], data[i]));
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

    public  void clear(ArrayList<ListViewItem> data) {
        int size = data.size();
        data.clear();
        mAdapter.notifyItemRangeRemoved(0, size);
    }

}
