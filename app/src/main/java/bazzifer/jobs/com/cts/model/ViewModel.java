package bazzifer.jobs.com.cts.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class ViewModel extends android.arch.lifecycle.ViewModel {
    private MutableLiveData<Contacts> heroList;

    private static final MutableLiveData MUTABLE_LIVE_DATA = new MutableLiveData();
    {
        MUTABLE_LIVE_DATA.setValue(null);
    }
  //  public final ObservableField<Contacts> project = new ObservableField<>();

    /*public ViewModel(@NonNull HeadLineRepository headLineRepository,
                             @NonNull Application application)
    {
        super(application);
       *//* newsResponseObservable = HeadLineRepository.getInstance()
                .getHeadLine("in","84a7decf3110498ea372bd16dd0601e8");*//*
    }*/

    public LiveData<Contacts> getNewsResponseObservable()
    {
        heroList = new MutableLiveData<Contacts>();
        return heroList;
    }

}
