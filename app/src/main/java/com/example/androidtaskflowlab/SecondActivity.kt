package com.example.androidtaskflowlab

// Standard Android and Compose UI imports
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * SecondActivity demonstrates a specific launch mode (singleInstance as defined in Manifest).
 * It provides navigation back to MainActivity or forward to ThirdActivity.
 */
class SecondActivity : ComponentActivity() {

    // Called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "SecondActivity onCreate")

        // Define the UI layout using Jetpack Compose
        setContent {
            // Layout container that stacks elements vertically and centers them
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Button to navigate to ThirdActivity
                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@SecondActivity,
                                ThirdActivity::class.java
                            )
                        )
                    }
                ) {
                    Text("Open Third Activity")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Button to navigate to itself (useful for testing launchModes)
                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@SecondActivity,
                                SecondActivity::class.java
                            )
                        )
                    }
                ) {
                    Text("Open Second Again")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Button to navigate back to MainActivity
                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@SecondActivity,
                                MainActivity::class.java
                            )
                        )
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
        Log.d("LIFECYCLE", "SecondActivity onStart")
    }

    // Called when the activity starts interacting with the user.
    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "SecondActivity onResume")
    }

    // Called when the system is about to start resuming another activity.
    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "SecondActivity onPause")
    }

    // Called after the activity has been stopped, prior to it being started again.
    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "SecondActivity onRestart")
    }

    // Called when the activity is no longer visible to the user.
    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "SecondActivity onStop")
    }

    // The final call you receive before your activity is destroyed.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "SecondActivity onDestroy")
    }
}
