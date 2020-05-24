package special.topic.covid19today.ui.dashboard;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import special.topic.covid19today.R;


public class GraphFragment extends Fragment {


    public static com.jjoe64.graphview.GraphView graph;

    public static int cInt[] = new int[0];
    public static int rInt[] = new int[0];
    public static int dInt[] = new int[0];

    public static GraphFragment newInstance() {
        return new GraphFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_graph, container, false);

        graph = root.findViewById(R.id.graph_1);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataPoint p1[] = new DataPoint[cInt.length];
        DataPoint p2[] = new DataPoint[rInt.length];
        DataPoint p3[] = new DataPoint[dInt.length];
        LineGraphSeries<DataPoint> series;

        for (int i=0; i<cInt.length; i++) {
            p1[i] = new DataPoint(i, cInt[i]);
            p2[i] = new DataPoint(i, rInt[i]);
            p3[i] = new DataPoint(i, dInt[i]);
        }
        series = new LineGraphSeries(p1);
        series.setColor(Color.BLUE);
        graph.addSeries(series);
        series = new LineGraphSeries(p2);
        series.setColor(Color.GREEN);
        graph.addSeries(series);
        series = new LineGraphSeries(p3);
        series.setColor(Color.RED);
        graph.addSeries(series);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(cInt.length);
    }
}
