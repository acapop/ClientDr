package org.universaal.nativeandroid.lightserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private static LayoutInflater inflater = null;
    private Context context;
    List<User> users;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.item_text)
        TextView itemText;
        @BindView(R.id.root)
        ConstraintLayout root;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public CountryListAdapter(Context context, List<User> users) {
        this.context = context;
        if (context != null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.users = users;
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view;
        view = inflater.inflate(R.layout.row_item_history, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User user = users.get(position);
        holder.type.setText(user.getType());
        if(user.getData()!=null)
        holder.itemText.setText(user.getData());
    }


    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        return 0;
    }


}
