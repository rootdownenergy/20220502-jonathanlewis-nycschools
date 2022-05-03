package com.example.jpmc.ui.school_details.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.ui.theme.Blue500
import com.example.jpmc.ui.theme.Blue700
import com.example.jpmc.ui.theme.Yellow200

@Composable
fun SchoolDetailItem(
    school: SchoolsListRemote,
    sat: SchoolsSatRemote?
){
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(all = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(Blue700.toArgb()))
                .padding(4.dp)
        ) {
            Text(
                text = school.schoolName.toString(),
                style = MaterialTheme.typography.h6,
                color = Color.Cyan,
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(
                text = school.website.toString(),
                style = MaterialTheme.typography.h6,
                color = Color.Cyan,
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(
                text = school.attendanceRate.toString(),
                style = MaterialTheme.typography.h6,
                color = Color.Cyan,
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
        }
    }
}