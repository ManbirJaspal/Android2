package com.manbirsinghjaspal.top10downloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutinflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutinflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) { //WHen the listview calls the getView method it tell it the position of the item it needs to display in the position parameter.
        ViewHolder viewHolder;

        //If  list view has a view that it can re-use, it passes a refwrence to that in the convert view. Until a view is scrolled off a screen, there wont be a view to reuse so we have to check if Convertview is null and only create a new view if it is null.
        if (convertView == null) {
            convertView = layoutinflater.inflate(layoutResource, parent, false); //we created a view by inflating the layout resource.
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        TextView tvName  = convertView.findViewById(R.id.tvName); //to find the id's that are in this view.(the one we created above)
//        TextView tvArtist  = convertView.findViewById(R.id.tvArtist);
//       TextView tvSummary  = convertView.findViewById(R.id.tvSummary);

        FeedEntry currentApp = applications.get(position);

        viewHolder.tvName.setText(currentApp.getName());
        viewHolder.tvArtist.setText(currentApp.getArtist());
        viewHolder.tvSummary.setText(currentApp.getSummary());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvName;
        final TextView tvArtist;
        final TextView tvSummary;

        ViewHolder(View view) {
            this.tvName = view.findViewById(R.id.tvName);
            this.tvArtist = view.findViewById(R.id.tvArtist);
            this.tvSummary = view.findViewById(R.id.tvSummary);
        }


    }
}
