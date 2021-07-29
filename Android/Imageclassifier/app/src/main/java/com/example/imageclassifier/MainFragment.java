package com.example.imageclassifier;

import android.app.AlertDialog; import android.app.Fragment; import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle; import android.view.LayoutInflater; import android.view.View; import android.view.ViewGroup;
public class MainFragment extends Fragment {
    private AlertDialog mDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        // Handle buttons here... return rootView;
        View aboutButton = rootView.findViewById(R.id.About);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.about_title);
                builder.setMessage(R.string.about_text);
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // nothing
                    }
                });
                mDialog = builder.show();
            }

        });
        View newButton = rootView.findViewById(R.id.Detect);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ClassifierActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return rootView;
    }
    @Override
    public void onPause() {
        super.onPause();
// Get rid of the about dialog if it's still up
        if (mDialog != null)
            mDialog.dismiss();
    }
}


