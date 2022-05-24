package com.ocem.Saloontion;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.ocem.Saloontion.sharedpreference.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ProgressDFragment extends DialogFragment {

    @BindView(R.id.tvLabel1)
    TextView tvLabel;

    public static ProgressDFragment newInstance(String message) {
        ProgressDFragment frag = new ProgressDFragment();
        Bundle args = new Bundle();
        args.putString( Constant.LABEL,message);
        frag.setArguments(args);
        frag.setCancelable(false);
        return frag;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_progress,container);
        ButterKnife.bind(this,view);
        //getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        tvLabel.setText(getArguments().getString(Constant.LABEL));
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_fragment_progress);


        return dialog;
    }


    public void changeText(String title) {
        tvLabel.setText(title);
    }
}
