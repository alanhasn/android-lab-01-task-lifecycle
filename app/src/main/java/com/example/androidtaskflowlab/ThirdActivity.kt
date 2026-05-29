package com.example.androidtaskflowlab

// Standard Android and Compose UI imports
import androidx.activity.ComponentActivity
import android.util.Log
import android.os.Bundle
import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * ThirdActivity is the final activity in the flow.
 * It demonstrates navigation back to the previous activity in the stack.
 */
class ThirdActivity : ComponentActivity() {

    // Called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "ThirdActivity onCreate")

        // Define the UI layout using Jetpack Compose
        setContent {
            // Layout container that stacks elements vertically and centers them
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Button to navigate back to SecondActivity
                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@ThirdActivity,
                                SecondActivity::class.java
                            )
                        )
                    }
                ) {
                    Text("Back")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Button to navigate to itself (useful for testing stack behavior)
                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@ThirdActivity,
                                ThirdActivity::class.java
                            )
                        )
                    }
                ) {
                    Text("Open Third Again")
                }
            }
        }
    }

    // --- Lifecycle Callback Methods ---

    // Called when the activity becomes visible to the user.
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "ThirdActivity onStart")
    }

    // Called when the activity starts interacting with the user.
    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "ThirdActivity onResume")
    }

    // Called when the system is about to start resuming another activity.
    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "ThirdActivity onPause")
    }

    // Called after the activity has been stopped, prior to it being started again.
    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "ThirdActivity onRestart")
    }

    // Called when the activity is no longer visible to the user.
    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "ThirdActivity onStop")
    }

    // The final call you receive before your activity is destroyed.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "ThirdActivity onDestroy")
    }
}
