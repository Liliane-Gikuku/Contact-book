package com.liliane.contactbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.liliane.contactbook.databinding.ActivityMainBinding
import com.liliane.contactbook.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getExtras()
    }

fun getExtras(){

    var name=intent.extras?.getString("NAME","")
    var address=intent.extras?.getString("ADDRESS","")
    var phone=intent.extras?.getString("PHONE","")
    var email=intent.extras?.getString("Email", "")
    var image=intent.extras?.getString("Image"," ")


    Toast.makeText(this,name, Toast.LENGTH_SHORT).show()
    Toast.makeText(this,address,Toast.LENGTH_LONG).show()
    Toast.makeText(this,email,Toast.LENGTH_LONG).show()
//        Toast.makeText(this,image,Toast.LENGTH_LONG).show()
    Toast.makeText(this,phone,Toast.LENGTH_LONG).show()

    binding.tvNames.text=name
//    binding.tvMobile.text=phone
    binding.tvCall.text=phone



//        Picasso.get().load(intent.getStringExtra("Image")).into(image)
    Picasso.get().load(intent.getStringExtra("IMAGE")).into(binding.imgProfile)


}
}

