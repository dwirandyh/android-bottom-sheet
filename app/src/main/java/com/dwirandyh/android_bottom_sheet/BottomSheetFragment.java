package com.dwirandyh.android_bottom_sheet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Febrian Reza on 23-Dec-17.
 */

public class BottomSheetFragment extends BottomSheetDialogFragment {

    @BindView(R.id.save)
    LinearLayout save;

    @BindView(R.id.share)
    LinearLayout share;

    @BindView(R.id.setas)
    LinearLayout setas;

    public BottomSheetFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_menu, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.save)
    public void save(){
        Toast.makeText(getContext(), "Save Clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.share)
    public void share(){
        Toast.makeText(getContext(), "Save Clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.setas)
    public void setas(){
        Toast.makeText(getContext(), "Set As Clicked", Toast.LENGTH_SHORT).show();
    }


}
