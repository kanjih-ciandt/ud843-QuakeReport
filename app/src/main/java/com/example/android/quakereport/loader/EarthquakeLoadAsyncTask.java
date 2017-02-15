package com.example.android.quakereport.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.android.quakereport.EarthquakeActivity;
import com.example.android.quakereport.quakereport.QueryUtils;
import com.example.android.quakereport.to.Earthquake;

import java.util.List;

/**
 * Created by kneto on 2/15/17.
 */

public class EarthquakeLoadAsyncTask extends AsyncTaskLoader<List<Earthquake>> {

    String url;
    public static final String LOG_TAG = EarthquakeLoadAsyncTask.class.getName();

    public EarthquakeLoadAsyncTask(Context context, String url){
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "onStartLoading");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG, "loadInBackground");
        List<Earthquake> earthquakeList = QueryUtils.fetchEarthquakeData(url);

        return earthquakeList;
    }
}
