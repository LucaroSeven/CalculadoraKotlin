package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //Variables
    private var num1: Float = 0f
    private var num2: Float = 0f
    private var op: Char = ' '
    private var isShowingResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Events
        binding.btn0.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            if (!checkZeroStatus())
                (binding.tvResult.text.toString()+"0").also { binding.tvResult.text = it }
        }
        binding.btn1.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"1").also { binding.tvResult.text = it }
        }
        binding.btn2.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"2").also { binding.tvResult.text = it }
        }
        binding.btn3.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"3").also { binding.tvResult.text = it }
        }
        binding.btn4.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"4").also { binding.tvResult.text = it }
        }
        binding.btn5.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"5").also { binding.tvResult.text = it }
        }
        binding.btn6.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            //binding.tvResult.text = binding.tvResult.text.toString()+"6"
            (binding.tvResult.text.toString()+"6").also { binding.tvResult.text = it }
        }
        binding.btn7.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"7").also { binding.tvResult.text = it }
        }
        binding.btn8.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"8").also { binding.tvResult.text = it }
        }
        binding.btn9.setOnClickListener{
            if (isShowingResult){
                cleanScreen()
                isShowingResult=false
            }
            (binding.tvResult.text.toString()+"9").also { binding.tvResult.text = it }
        }
        binding.btnC.setOnClickListener{
            cleanScreen()
            num1 = 0f
            num2 = 0f
            op = ' '
            isShowingResult = false
        }
        binding.btnDivision.setOnClickListener{
            if (binding.tvResult.text.isEmpty())
                return@setOnClickListener
            num1 = binding.tvResult.text.toString().toFloat()
            op = '/'
            isShowingResult = false
            cleanScreen()
        }
        binding.btnMult.setOnClickListener{
            if (binding.tvResult.text.isEmpty())
                return@setOnClickListener
            num1 = binding.tvResult.text.toString().toFloat()
            op = '*'
            isShowingResult = false
            cleanScreen()
        }
        binding.btnSuma.setOnClickListener{
            if (binding.tvResult.text.isEmpty())
                return@setOnClickListener
            num1 = binding.tvResult.text.toString().toFloat()
            op = '+'
            isShowingResult = false
            cleanScreen()
        }
        binding.btnResta.setOnClickListener{
            if (binding.tvResult.text.isEmpty())
                return@setOnClickListener
            num1 = binding.tvResult.text.toString().toFloat()
            op = '-'
            isShowingResult = false
            cleanScreen()
        }
        binding.btnIgual.setOnClickListener{
            if (checkZeroStatus()){
                cleanScreen()
                return@setOnClickListener
            }
            var res = 0f
            num2 = binding.tvResult.text.toString().toFloat()
            when(op){
                '+'->res = num1+num2
                '-'->res = num1-num2
                '*'->res = num1*num2
                '/'->res = num1/num2
                ' '->Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }
            binding.tvResult.text = res.toString()
            isShowingResult = true
        }
    }

    private fun cleanScreen(){
        binding.tvResult.text = ""
    }
    private fun checkZeroStatus(): Boolean{
        if (binding.tvResult.text.isEmpty()){
            return true
        }
        if (binding.tvResult.text.toString().toFloat()==0.0f){
            return true
        }
        return false
    }
}