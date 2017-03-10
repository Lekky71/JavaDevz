package com.lekai.root.javadevz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lekai.root.javadevz.R;
import com.lekai.root.javadevz.RetroFit.Item;

import java.util.List;

import static com.lekai.root.javadevz.R.id.username;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static List<Item> mUsername;
    private ImageView[] mProfilePicture;
    private Context context ;
    public static ViewHolder.MyOnItemClickListener listener;
    RelativeLayout eachItem ;


    public MyAdapter(List<Item> myUsername) {
        mUsername = myUsername;

    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {


        // each data item is just a string in this case
        public TextView username;
        public ImageView picture;
        private Context context;

        //

        public ViewHolder(View v,final Context c) {
            super(v);
            picture = (ImageView) v.findViewById(R.id.profile_picture);
            username = (TextView) v.findViewById(R.id.username);
            context = c;

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(v.getContext(),DetailActivity.class);
                    intent.putExtra("username", mUsername.get(2).getLogin().toString());
                    v.getContext().startActivity(intent);
                }
            });
//            v.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    listener.startActivity(context);
//        /* below is my attempt that did not work */
//                    Intent intent = new Intent(context, DetailActivity.class);
////                    intent.putExtra("username", username.toString());
//                    context.startActivity(intent);
//                }
//            });
        }



            public static interface MyOnItemClickListener {
                public void startActivity();
            }


//            v.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent inten = new Intent(v.getContext(),DetailActivity.class);
//                    inten.getStringExtra(username.getText().toString());
////                    inten.putExtra("username", (CharSequence) username);
//                    v.getContext().startActivity(inten);
//
//                }
//            });



        }

//        private void onClick(int position) {
//            Item item = new Item();
//            Context c = context;
//            Intent inten = new Intent(c,DetailActivity.class);
//            inten.putExtra("username",mUsername.get(position).getLogin());
////                    inten.putExtra("username", (CharSequence) username);
//            c.startActivity(inten);
//        }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Item> myUsers, Context mContext) {
        this.context = context ;
        mUsername = myUsers;
        context = mContext;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        // create a new view
        final View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(rootView,context);
        return vh;

    }




    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.username.setText(mUsername.get(position).getLogin());

//        holder.picture.set(mProfilePicture[position]);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mUsername.size();
    }
        }