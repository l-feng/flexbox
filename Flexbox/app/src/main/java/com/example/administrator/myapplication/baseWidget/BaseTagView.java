package com.example.administrator.myapplication.baseWidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.baseInterfaces.TagWithListener;

/**
 * Created by Administrator on 2018/6/11 0011.
 */

public class BaseTagView <T> extends FrameLayout implements View.OnClickListener {

    private int itemDefaultDrawable;
    private int itemSelectDrawable;

    private int itemDefaultTextColor;
    private int itemSelectTextColor;

    private T item;

    public TextView textView;

    private TagWithListener<T> listener;

    private boolean isItemSelected;

    public void setListener(TagWithListener<T> listener) {
        this.listener = listener;
    }

    public BaseTagView(Context context) {
        this(context, null);
    }

    public BaseTagView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseTagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        textView = new TextView(getContext());
        textView.setGravity(Gravity.CENTER);
        addView(textView);
        setOnClickListener(this);
    }


    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public void onClick(View v) {
        if (listener == null) return;
        listener.onItemSelect(item);
    }

    public void selectItemChangeColorState() {
        if (isItemSelected) {
            setBackgroundResource(itemDefaultDrawable);
            textView.setTextColor(itemDefaultTextColor);
            isItemSelected = false;
        } else {
            setBackgroundResource(itemSelectDrawable);
            textView.setTextColor(itemSelectTextColor);
            isItemSelected = true;
        }
    }

    public boolean isItemSelected() {
        return isItemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        isItemSelected = itemSelected;
        if (itemSelected) {
            setBackgroundResource(itemSelectDrawable);
            textView.setTextColor(itemSelectTextColor);
        } else {
            setBackgroundResource(itemDefaultDrawable);
            textView.setTextColor(itemDefaultTextColor);
        }
    }

    public void setItemDefaultDrawable(int itemDefaultDrawable) {
        this.itemDefaultDrawable = itemDefaultDrawable;
        setBackgroundResource(itemDefaultDrawable);
    }

    public void setItemSelectDrawable(int itemSelectDrawable) {
        this.itemSelectDrawable = itemSelectDrawable;
    }

    public void setItemDefaultTextColor(int itemDefaultTextColor) {
        this.itemDefaultTextColor = itemDefaultTextColor;
        textView.setTextColor(itemDefaultTextColor);
    }

    public void setItemSelectTextColor(int itemSelectTextColor) {
        this.itemSelectTextColor = itemSelectTextColor;
    }

    public TextView getTextView() {
        return textView;
    }
}