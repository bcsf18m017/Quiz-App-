package com.example.alphaprac;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomSheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomSheet extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public  static String userName="name";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BottomSheet() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomSheet.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomSheet newInstance(String param1, String param2) {
        BottomSheet fragment = new BottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        Intent intent = new Intent(getActivity(), QuizPage.class);
        Button button = (Button)rootView.findViewById(R.id.submit);
        EditText text=(EditText)rootView.findViewById(R.id.editTextTextPersonName);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!text.getText().toString().equals("")) {
                    intent.putExtra("Username",text.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(),"Please Enter Your Name",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}