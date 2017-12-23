package com.dwirandyh.android_bottom_sheet;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_bottom_sheet)
    Button btnBottomSheet;
    @BindView(R.id.btn_bottom_sheet_dialog)
    Button btnBottomSheetDialog;

    @BindView(R.id.bottom_sheet)
    ConstraintLayout bottomSheet;

    BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        sheetBehavior = BottomSheetBehavior.from(bottomSheet);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_HIDDEN: {
                        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }
                    break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        btnBottomSheet.setText("Close Bottom Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        btnBottomSheet.setText("Expand Bottom Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_SETTLING: {

                    }
                    break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    @OnClick(R.id.btn_bottom_sheet)
    public void toggleBottomSheet(){
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            btnBottomSheet.setText("Close Bottom Sheet");
        }else{
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            btnBottomSheet.setText("Expand Bottom Sheet");
        }
    }

    @OnClick(R.id.btn_bottom_sheet_dialog)
    public void bottomSheetDialog(){
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
}