package com.thangcao.chatting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import com.thangcao.chatting.R;
import com.thangcao.chatting.databinding.ActivityDetailsChatBinding;
import com.thangcao.chatting.databinding.ActivityMainBinding;
import com.thangcao.chatting.models.User;
import com.thangcao.chatting.utilities.Constants;

public class DetailsChatActivity extends AppCompatActivity {

    private User receiverUser;
    private ActivityDetailsChatBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadReceiverDetails();
        setListeners();
    }

    private void setListeners() {
        binding.imageBack.setOnClickListener(v -> onBackPressed());

    }

    private void loadReceiverDetails() {
        receiverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        byte[] bytes = Base64.decode(receiverUser.image, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        binding.imageProfile.setImageBitmap(bitmap);
        binding.nameProfile.setText(receiverUser.name);
    }
}