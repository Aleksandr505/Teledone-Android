package com.example.teledoneandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teledoneandroid.ui.theme.TeledoneAndroidTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeledoneAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ComposeTeledoneApp()
                }
            }
        }
    }
}

@Composable
fun ComposeTeledoneApp() {
    var countTasks by remember { mutableStateOf(0) }

    Column (modifier = Modifier.background(Color.White)) {
        TopPanel(modifier = Modifier.weight(0.1f))
        MainPanel(modifier = Modifier.weight(0.1f))
        InfoPanel(countTasks, modifier = Modifier.weight(0.6f))
        NewTaskPanel(onButtonClick = { countTasks++ }, modifier = Modifier
            .weight(0.1f)
            .align(Alignment.End))
        CategoryPanel(modifier = Modifier.weight(0.1f))
    }
}

@Composable
fun TopPanel(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.Blue)
    ) {
        Column(modifier = Modifier
            .weight(0.6f)
            .fillMaxHeight()
        ) {
            Text(
                text = "Home",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Today",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
    }
}



@Composable
fun MainPanel(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        )
    }
}

@Composable
fun InfoPanel(countTasks: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        repeat(countTasks) {
            Task()
        }
    }
}

@Composable
fun NewTaskPanel(onButtonClick: () -> Unit ,modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .background(Color.White)
    ) {
        Button(
            onClick = onButtonClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxHeight(),
            content = {
                Image(
                    painter = painterResource(id = R.drawable.plus__96),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }
        )

    }
}

@Composable
fun CategoryPanel(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.Blue)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
        )
        Image(
            painter = painterResource(id = R.drawable.icons8__96),
            contentDescription = null,
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
        )
    }
}

@Composable
fun Task(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = null,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier
                .weight(0.7f)
                .padding(8.dp)
        ) {
            Text(text = "Task name")
            Text(text = "date")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TeledoneAndroidTheme {
        ComposeTeledoneApp()
    }
}