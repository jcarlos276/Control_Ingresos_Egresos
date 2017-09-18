package app.guillen.com.myapplication.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import app.guillen.com.myapplication.R;
import app.guillen.com.myapplication.repositories.RepositorioOperacion;

public class ChartsActivity extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        RepositorioOperacion repositorioOperacion = RepositorioOperacion.getInstance();

        pieChart = (PieChart) findViewById(R.id.chart1);
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(repositorioOperacion.getIngresos(), "Ingresos"));
        entries.add(new PieEntry(repositorioOperacion.getEgresos(), "Egresos"));

        PieDataSet set = new PieDataSet(entries, "Election Results");
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterTextSize(100);
        pieChart.invalidate();// refresh

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);

        set.setColors(colors);
        set.setSliceSpace(2);
        set.setValueTextSize(12);
        set.setValueLineColor(Color.BLACK);


    }
}
