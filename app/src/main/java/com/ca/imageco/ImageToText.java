package com.ca.imageco;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageToText#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageToText extends Fragment {

    private static final int REQUEST_CAMERA_CODE =100;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ImageToText() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageToText.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageToText newInstance(String param1, String param2) {
        ImageToText fragment = new ImageToText();
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

        View view = inflater.inflate(R.layout.fragment_image_to_text, container, false);
        Button btn_capture = (Button) view.findViewById(R.id.btn_capture);
        Button btn_copy = (Button) view.findViewById(R.id.btn_copy);

         btn_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revokeCamera(v);
            }
        });

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // copy
            }
        });

        return view;
    }

    public void revokeCamera(View v) {
        //Toast.makeText(getContext(), "Capture button clicked", Toast.LENGTH_LONG).show();
        mPermissionResult.launch(Manifest.permission.CAMERA);
    }

    private ActivityResultLauncher<String> mPermissionResult = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            result -> {
                if(result) {
                    dispatchTakePictureIntent();
                } else {
                    //Toast.makeText(getContext(), "onActivityResult: PERMISSION DENIED", Toast.LENGTH_LONG).show();
                }
            });


    /**
     * Start the camera by dispatching a camera intent.
     */
    protected void dispatchTakePictureIntent() {

        // Check if there is a camera.
        Context context = getActivity();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false) {
            Toast.makeText(getActivity(), "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
            return;
        } else {
            Toast.makeText(getActivity(), "This device has a camera.", Toast.LENGTH_SHORT)
                    .show();

            CameraManager cameraManager = (CameraManager) getContext().getSystemService(context.CAMERA_SERVICE);  //connects to camera
            //meraManager.openCamera(REQUEST_CAMERA_CODE, mPermissionResult, Accesss);


            return;
        }


    }



    }