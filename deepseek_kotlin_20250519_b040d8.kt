// app/src/main/java/com/example/thrombosisriskcalculator/MainActivity.kt  
package com.example.thrombosisriskcalculator  

import android.os.Bundle  
import android.widget.Button  
import android.widget.CheckBox  
import android.widget.TextView  
import androidx.appcompat.app.AppCompatActivity  

class MainActivity : AppCompatActivity() {  
    override fun onCreate(savedInstanceState: Bundle?) {  
        super.onCreate(savedInstanceState)  
        setContentView(R.layout.activity_main)  

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)  
        btnCalculate.setOnClickListener { calculateRisk() }  
    }  

    private fun calculateRisk() {  
        var score = 0  
        if (findViewById<CheckBox>(R.id.checkAge40).isChecked) score += 1  
        if (findViewById<CheckBox>(R.id.checkAge60).isChecked) score += 2  
        if (findViewById<CheckBox>(R.id.checkSurgery).isChecked) score += 2  
        if (findViewById<CheckBox>(R.id.checkVaricose).isChecked) score += 1  
        if (findViewById<CheckBox>(R.id.checkHistoryVTE).isChecked) score += 3  

        val riskText = when {  
            score >= 5 -> "ОЧЕНЬ ВЫСОКИЙ риск (≥5 баллов)\nРекомендации: НМГ + ЭМК"  
            score >= 3 -> "Высокий риск (3-4 балла)\nРекомендации: НМГ"  
            score >= 2 -> "Умеренный риск (2 балла)\nРекомендации: ЭМК"  
            else -> "Низкий риск (0-1 балл)\nРекомендации: ранняя активизация"  
        }  
        findViewById<TextView>(R.id.txtResult).text = "Баллы: $score\n$riskText"  
    }  
}  