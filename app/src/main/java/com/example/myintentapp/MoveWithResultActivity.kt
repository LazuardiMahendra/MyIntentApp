package com.example.myintentapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.myintentapp.databinding.ActivityMoveWithResultBinding

class MoveWithResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMoveWithResultBinding

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_choose) {
            if (rgNumber.checkedRadioButtonId > 0) {
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb_10 -> value = 10
                    R.id.rb_20 -> value = 20
                    R.id.rb_30 -> value = 30
                    R.id.rb_40 -> value = 40
                    R.id.rb_50 -> value = 50
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }


}