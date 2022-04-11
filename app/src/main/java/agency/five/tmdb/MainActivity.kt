package agency.five.tmdb

import agency.five.tmdb.ui.theme.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TmdbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // kreirati router i state u routeri prema live coding primjeri
                    // ovdje obesrvati state (home, favorites, detais)
                    // za home i favorites stanje pozivas MainScreen(home) ili MainScreen(favorites)
                    // za details pozivas DetailsScreen

                    /*when (router.state) {
                        home ->  HomeScreen(home)
                        favorites ->
                        details ->
                    }
                    HomeScreen(favorites)
                    DetailsScreen()*/

                    when(Router.currentContent) {
                        Content.HomeScreen -> MainScreen("home")
                        Content.Favorites -> MainScreen("favorites")
                        Content.Details -> Details()
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TmdbTheme {
        MainScreen("home")
    }
}