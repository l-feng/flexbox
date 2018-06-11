package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.adapter.StringTagAdapter;
import com.example.administrator.myapplication.baseInterfaces.OnFlexboxSubscribeListener;
import com.example.administrator.myapplication.baseWidget.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView btnCount;
    private TextView btnCount1;
    private StringTagAdapter adapter;
    private StringTagAdapter adapter1;
    private List<String> sourceData;
    private List<String> sourceData1;
    private List<String> selectItems;
    private List<String> selectItems1;
    private Button btn1;
    private Button btn2;
    private TagFlowLayout flowLayout;
    private TagFlowLayout flow;
    private String list1;
    private String list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initData1();
        initViews();
    }

    private void initData() {
        sourceData = new ArrayList<>();
        sourceData.add("京东超市");
        sourceData.add("京东服饰");
        sourceData.add("服饰");
        sourceData.add("会");
        sourceData.add("搞笑超市");
        sourceData.add("搞笑超市搞笑超市");
        sourceData.add("搞笑超");
        sourceData.add("搞笑超市搞笑超市搞笑超市搞笑超市");
        sourceData.add("搞");
        selectItems = new ArrayList<>();
    }


    private void initData1() {
        sourceData1 = new ArrayList<>();
        sourceData1.add("京东超市");
        sourceData1.add("京东服饰");
        sourceData1.add("服饰");
        sourceData1.add("会");
        sourceData1.add("搞笑超市");
        sourceData1.add("搞笑超市搞笑超市");
        sourceData1.add("搞笑超");
        sourceData1.add("搞笑超市搞笑超市搞笑超市搞笑超市");
        sourceData1.add("搞");
        selectItems1 = new ArrayList<>();
    }


    private void initViews() {
        btn1 = findViewById(R.id.clear1);
        btn2 = findViewById(R.id.clear2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        flowLayout = (TagFlowLayout) findViewById(R.id.flow_layout);
        btnCount = (TextView) findViewById(R.id.btn_get_count);
        adapter = new StringTagAdapter(this, sourceData, selectItems);
        adapter.setOnSubscribeListener(new OnFlexboxSubscribeListener<String>() {
            @Override
            public void onSubscribe(List<String> selectedItem) {
               btnCount.setText("已选择" + selectedItem.size() + "个" + "\n" + "选中的是：" + selectedItem.toString());
         //       list1 += selectedItem.toString();
            }
        });

        flowLayout.setAdapter(adapter);

        flow = (TagFlowLayout) findViewById(R.id.flow);
        btnCount1 = (TextView) findViewById(R.id.btn_get);
        adapter1 = new StringTagAdapter(this, sourceData1, selectItems1);
        adapter1.setOnSubscribeListener(new OnFlexboxSubscribeListener<String>() {
            @Override
            public void onSubscribe(List<String> selectedItem1) {
                list2 += selectedItem1.toString();
                btnCount1.setText("已选择" + selectedItem1.size() + "个" + "\n" + "选中的是：" + selectedItem1.toString());
            }
        });
        flow.setAdapter(adapter1);

}

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.clear1) {
            btnCount.setText(null);
            adapter = new StringTagAdapter(this, sourceData, selectItems);
            flowLayout.setAdapter(adapter);
            adapter.setOnSubscribeListener(new OnFlexboxSubscribeListener<String>() {
                @Override
                public void onSubscribe(List<String> selectItems) {
                    btnCount.setText("已选择" + selectItems.size() + "个" + "\n" + "选中的是：" + selectItems.toString());
                }
            });
        } else if (view.getId() == R.id.clear2) {
            btnCount1.setText(null);
            adapter1 = new StringTagAdapter(this, sourceData1, selectItems1);
            flow.setAdapter(adapter1);
            adapter1.setOnSubscribeListener(new OnFlexboxSubscribeListener<String>() {
                @Override
                public void onSubscribe(List<String> selectedItem1) {
                    btnCount1.setText("已选择" + selectedItem1.size() + "个" + "\n" + "选中的是：" + selectedItem1.toString());
                }
            });
        }
    }
}
