package com.example.teledoneandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.teledoneandroid.data.Datasource
import com.example.teledoneandroid.model.Task
import com.example.teledoneandroid.ui.theme.TeledoneAndroidTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        setContent {
            TeledoneAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Navigation()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}

@Composable
fun ComposeTeledoneApp(navController: NavController, title: String?, modifier: Modifier = Modifier) {
    var countTasks by remember { mutableStateOf(0) }
    val taskList = Datasource().loadTasks()

    Column (
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        TopPanel(modifier = Modifier
            .weight(0.1f)
            .background(MaterialTheme.colorScheme.primaryContainer))
        MainPanel(modifier = Modifier.weight(0.1f))
        InfoPanel(taskList, modifier = Modifier.weight(0.6f))
        NewTaskPanel(
            onButtonClick = {
                navController.navigate(Screen.NewTaskScreen.route)
                            },
            modifier = Modifier
                .weight(0.1f)
                .align(Alignment.End))
        CategoryPanel(modifier = Modifier
            .weight(0.1f)
            .background(MaterialTheme.colorScheme.primaryContainer))
    }
}

@Composable
fun TopPanel(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Column(modifier = Modifier
            .weight(0.6f)
            .fillMaxHeight()
        ) {
            Text(
                text = "Home",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Today",
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
fun InfoPanel(tasksList: List<Task>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(tasksList) { task ->
            TaskComponent(task = task)
        }
    }
}

@Composable
fun NewTaskPanel(onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier
    ) {
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .fillMaxHeight(),
            content = {
                Image(
                    painter = painterResource(id = R.drawable.plus__96),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(MaterialTheme.shapes.small)
                )
            }
        )

    }
}

@Composable
fun CategoryPanel(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
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
fun TaskComponent(task: Task, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.onSecondary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = null,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                Text(
                    text = stringResource(id = task.title),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "here will be date",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            TaskItemButton(
                expanded = expanded,
                onClick = { expanded = !expanded }
            )
        }
        if (expanded) {
            TaskDetails(
                "Details about task",
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

@Composable
private fun TaskItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun TaskDetails(
    details: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = details,
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier
    )
}

@Preview
@Composable
fun TeledonePreview() {
    TeledoneAndroidTheme(darkTheme = false) {
        ComposeTeledoneApp(navController = rememberNavController(), title = "test title")
        //NewTaskLayout(navController = rememberNavController())
    }
}