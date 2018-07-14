package br.com.kotlinudemy.ktempconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var radioCelcius: RadioButton
    lateinit var radioFahrenheit: RadioButton
    lateinit var buttonConverter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.valorTemp) as EditText
        radioCelcius = findViewById(R.id.celciusRadio) as RadioButton
        radioFahrenheit = findViewById(R.id.FahrenheitRadio) as RadioButton
        buttonConverter = findViewById(R.id.converterButton) as Button

        buttonConverter.setOnClickListener{converter(it)}
    }

    fun converter(view: View){
        var temp: Double = editText.text.toString().toDouble()

        if (celciusRadio.isChecked){
            temp = (temp - 32) * 5/9
        }else if (radioFahrenheit.isChecked){
            temp = temp * 9/5 + 32
        }

        editText.setText(temp.toString())
    }
}
