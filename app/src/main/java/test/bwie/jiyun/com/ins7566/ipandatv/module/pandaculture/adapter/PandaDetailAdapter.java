package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaTebieBean;

/**
 * Created by lx on 2017/7/30.
 */

public class PandaDetailAdapter extends RecyclerView.Adapter {
    List<PandaTebieBean.VideoBean> list;
    Context context;
    setOnClick msetonclick;

    public PandaDetailAdapter(List<PandaTebieBean.VideoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_panda_culture_item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.title.setText(list.get(position).getT());
        viewHolder.time.setText(list.get(position).getPtime());
        Glide.with(context).load(list.get(position).getImg()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, time;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.panda_culture_item_title);
            time = (TextView) itemView.findViewById(R.id.panda_oculture_item_sp_time);
            image = (ImageView) itemView.findViewById(R.id.panda_culture_item_image);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    msetonclick.mSetOnClick(v, getAdapterPosition());
                }
            });
        }
    }

    public interface setOnClick {
        void mSetOnClick(View v, int postion);
    }

    public void setOnClick(setOnClick msetonclick) {
        this.msetonclick = msetonclick;
    }


}
