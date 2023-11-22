package com.example.basicc.ui.screen

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicc.R

//Chat UI

data class Details(val name: String, val role: String)

@Composable
fun Txt(person: Details) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded = remember { mutableStateOf(false) }
        val surfaceColor = animateColorAsState(if (isExpanded.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)
        Column(modifier = Modifier.clickable { isExpanded.value = !isExpanded.value }) {
            Text(
                text = person.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor.value,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = person.role,
                    maxLines = if (isExpanded.value) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(all = 5.dp),
                    style = MaterialTheme.typography.bodyMedium,
                )

            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode"
)
@Composable
fun PreviewTxt() {
    Txt(person = Details("Suraj", "Android Developer dkjbk d   sbkv bds kj bk js d sd jkbf skhbhkbhbvhfbjkvbfjbvkjbfk"))
}