package bazzifer.jobs.com.cts.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bazzifer.jobs.com.cts.R;
import bazzifer.jobs.com.cts.activity.MainActivity;
import bazzifer.jobs.com.cts.model.Contacts;
import bazzifer.jobs.com.cts.model.ContactsItem;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ContactViewHolder> {
    private List<ContactsItem> dataList;
    private int rowLayout;
    private Context context;


    public ImageAdapter(List<ContactsItem> contacts, int activity_profile_image, Context applicationContext) {
        this.rowLayout = activity_profile_image;
        this.context = applicationContext;
        this.dataList = contacts;
    }




    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_profile_image, viewGroup, false);
        return new ContactViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int i) {
        viewHolder.txtEmpName.setText((CharSequence) dataList.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

     class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView txtEmpName;
        public ContactViewHolder(View view) {
            super(view);
            txtEmpName = (TextView) itemView.findViewById(R.id.txt_employee_name);
        }
    }
}
