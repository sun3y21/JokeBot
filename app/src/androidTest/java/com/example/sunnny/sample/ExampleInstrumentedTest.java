package com.example.sunnny.sample;

import android.app.Instrumentation;
import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.example.sunnny.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends Instrumentation{



    int count=0;
    @Before
    public void setUp() throws Exception {
        count=-1;
    }




    @Test
    public void testAsynTask() throws Throwable {
        // Context of the app under test.
        final Context appContext = InstrumentationRegistry.getTargetContext();

       new EndpointsAsyncTask().execute(new Pair<Context, String>(appContext,"Sunnny"));
        while (count==-1)
        {
            //wait till you don't get some reply
        }
        Assert.assertEquals(count,1);

    }

    class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private MyApi myApiService = null;
        private Context context;
        String data=null;


        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://jokebotsample.appspot.com/_ah/api/");
                myApiService = builder.build();
            }

            context = params[0].first;
            String name = params[0].second;

            try {
                data= myApiService.sayHi(name).execute().getData();
                return data;
            } catch (IOException e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null)
                count=1;
            else
                count=2;
        }
    }

}
