package test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;

/**
 * Created by lx on 2017/7/14.
 */

public class Home_Adapter extends RecyclerView.Adapter {
    private List<Object> mlist;
    private LayoutInflater inflater;
    private Context context;
    public static final int TYPE1 = 1, TYPE2 = 2, TYPE3 = 3, TYPE4 = 4, TYPE5 = 5;
    public View view, view1, view2, view3, view4;
    private static OnClick onClick;

    public interface OnClick {
        void setTYPE1(View view, HomePageBean.DataBean.PandaeyeBean pandaeyeBean);
        void setTYPE2(View view, HomePageBean.DataBean.PandaeyeBean pandaeyeBean);
        void setTYPE3(View view,HomePageBean.DataBean.PandaliveBean listBean,int position);
        void setTYPE4(View view,HomePageBean.DataBean.AreaBean areaBean,int position);
        void setTYPE5(View view,HomePageBean.DataBean.WallliveBean wallliveBean,int position);
        void setTYPE6(View view,HomePageBean.DataBean.ChinaliveBean chinaliveBean,int position);
    }

    public Home_Adapter(Context context, List<Object> mlist) {
        this.mlist = mlist;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }


    @Override
    public int getItemViewType(int position) {
        Object o = mlist.get(position);
        if (o instanceof HomePageBean.DataBean.PandaeyeBean) {
            return TYPE1;
        } else if (o instanceof HomePageBean.DataBean.PandaliveBean) {
            return TYPE2;
        } else if (o instanceof HomePageBean.DataBean.AreaBean) {
            return TYPE3;
        } else if (o instanceof HomePageBean.DataBean.WallliveBean) {
            return TYPE4;
        } else if (o instanceof HomePageBean.DataBean.ChinaliveBean) {
            return TYPE5;
        }
        return 0;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE1:
                view = inflater.inflate(R.layout.home_news, parent, false);
                viewHolder = new ViewHolder(context, view);
                break;
            case TYPE2:
                view1 = inflater.inflate(R.layout.home_elegant, parent, false);
                viewHolder = new ViewHolder(context, view1);
                break;
            case TYPE3:
                view2 = inflater.inflate(R.layout.home_amazing, parent, false);
                viewHolder = new ViewHolder(context, view2);
                break;
            case TYPE4:
                view3 = inflater.inflate(R.layout.home_vadio, parent, false);
                viewHolder = new ViewHolder(context, view3);
                break;
            case TYPE5:
                view4 = inflater.inflate(R.layout.home_china, parent, false);
                viewHolder = new ViewHolder(context, view4);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object o = mlist.get(position);
        int viewType = holder.getItemViewType();

        switch (viewType) {
            case TYPE1:
                FirstViewHolder firstViewHolder = new FirstViewHolder(holder.itemView);
                firstViewHolder.setFirst((HomePageBean.DataBean.PandaeyeBean) o);
                break;
            case TYPE2:
                TwoViewHolder twoViewHolder = new TwoViewHolder(holder.itemView);
                twoViewHolder.setTwo((HomePageBean.DataBean.PandaliveBean) o);
                break;
            case TYPE3:
                ThreeViewHolder threeViewHolder = new ThreeViewHolder(holder.itemView);
                threeViewHolder.setThree((HomePageBean.DataBean.AreaBean) o);
                break;
            case TYPE4:
                FourViewHolder fourViewHolder = new FourViewHolder(holder.itemView);
                fourViewHolder.setFour((HomePageBean.DataBean.WallliveBean) o);
                break;
            case TYPE5:
                FiveViewHolder fiveViewHolder = new FiveViewHolder(holder.itemView);
                fiveViewHolder.setFive((HomePageBean.DataBean.ChinaliveBean) o);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class FirstViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView t1, t2, t3, t4;

        public FirstViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.home_Image);
            t1 = (TextView) itemView.findViewById(R.id.pandalive_content1);
            t2 = (TextView) itemView.findViewById(R.id.pandalive_content);
        }




        public void setFirst(final HomePageBean.DataBean.PandaeyeBean pandaeyeBean) {
            Glide.with(context).load(pandaeyeBean.getPandaeyelogo()).into(imageView);
            t1.setText(pandaeyeBean.getItems().get(0).getTitle());
            t2.setText(pandaeyeBean.getItems().get(1).getTitle());

            t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//
                    onClick.setTYPE1(v,pandaeyeBean);

                }
            });
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClick.setTYPE2(v,pandaeyeBean);
                }
            });
        }

    }

    class TwoViewHolder extends RecyclerView.ViewHolder {
        GridView gridView;

        public TwoViewHolder(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.home_GridView_Elegant);
        }

        public void setTwo(final HomePageBean.DataBean.PandaliveBean listBean) {
            Home_Elegant_Adapter adapter = new Home_Elegant_Adapter(context, listBean.getList());
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    onClick.setTYPE3(view,listBean,position);

                }
            });
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder {

        GridView gridView;

        public ThreeViewHolder(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.home_GridView_Amazing);
        }

        public void setThree(final HomePageBean.DataBean.AreaBean areaBean) {
            Home_Amazing_Adapter adapter1 = new Home_Amazing_Adapter(context, areaBean.getListscroll());
            gridView.setAdapter(adapter1);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//

                    onClick.setTYPE4(view,areaBean,position);
                }
            });
       }
    }

    class FourViewHolder extends RecyclerView.ViewHolder {

        ListView home_ListView;

        public FourViewHolder(View itemView) {
            super(itemView);
            home_ListView = (ListView) itemView.findViewById(R.id.home_ListView);
        }

        public void setFour(final HomePageBean.DataBean.WallliveBean wallliveBean) {
            Home_Vadio_Adapter home_vadio_adapter = new Home_Vadio_Adapter(context, wallliveBean.getList());
            home_ListView.setAdapter(home_vadio_adapter);
            home_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//

                    onClick.setTYPE5(view,wallliveBean,position);
                }
            });
        }
    }

    class FiveViewHolder extends RecyclerView.ViewHolder {

        GridView home_GridView_China;

        public FiveViewHolder(View itemView) {
            super(itemView);
            home_GridView_China = (GridView) itemView.findViewById(R.id.home_GridView_China);
        }

        public void setFive(final HomePageBean.DataBean.ChinaliveBean chinaliveBean) {
            Home_China_Adapter home_china_adapter = new Home_China_Adapter(context, chinaliveBean.getList());
            home_GridView_China.setAdapter(home_china_adapter);
            home_GridView_China.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
                    onClick.setTYPE6(view,chinaliveBean,position);


                }
            });
        }
    }
}
