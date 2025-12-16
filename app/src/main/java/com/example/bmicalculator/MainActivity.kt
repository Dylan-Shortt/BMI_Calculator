//------------------------------------------------------------------------------------------------------------------//
// Name: Dylan Shortt
// Group: 1
// Student Number: ST-10438409
//------------------------------------------------------------------------------------------------------------------//

//------------------------------------------------------------------------------------------------------------------//
// <summary>
// The namespace is used to group classes that are logically related.
// </summary>
package com.example.bmicalculator
//------------------------------------------------------------------------------------------------------------------//
// <summary>
// These import statements are used to import the necessary libraries for the program to run.
// </summary>
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

//------------------------------------------------------------------------------------------------------------------//

//------------------------------------------------------------------------------------------------------------------//
// <summary>
// This is the main activity class that is used to create the main activity of the application.
// </summary>
class MainActivity : AppCompatActivity() {

    //-------------------------------------------------//
    // Step 1: set on create binding
    private lateinit var binding: ActivityMainBinding
    //-------------------------------------------------//

    //------------------------------------------------------------------------------------------------------------------//
    // <summary>
    // This is the onCreate method that is used to create the main activity of the application.
    // </summary>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //-------------------------------------------------//
        // Step 1: set create binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //-------------------------------------------------//

        //-------------------------------------------------//
        // Step 5: set on click listener for button
        binding.calculateBtn.setOnClickListener {
            calculateBMI()
        }
        //-------------------------------------------------//
    }
    //------------------------------------------------------------------------------------------------------------------//

    //------------------------------------------------------------------------------------------------------------------//
    // <summary>
    // Step 2: create BMI method
    // </summary>
    private fun calculateBMI() {
        //-------------------------------------------------//
        // Step 3: get values from view
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()
        //-------------------------------------------------//

        //-------------------------------------------------//
        // Step 4: Determine if values can be calculated or
        // Skip and display error message
        if (weight != null && height != null) {

            //-------------------------------------------------//
            // Preform calculation
            val bmi = weight / (height / 100).pow(2)
            val bmiResult = String.format("%.2f", bmi)
            //-------------------------------------------------//

            //-------------------------------------------------//
            // create category for BMI
            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal weight"
                bmi < 29.9 -> "Overweight"
                else -> "Obese"
            }
            //-------------------------------------------------//

            binding.resultText.text = "BMI: $bmiResult\nCategory: $bmiCategory"
        } else {
            binding.resultText.text = "Invalid input"
        }
        //-------------------------------------------------//
    }
    //------------------------------------------------------------------------------------------------------------------//

}
//-----------------------------------...ooo000 END OF FILE 000ooo...-----------------------------------//