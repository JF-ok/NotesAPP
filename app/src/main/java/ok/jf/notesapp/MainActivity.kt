package ok.jf.notesapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ok.jf.notesapp.navigation.NotesNavHost
import ok.jf.notesapp.ui.theme.MainViewModel
import ok.jf.notesapp.ui.theme.NotesAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAPPTheme {
                val context = LocalContext.current
                val mViewModel: MainViewModel =
                    viewModel(factory = MainViewModel.MainViewModelFactory(context.applicationContext as Application))
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "NotesApp")
                            },
                            backgroundColor = Color.Magenta,
                            contentColor = Color.White,
                            elevation = 12.dp
                        )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ){
                            NotesNavHost(mViewModel)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAPPTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModel.MainViewModelFactory(context.applicationContext as Application))
    }
}