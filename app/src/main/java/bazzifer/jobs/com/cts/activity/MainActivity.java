package bazzifer.jobs.com.cts.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.List;

import javax.xml.transform.Result;

import bazzifer.jobs.com.cts.Adapter.Recv;
import bazzifer.jobs.com.cts.Communication.CommunicationManager;
import bazzifer.jobs.com.cts.Communication.RetrofitApi;
import bazzifer.jobs.com.cts.Adapter.ImageAdapter;
import bazzifer.jobs.com.cts.R;
//import bazzifer.jobs.com.cts.activity.ImageAdapter;
import bazzifer.jobs.com.cts.model.Contacts;
import bazzifer.jobs.com.cts.model.ContactsItem;
import bazzifer.jobs.com.cts.model.ViewModel;
import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

   /* @InjectView(R.id.recycler)
    RecyclerView recyclerView;*/
   @InjectView(R.id.recycler)
   RecyclerView recyclerView;
    public ImageAdapter adapter;
    List<ContactsItem> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
      //  recyclerView = (RecyclerView) findViewById(R.id.recycler);

        RetrofitApi service = CommunicationManager.getRetrofitInstance().create(RetrofitApi.class);
        //Call<List<Contacts>> call = service.getimage();
        service.getimage().enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                Log.i("sak", String.valueOf(response.body().toString()));
                 movies = response.body().getContacts();
                adapter = new ImageAdapter(movies, R.layout.activity_profile_image, getApplicationContext());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Log.e("sak",t.getMessage());
            }
        });

        final ViewModel viewModel = ViewModelProviders
                .of(this).get(ViewModel.class);
        viewModel.getNewsResponseObservable().observe(this, new Observer<Contacts>() {
            @Override
            public void onChanged(@Nullable Contacts contacts) {
                adapter = new ImageAdapter(movies, R.layout.activity_profile_image, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }
        });
    }
            }






