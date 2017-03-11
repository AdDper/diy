package com.zilong.findjob.aishangzu.adapter;

import android.content.Context;
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

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by 子龙 on 2017/2/25.
 */
public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.MyViewHolder> {
    private final LayoutInflater layoutInflater;
    private final RequestQueue requestQueue;


    private List<Rent_detail.DataBean> dataBeanList;
    private Context context;
    private ImageLoader imageLoader;
    private ImageLoader.ImageListener imageListener;


    public MyRecyclerviewAdapter(Context context, List<Rent_detail.DataBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
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
        View view = layoutInflater.inflate(R.layout.layout_zufang, parent, false);
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
        Rent_detail.DataBean dataBean = dataBeanList.get(position);
        Picasso.with(context).load(dataBean.getIndexImg()).into(holder.indexImg);
        holder.tv_premName.setText(dataBean.getPremName());
        holder.tv_roomNum.setText((CharSequence) dataBean.getRoomNum());

        holder.tv_houseType.setText(dataBean.getHouseType());
        holder.tv_totalSize.setText(dataBean.getTotalSize());
        holder.tv_direction.setText(dataBean.getDirection());
        holder.tv_fitmenType.setText(dataBean.getFitmenType());

        holder.tv_districtName.setText(dataBean.getDistrictName());
        holder.tv_bizCircleName.setText(dataBean.getBizCircleName());
        holder.tv_size.setText(dataBean.getSize());

        holder.tv_price.setText(dataBean.getPrice());

        if(dataBean.getRentType().equals("SHARE")){
            holder.tv_rentType.setText("合租");
        }else if(dataBean.getRentType().equals("ENTIRE")){
            holder.tv_rentType.setText("整租");
            holder.tv_roomNum.setText("");
            holder.tv_size.setText("");
            holder.tv_point1.setText("");
            holder.tv_point2.setText("");
            holder.tv_room.setText("");
        }

        if(dataBean.getApartmentType().equals("BRAND")){
            holder.tv_apartmentType.setText("品牌公寓");
        }else if(dataBean.getApartmentType().equals("MANAGE")){
            holder.tv_apartmentType.setText("服务公寓");
        }

    }



    @Override
    public int getItemCount() {
        Log.i("shuju", "getItemCount: "+dataBeanList.size());
        return dataBeanList.size();
    }
    
    class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_point1;
        private final TextView tv_point2;
        private final TextView tv_room;
        private ImageView indexImg;
        private TextView tv_premName;
        private TextView tv_roomNum;
        private TextView tv_size;
        private TextView tv_houseType;
        private TextView tv_totalSize;
        private TextView tv_direction;
        private TextView tv_fitmenType;
        private TextView tv_price;
        private TextView tv_rentType;
        private TextView tv_apartmentType;
        private TextView tv_districtName;
        private TextView tv_bizCircleName;



        public MyViewHolder(View itemView) {
            super(itemView);
            indexImg = (ImageView) itemView.findViewById(R.id.indexImg);
            tv_premName = (TextView) itemView.findViewById(R.id.premName);
            tv_roomNum = (TextView) itemView.findViewById(R.id.roomNum);
            tv_size = (TextView) itemView.findViewById(R.id.size);

            tv_houseType = (TextView) itemView.findViewById(R.id.houseType);
            tv_totalSize = (TextView) itemView.findViewById(R.id.totalSize);
            tv_direction = (TextView) itemView.findViewById(R.id.direction);
            tv_fitmenType = (TextView) itemView.findViewById(R.id.fitmenType);

            tv_price = (TextView) itemView.findViewById(R.id.price);
            tv_rentType = (TextView) itemView.findViewById(R.id.rentType);
            tv_apartmentType = (TextView) itemView.findViewById(R.id.apartmentType);
            tv_districtName = (TextView) itemView.findViewById(R.id.districtName);
            tv_bizCircleName = (TextView) itemView.findViewById(R.id.bizCircleName);

            tv_point1 = (TextView) itemView.findViewById(R.id.point1);
            tv_point2 = (TextView) itemView.findViewById(R.id.point2);
            tv_room = (TextView) itemView.findViewById(R.id.room);


        }
    }
}
