package bazzifer.jobs.com.cts.Communication;

import java.util.List;

import javax.xml.transform.Result;

import bazzifer.jobs.com.cts.model.Contacts;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RetrofitApi {
    @GET("contacts/")
    Call<Contacts> getimage();
    //Call<List<Contacts>> getimage();

}
