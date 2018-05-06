package io.github.keentoy.attendanceapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class gridAdapter extends BaseAdapter {
    ArrayList names;
    public static Activity activity;

    public gridAdapter(Activity activity, ArrayList names) {
        this.activity = activity;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            convertView = vi.inflate(R.layout.grid_layout, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.namePlacer);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageHolder);
        if(names.get(position).toString().equals("ATTENDANCE")) {
            imageView.setImageResource(R.drawable.ic_attendance);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View convertView) {
                    FragmentManager fm = activity.getFragmentManager();
                    createRequest request = new createRequest();
                    request.show(fm, "Select");
                }
            });

            Animation anim = new ScaleAnimation(
                    0.95f, 1f,
                    0.95f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }

        return convertView;
    }

    public static class createRequest extends DialogFragment {


    }


}
