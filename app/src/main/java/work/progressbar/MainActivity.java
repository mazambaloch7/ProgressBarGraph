package work.progressbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {
    private int progressStatus = 0;
    private Handler handler = new Handler();

    private RecyclerView vertical_recycler_view, horizontal_recycler_view;
    HorizontalAdapter horizontalAdapter;
    public List<DataProgrssBar> horizontalList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        horizontalList=new ArrayList<>();
        horizontalList.add(new DataProgrssBar(25,"20"));
        horizontalList.add(new DataProgrssBar(35,"21"));
        horizontalList.add(new DataProgrssBar(45,"22"));
        horizontalList.add(new DataProgrssBar(55,"23"));
        horizontalList.add(new DataProgrssBar(65,"24"));
        horizontalList.add(new DataProgrssBar(75,"25"));
        horizontalList.add(new DataProgrssBar(85,"26"));
        horizontalList.add(new DataProgrssBar(95,"27"));
        horizontalList.add(new DataProgrssBar(85,"28"));
        horizontalList.add(new DataProgrssBar(75,"29"));
        horizontalList.add(new DataProgrssBar(55,"30"));







        horizontalAdapter=new HorizontalAdapter(horizontalList);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        horizontal_recycler_view.setAdapter(horizontalAdapter);
        horizontal_recycler_view.getLayoutManager().scrollToPosition(horizontalList.size()-1);



    }
    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<DataProgrssBar> horizontalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ProgressBar txtView;
            TextView x;

            public MyViewHolder(View view) {
                super(view);
                txtView = (ProgressBar) view.findViewById(R.id.pb);
                x = (TextView) view.findViewById(R.id.TextViewID);

            }
        }


        public HorizontalAdapter(List<DataProgrssBar> horizontalList) {
            this.horizontalList = horizontalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setProgress((horizontalList.get(position).getProgress()));
            holder.x.setText((horizontalList.get(position).getDate()));
            if(position == horizontalList.size()-1 ){
                holder.x.setBackground(getResources().getDrawable(R.drawable.circlenew));
                holder.x.setTextColor(Color.WHITE);
            }


        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }



}