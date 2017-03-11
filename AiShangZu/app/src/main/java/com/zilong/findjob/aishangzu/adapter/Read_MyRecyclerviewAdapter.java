package com.zilong.findjob.aishangzu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
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
import com.zilong.findjob.aishangzu.model.Shequ_Read;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by 子龙 on 2017/2/25.
 */
public class Read_MyRecyclerviewAdapter extends RecyclerView.Adapter<Read_MyRecyclerviewAdapter.MyViewHolder> {
    private final LayoutInflater layoutInflater;
    private final RequestQueue requestQueue;


    private List<Rent_detail.DataBean> dataBeanList;
    private Context context;
    private ImageLoader imageLoader;
    private ImageLoader.ImageListener imageListener;
    private List<Shequ_Read.ObjBean> read_objBeanList = new ArrayList<>();


    public Read_MyRecyclerviewAdapter(Context context, List<Shequ_Read.ObjBean> read_objBeanList) {
        this.context = context;
        this.read_objBeanList = read_objBeanList;
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
        View view = layoutInflater.inflate(R.layout.content_read, parent, false);
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
        Shequ_Read.ObjBean readObjBean = read_objBeanList.get(position);
        holder.read_title.setText(readObjBean.getTitle());
        holder.read_title.getPaint().setFakeBoldText(true);
        holder.read_classifyName.setText(readObjBean.getClassifyName());
        holder.read_viceTitle.setText(readObjBean.getViceTitle());
        holder.read_viewCount.setText(String.valueOf(readObjBean.getViewCount()));
        int isTop = readObjBean.getIsTop();
        if("1".equals(String.valueOf(isTop))){
            holder.read_isTop.setText("置顶");
        }else{
            holder.read_isTop.setVisibility(View.GONE);
        }
        String createdTime = readObjBean.getCreatedTime();
        String[] time_split = createdTime.split(" ");
        holder.text_create_time.setText(time_split[0]);

        /**
         * 这里本来用的是imageloader来缓存图片，然后发现图片会出现错位问题。
         * 改成了picasso框架。代码量少且解决了错位问题。
         */
        Picasso.with(context).load(readObjBean.getMainImg()).into(holder.read_mainImg);


    }



    @Override
    public int getItemCount() {
        return read_objBeanList.size();
    }
    
    class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView read_title;
        private final TextView read_classifyName;
        private final TextView read_viceTitle;
        private final TextView read_viewCount;
        private final TextView read_isTop;
        private final TextView text_create_time;
        private final ImageView read_mainImg;



        public MyViewHolder(View itemView) {
            super(itemView);
            read_title = (TextView) itemView.findViewById(R.id.read_title);
            read_classifyName = (TextView) itemView.findViewById(R.id.read_classifyName);
            read_viceTitle = (TextView) itemView.findViewById(R.id.read_viceTitle);
            read_viewCount = (TextView) itemView.findViewById(R.id.viewCount);
            read_isTop = (TextView) itemView.findViewById(R.id.read_isTop);
            text_create_time = (TextView) itemView.findViewById(R.id.text_create_time);
            read_mainImg = (ImageView) itemView.findViewById(R.id.read_mainImg);
        }
    }
}
