package com.example.firebaseapp

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.firebaseapp.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FirebaseAuth
import jp.wasabeef.blurry.Blurry
import java.security.AccessController.getContext


class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        Blurry.with(this)
            .radius(25)
            .sampling(4)
            .color(Color.argb(66, 255, 255, 0))
            .capture(findViewById(R.id.home))

        binding= DataBindingUtil.setContentView(this,R.layout.activity_home_page)
binding.logout.setOnClickListener{
    FirebaseAuth.getInstance().signOut();
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)

}

    }
}