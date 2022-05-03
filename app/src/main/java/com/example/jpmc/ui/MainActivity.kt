package com.example.jpmc.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jpmc.ui.school_details.SchoolDetailScreen
import com.example.jpmc.ui.schools_list.SchoolsListScreen
import com.example.jpmc.ui.theme.JpmcTheme
import com.example.jpmc.ui.util.ScreenRouting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpmcTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "schools",
                    ){
                        composable(
                            "schools"
                        ){
                            SchoolsListScreen(navController = navController)
                        }
                        composable(
                            "details/{dbn}",
                            arguments = listOf(navArgument(name = "dbn"){ type = NavType.StringType })
                        ){
                            SchoolDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JpmcTheme {
        Greeting("Android")
    }
}