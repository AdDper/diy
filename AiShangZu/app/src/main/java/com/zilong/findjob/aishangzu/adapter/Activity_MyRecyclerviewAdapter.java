package com.zilong.findjob.aishangzu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.zilong.findjob.aishangzu.MyApp;
import com.zilong.findjob.aishangzu.R;
import com.zilong.findjob.aishangzu.model.Rent_detail;
import com.zilong.findjob.aishangzu.model.Shequ_Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by 子龙 on 2017/2/25.
 */
public class Activity_MyRecyclerviewAdapter extends RecyclerView.Adapter<Activity_MyRecyclerviewAdapter.MyViewHolder> {
    private final LayoutInflater layoutInflater;
    private final RequestQueue requestQueue;


    private List<Rent_detail.DataBean> dataBeanList;
    private Context context;
    private ImageLoader imageLoader;
    private ImageLoader.ImageListener imageListener;
    private List<Shequ_Activity.ObjBean.ActivityListBean> activityListBeanList = new ArrayList<>();


    public Activity_MyRecyclerviewAdapter(Context context, List<Shequ_Activity.ObjBean.ActivityListBean> activityListBeanList) {
        this.context = context;
        this.activityListBeanList = activityListBeanList;
        this.layoutInflater = LayoutInflater.from(context);
        requestQueue = MyApp.getRequestQueue();
    }

    /**
     * 创建复用的viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.content_activity, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    /**
     * 将数据与控件绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Shequ_Activity.ObjBean.ActivityListBean activityList = activityListBeanList.get(position);

        holder.activity_title.setText(activityList.getTitle());
        holder.activity_title.getPaint().setFakeBoldText(true);
        holder.activity_typetext.setText(activityList.getTypetext());
        holder.joinNumber.setText(String.valueOf(activityList.getJoinNumber()));
        String joinstatustext = activityList.getJoinstatustext();
        if(joinstatustext.equals("正在进行")){
            holder.joinstatustext.setTextColor(Color.RED);
        }
        holder.joinstatustext.setText(joinstatustext);
        holder.costtext.setText(activityList.getCosttext());

        long endJoinTime = activityList.getEndJoinTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        String format = dateFormat.format(new Date(endJoinTime));
        holder.endJoinTime.setText(format);

        Picasso.with(context).load(activityList.getMainImg()).into(holder.activity_mainImg);

    }



    @Override
    public int getItemCount() {
        return activityListBeanList.size();
    }
    
    class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView activity_title;
        private final ImageView activity_mainImg;
        private final TextView activity_typetext;
        private final TextView joinNumber;
        private final TextView endJoinTime;
        private final TextView joinstatustext;
        private final TextView costtext;



        public MyViewHolder(View itemView) {
            super(itemView);
            activity_mainImg = (ImageView) itemView.findViewById(R.id.activity_mainImg);
            activity_title = (TextView) itemView.findViewById(R.id.activity_title);
            activity_typetext = (TextView) itemView.findViewById(R.id.activity_typetext);
            joinNumber = (TextView) itemView.findViewById(R.id.tv_activity_joinNumber);
            endJoinTime = (TextView) itemView.findViewById(R.id.endJoinTime);
            joinstatustext = (TextView) itemView.findViewById(R.id.joinstatustext);
            costtext = (TextView) itemView.findViewById(R.id.costtext);
        }
    }
}
