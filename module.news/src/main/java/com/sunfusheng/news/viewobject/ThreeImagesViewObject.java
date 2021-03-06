package com.sunfusheng.news.viewobject;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.sunfusheng.base.model.NewsModel;
import com.sunfusheng.news.R;
import com.sunfusheng.viewobject.delegate.action.factory.ActionDelegateFactory;
import com.sunfusheng.viewobject.viewobject.ViewObject;
import com.sunfusheng.viewobject.viewobject.factory.ViewObjectFactory;
import com.sunfusheng.glideimageview.GlideImageView;

/**
 * Created by sunfusheng on 2017/5/9.
 */
public class ThreeImagesViewObject extends BaseNewsViewObject<ThreeImagesViewObject.ViewHolder> {

    public static ViewObject createViewObject(NewsModel model, Context context, ActionDelegateFactory actionDelegateFactory, ViewObjectFactory viewObjectFactory) {
        BaseNewsViewObject viewObject = new ThreeImagesViewObject(context, model, actionDelegateFactory, viewObjectFactory);
        BaseNewsViewObjectCreator.initVo(model, viewObject);
        return viewObject;
    }

    public ThreeImagesViewObject(Context context, Object data, ActionDelegateFactory actionDelegateFactory, ViewObjectFactory viewObjectFactory) {
        super(context, data, actionDelegateFactory, viewObjectFactory);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_three_images;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder) {

        holder.tvTitle.setText(title);
        holder.tvSource.setText(source);
        holder.tvTime.setText(time);

        if (!TextUtils.isEmpty(tag_name)) {
            holder.tvTag.setVisibility(View.VISIBLE);
            holder.tvTag.setText(tag_name);
            holder.tvTag.setTextColor(Color.parseColor(tag_color));
        } else {
            holder.tvTag.setVisibility(View.GONE);
        }

        loadImage(holder.giv1, pics.get(0));
        loadImage(holder.giv2, pics.get(1));
        loadImage(holder.giv3, pics.get(2));

        holder.itemView.setOnClickListener(v -> raiseAction(R.id.vo_action_id_click));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSource;
        TextView tvTime;
        TextView tvTag;
        GlideImageView giv1;
        GlideImageView giv2;
        GlideImageView giv3;
        View bottomDivider;

        ViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvSource = (TextView) view.findViewById(R.id.tv_source);
            tvTime = (TextView) view.findViewById(R.id.tv_time);
            tvTag = (TextView) view.findViewById(R.id.tv_tag);
            giv1 = (GlideImageView) view.findViewById(R.id.giv1);
            giv2 = (GlideImageView) view.findViewById(R.id.giv2);
            giv3 = (GlideImageView) view.findViewById(R.id.giv3);
            bottomDivider = view.findViewById(R.id.bottom_divider);
        }
    }

}
