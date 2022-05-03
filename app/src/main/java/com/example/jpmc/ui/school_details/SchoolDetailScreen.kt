package com.example.jpmc.ui.school_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.ui.school_details.components.SchoolDetailItem
import com.example.jpmc.ui.school_details.core.SchoolDetailUiState
import com.example.jpmc.ui.schools_list.ErrorDialog
import com.example.jpmc.ui.schools_list.components.SchoolItem
import com.example.jpmc.ui.theme.Blue500

@Composable
fun SchoolDetailScreen(
    navController: NavController,
    vm: SchoolDetailViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    val state = vm.uiState.collectAsState().value
    val height = with(LocalDensity.current) { LocalConfiguration.current
        .screenHeightDp.dp.toPx()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Blue500,
                title = {
                    Text(text = "NYC School Details")
                }
            )
        },
        scaffoldState = scaffoldState
    ) {
        when(state){
            is SchoolDetailUiState.Error -> {
                ErrorDialog(state.msg)
            }
            is SchoolDetailUiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
            is SchoolDetailUiState.Empty -> {
                Text(text = "No Data Available")
            }
            is SchoolDetailUiState.Loaded -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, Color.Gray, Color.Black),
                                0f,
                                height * 1.1f
                            )
                        )
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SchoolDetailItem(school = state.dataSchool, sat = state.dataSat)
                    }
                }
            }
        }
    }
}
