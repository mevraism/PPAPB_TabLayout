package com.example.tablayout

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayout.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("Username")

        val usernameHtml = "Welcome back, <font color='#525BFF'>$username</font>"
        username?.let {
            binding.tvOutput.text = Html.fromHtml(usernameHtml)

        }

        with(binding) {

            setSupportActionBar(toolbar);
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_signout ->{
                val intent = Intent(this, MainActivity::class.java).apply {
                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}