package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.objecthunter.exp4j.ExpressionBuilder
//import com.github.burnett01.expression.*

import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var btnAC = findViewById<Button>(R.id.btnAC)
//    val btnPM = findViewById<Button>(R.id.btn_plus_minus)
//    val btnPercent = findViewById<Button>(R.id.btn_percent)
    private val btnDiv = findViewById<Button>(R.id.btn_div)
    private val btnMult = findViewById<Button>(R.id.btn_mult)
    private val btnMinus = findViewById<Button>(R.id.btn_minus)
    private val btnPlus = findViewById<Button>(R.id.btn_plus)
    private val btnEqual = findViewById<Button>(R.id.btn_compute)

    private val btn0 = findViewById<Button>(R.id.btn0)
    private val btn1 = findViewById<Button>(R.id.btn1)
    private val btn2 = findViewById<Button>(R.id.btn2)
    private val btn3 = findViewById<Button>(R.id.btn3)
    private val btn4 = findViewById<Button>(R.id.btn4)
    private val btn5 = findViewById<Button>(R.id.btn5)
    private val btn6 = findViewById<Button>(R.id.btn6)
    private val btn7 = findViewById<Button>(R.id.btn7)
    private val btn8 = findViewById<Button>(R.id.btn8)
    private val btn9 = findViewById<Button>(R.id.btn9)
    private val btnDot = findViewById<Button>(R.id.btn_dot)
    private var result = findViewById<TextView>(R.id.result)
    private var expression = findViewById<TextView>(R.id.expression)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid_layout)
        init()

//        val btnAC = findViewById<Button>(R.id.btnAC)
//        val btnPM = findViewById<Button>(R.id.btn_plus_minus)
//        val btnPercent = findViewById<Button>(R.id.btn_percent)
//        val btnDiv = findViewById<Button>(R.id.btn_div)
//        val btnMult = findViewById<Button>(R.id.btn_mult)
//        val btnMinus = findViewById<Button>(R.id.btn_minus)
//        val btnPlus = findViewById<Button>(R.id.btn_plus)
//        val btnEqual = findViewById<Button>(R.id.btn_compute)
//
//        val btn0 = findViewById<Button>(R.id.btn0)
//        val btn1 = findViewById<Button>(R.id.btn1)
//        val btn2 = findViewById<Button>(R.id.btn2)
//        val btn3 = findViewById<Button>(R.id.btn3)
//        val btn4 = findViewById<Button>(R.id.btn4)
//        val btn5 = findViewById<Button>(R.id.btn5)
//        val btn6 = findViewById<Button>(R.id.btn6)
//        val btn7 = findViewById<Button>(R.id.btn7)
//        val btn8 = findViewById<Button>(R.id.btn8)
//        val btn9 = findViewById<Button>(R.id.btn9)
//        val btnDot = findViewById<Button>(R.id.btn_dot)
//        var result = findViewById<TextView>(R.id.result)
//        var input = 0
//        var res = ""
//
//        btn1.setOnClickListener{
//            input = 1
//            res += "1"
//            result.text = res
//        }
//        btnPlus.setOnClickListener{
//            res += " + "
//            result.text = res
//        }
    }

    private fun init() {
        setNumber()
        setOperators()
        setClean()
//        setDelete()
        setExpectedResult()
    }

    private fun setExpectedResult() {
        btnEqual.setOnClickListener {
            try {
                val expectedExpression = ExpressionBuilder(expression.text.toString()).build()
                val expectedResult = expectedExpression.evaluate()
                val longResult = expectedResult.toLong()
                if (expectedResult == longResult.toDouble()) {
                    result.text = longResult.toString()
                } else {
                    result.text = expectedResult.toString()
                }

            } catch (e: Exception) {
            }
        }
    }

//    private fun setDelete() {
////        backspace.setOnClickListener {
////            val typedtext = expression.text.toString()
////            if (typedtext.isNotBlank()) {
////                expression.text = typedtext.substring(0, typedtext.length - 1)
////            }
////            result.text = ""
////        }
//    }

    private fun setClean() {
        btnAC.setOnClickListener {
            expression.text = ""
            result.text = ""
        }
    }

    private fun setOperators() {
        btnPlus.setOnClickListener { calculateTheExpress("+", false) }
        btnMinus.setOnClickListener { calculateTheExpress("-", false) }
        btnMult.setOnClickListener { calculateTheExpress("*", false) }
        btnDiv.setOnClickListener { calculateTheExpress("/", false) }
    }

    private fun setNumber() {
        btn0.setOnClickListener { calculateTheExpress("0", true) }
        btn1.setOnClickListener { calculateTheExpress("1", true) }
        btn2.setOnClickListener { calculateTheExpress("2", true) }
        btn3.setOnClickListener { calculateTheExpress("3", true) }
        btn4.setOnClickListener { calculateTheExpress("4", true) }
        btn5.setOnClickListener { calculateTheExpress("5", true) }
        btn6.setOnClickListener { calculateTheExpress("6", true) }
        btn7.setOnClickListener { calculateTheExpress("7", true) }
        btn8.setOnClickListener { calculateTheExpress("8", true) }
        btn9.setOnClickListener { calculateTheExpress("9", true) }
        btnDot.setOnClickListener { calculateTheExpress(".", true) }
    }

    private fun calculateTheExpress(data: String, clearData: Boolean) {
        if (result.text.isNotEmpty()) {
            expression.text = ""
        }
        if (clearData) {
            result.text = ""
            expression.append(data)
        } else {
            expression.append(result.text)
            expression.append(data)
            result.text = ""
        }
    }
}