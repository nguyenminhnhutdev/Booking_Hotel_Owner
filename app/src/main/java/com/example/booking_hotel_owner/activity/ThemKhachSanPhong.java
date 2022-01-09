package com.example.booking_hotel_owner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking_hotel_owner.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class ThemKhachSanPhong extends AppCompatActivity {
    private static final int RESULT_OK = -1;
    ImageView btn_back,img_capnhatimg;
    TextView btn_thoat,themmoi;
    private static final int SELECT_PICTURE = 1;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khach_san_phong);
        img_capnhatimg=findViewById(R.id.img_capnhatimg);
        btn_thoat = findViewById(R.id.btn_thoat);
        themmoi=findViewById(R.id.themmoi);
        StorageReference storageRef = storage.getReferenceFromUrl("gs://thanh-l-c.appspot.com");

        btn_back = findViewById(R.id.btn_back);

img_capnhatimg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, SELECT_PICTURE);
    }
});
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        themmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child("imgae" + calendar.getTimeInMillis() + ".png");

                img_capnhatimg.setDrawingCacheEnabled(true);
                img_capnhatimg.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) img_capnhatimg.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }

                        // Continue with the task to get the download URL
                        return mountainsRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            Toast.makeText(getApplicationContext(), "Thành Công" + String.valueOf(downloadUri), Toast.LENGTH_SHORT).show();
                            Log.d("AAAA", String.valueOf(downloadUri) + "");

                            //    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());


                            // ạnh nhựt code update cái user  chỗ này nhé muốn lấy hình thì String.valueof(downloadUri)


                        } else {
                            // Handle failures
                            // ...
                        }

                    }


                });
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getApplicationContext().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                img_capnhatimg.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
        }
    }
}