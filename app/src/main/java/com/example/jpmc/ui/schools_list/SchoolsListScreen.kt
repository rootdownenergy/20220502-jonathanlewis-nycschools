package com.example.jpmc.ui.schools_list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jpmc.R
import com.example.jpmc.ui.schools_list.components.SchoolItem
import com.example.jpmc.ui.schools_list.core.SchoolsListUiState
import com.example.jpmc.ui.theme.Blue200
import com.example.jpmc.ui.theme.Blue500
import com.example.jpmc.ui.theme.Blue700

@Composable
fun SchoolsListScreen(
    navController: NavController,
    vm: SchoolsListViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    val state = vm.uiState.collectAsState().value
    val height = with(LocalDensity.current) { LocalConfiguration.current
        .screenHeightDp.dp.toPx()
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
                 TopAppBar(
                     backgroundColor = Blue700,
                     title = {
                         Text(text = "NYC Schools")
                     }
                 )
        },
        content = {
            Column(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Gray, Color.Black),
                            0f,
                            height * 1.1f
                        )
                    )
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    when(state){
                        is SchoolsListUiState.Empty -> {
                            Text(text = "No Data Available")
                        }
                        is SchoolsListUiState.Loading -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                        is SchoolsListUiState.Error -> ErrorDialog(state.msg)
                        is SchoolsListUiState.Loaded -> {
                            LazyColumn(modifier = Modifier.fillMaxSize()){
                                items(state.data){ school ->
                                    SchoolItem(
                                        school = school,
                                        modifier = Modifier
                                            .clickable {
                                                Log.w("Ui", "IN UI ${school.dbn}")
                                                navController.navigate(
                                                    "details/${school.dbn}"
                                                ){
                                                    popUpTo("schools")
                                                }
                                            }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ErrorDialog(message: String) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = stringResource(R.string.schools_ls_error))
            },
            text = {
                Text(message)
            },
            confirmButton = {
                openDialog.value = false
            }
        )
    }
}