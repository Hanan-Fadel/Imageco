package com.ca.imageco;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.cast.framework.media.ImagePicker;

public class ImageResize extends Fragment {

  ImageView imagePicker;
  Button btnGallery, btnCamera;



    public ImageResize() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_resize, container, false);

        imagePicker = view.findViewById(R.id.picker_image);

        btnCamera = view.findViewById(R.id.btnCamera);
        btnGallery = view.findViewById(R.id.btnCamera);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop()
//                        .maxResultSize(400, 400).start();
            }
        });



        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ImagePicker.with(this).cameraOnly().crop().maxResultSize(400, 400).start();
//
//                ImagePicker.with(this)
//                        .cameraOnly()
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .cropOval()				//Allow dimmed layer to have a circle inside
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
//                        .start();
            }
        });

        return view;
    }
}