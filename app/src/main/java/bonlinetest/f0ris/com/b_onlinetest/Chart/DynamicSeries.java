package bonlinetest.f0ris.com.b_onlinetest.Chart;

import com.androidplot.xy.XYSeries;

import java.util.ArrayList;

import bonlinetest.f0ris.com.b_onlinetest.AppController;
import bonlinetest.f0ris.com.b_onlinetest.Models.Active;


public class DynamicSeries implements XYSeries {
    private DynamicDataSource dataSource;
    private ArrayList<Active> data = AppController.data;
    private int seriesIndex;
    private String title;

    public DynamicSeries(DynamicDataSource datasource, int seriesIndex, String title) {
        this.dataSource = datasource;
        this.seriesIndex = seriesIndex;
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int size() {
        return dataSource.getItemCount(seriesIndex);
    }

    @Override
    public Number getX(int index) {
        return dataSource.getX(seriesIndex, index);
    }

    @Override
    public Number getY(int index) {
        return dataSource.getY(seriesIndex, index);
    }
}