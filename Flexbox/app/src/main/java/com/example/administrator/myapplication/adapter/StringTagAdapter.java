package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.myapplication.baseAdapter.TagAdapter;
import com.example.administrator.myapplication.widget.StringTagView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/11 0011.
 */

public class StringTagAdapter extends TagAdapter<StringTagView, String> {

    StringTagAdapter(Context context, List<String> data) {
        this(context, data, null);
    }

    public StringTagAdapter(Context context, List<String> data, List<String> selectItems) {
        super(context, data, selectItems);
    }


    @Override
    protected boolean checkIsItemSame(StringTagView view, String item) {
        return TextUtils.equals(view.getItem(), item);
    }


    @Override
    protected boolean checkIsItemNull(String item) {
        return TextUtils.isEmpty(item);
    }


    @Override
    protected StringTagView addTag(String item) {
        StringTagView tagView = new StringTagView(getContext());
        tagView.setPadding(25, 10, 25, 10);

        TextView textView = tagView.getTextView();
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        textView.setGravity(Gravity.CENTER);

        tagView.setItemDefaultDrawable(itemDefaultDrawable);
        tagView.setItemSelectDrawable(itemSelectDrawable);
        tagView.setItemDefaultTextColor(itemDefaultTextColor);
        tagView.setItemSelectTextColor(itemSelectTextColor);
        tagView.setItem(item);
        return tagView;
    }
}
