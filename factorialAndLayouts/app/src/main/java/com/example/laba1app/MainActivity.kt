package com.example.laba1app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: MyConstraintBinding
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var input: String
    lateinit var textView2: TextView

    fun factRec(n: Int): Int {
        if( n!=1 ) {
            return n * factRec(n-1);
        } else return 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_constraint)
//        val ts = findViewById<TextView>(R.id.textView1)
//        val btn = findViewById<Button>(R.id.button)

        title = "FactorialApp"
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        textView2 = findViewById(R.id.textView2)

        button.setOnClickListener {
            input = editText.text.toString()
            if (input.toIntOrNull() != null) textView2.text = factRec(input.toInt()).toString()
//            textView1.text = factRec(input.toInt()).toString()
        }
//
//        btn.setOnClickListener{
//            ts.text = "Кнопка нажата"
//        }
//        // Kotilin Android Extensios
//        btn.setOnClickListener{
//
//        }

//        binding = MyConstraintBinding.inflate(layoutInflater)
//        setContentView((binding.root)
//
//            binding.button.setOnclickListener {
//                binding.tw1.text = "Опять меня нажали"
//        }




//         val input = findViewById<EditText>(R.id.editText)
//         var editText = editText.text.toString()
//         btn.setOnClickListener{
//             ts.text = "Кнопка нажата"
//             print(input)
//
//         }

//    fun mycClick(view: View) {
//        Toast.makeText(context this, text "Нажата кнопка", Toast.LENGTH_LONG).show()
//    }

}}