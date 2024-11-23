package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myintentapp.data.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveWithResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveWithResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWitDataActivity: Button = findViewById(R.id.btn_move_activity_with_data)
        val btnMoveWithObjectActivity: Button = findViewById(R.id.btn_move_activity_with_object)
        val btnMoveDial: Button = findViewById(R.id.btn_dial_number)
        val btnMoveWithResultActivity: Button = findViewById(R.id.btn_activity_with_result)

        btnMoveActivity.setOnClickListener(this)
        btnMoveWitDataActivity.setOnClickListener(this)
        btnMoveWithObjectActivity.setOnClickListener(this)
        btnMoveDial.setOnClickListener(this)
        btnMoveWithResultActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_with_data -> {
                val moveDataIntent = Intent(this, MoveWithDataActivity::class.java)
                moveDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Ali Sang Dewa")
                moveDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                startActivity(moveDataIntent)
            }

            R.id.btn_move_activity_with_object -> {
                val person = Person(
                    "Ali Sang Penakluk", 21, "Gotham"
                )
                val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "08563500550"
                val dialPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhone)
            }

            R.id.btn_activity_with_result -> {
                val moveForResult = Intent(this, MoveWithResultActivity::class.java)
                resultLauncher.launch(moveForResult)
            }


        }
    }
}