package com.example.afbraidingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.afbraidingapp.R;

public class AddProfilePictureActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 9;
    Button button;
    ImageView imageView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile_picture);

        initUI();
    }

    private void initUI() {
        button = (Button)findViewById(R.id.btnSave);
        imageView = (ImageView)findViewById(R.id.btnAddPhoto);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView !=  null){
                    openCongratulation();
                }
            }
        });
    }

    public void openCongratulation(){
        Intent intent = new Intent(this, CongratulationActivity.class);
        startActivity(intent);
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE && data != null){
            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);
            Glide.with(this).load(imageUri).circleCrop().into(imageView);
            button.setEnabled(true);
        }
    }
}