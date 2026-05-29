// Package declaration for the application
package com.example.androidtaskflowlab

// Standard Android and Compose UI imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import android.util.Log
import androidx.compose.material3.Button
import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * MainActivity serves as the primary entry point for the application.
 * It demonstrates Activity lifecycle management and basic navigation using Jetpack Compose.
 */
class MainActivity : ComponentActivity() {

    // Called when the activity is first created. This is where you should do all of your 
    // normal static set up: create views, bind data to lists, etc.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "MainActivity onCreate")

        // Define the UI layout using Jetpack Compose
        setContent {
            // Layout container that stacks elements vertically and centers them
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {

                // Button to navigate to SecondActivity
                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@MainActivity,
                                SecondActivity::class.java
                            )
                        )
                    }
                ) {
                    Text("Open Second Activity")
                }

                // Button to close the current activity (MainActivity)
                Button(
                    onClick = {
                        finish() // Destroy current activity
                    }
                ) {
                    Text("Back")
                }
            }
        }
    }

    // --- Lifecycle Callback Methods ---

    // Called when the activity becomes visible to the user.
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "MainActivity onStart")
    }

    // Called when the activity starts interacting with the user.
    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "MainActivity onResume")
    }

    // Called when the system is about to start resuming another activity.
    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "MainActivity onPause")
    }

    // Called after the activity has been stopped, prior to it being started again.
    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "MainActivity onRestart")
    }

    // Called when the activity is no longer visible to the user.
    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "MainActivity onStop")
    }

    // The final call you receive before your activity is destroyed.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "MainActivity onDestroy")
    }
}
