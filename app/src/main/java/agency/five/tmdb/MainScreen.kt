package agency.five.tmdb

import agency.five.tmdb.ui.theme.Content
import agency.five.tmdb.ui.theme.Router
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun MainScreen(content: String) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF0B253F)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        Modifier
                            .size(143.dp)
                    )
                }

            }
        },
        bottomBar = {
            BottomNavigation(
                contentColor = Color(0xFF0B253F),
                backgroundColor = Color(0xFFFFFFFF),
                elevation = 15.dp
            ) {
                BottomNavigationItem(selected = currscreen(), icon = {
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = "Home button"
                    )
                },
                    onClick = {
                        Router.navigateTo(Content.HomeScreen)
                    },
                    label = { Text(text = "Home") })
                BottomNavigationItem(selected = currscreen().not(), icon = {
                    Icon(
                        painterResource(id = R.drawable.fullheart),
                        contentDescription = "Favorites button"
                    )
                },
                    onClick = {
                        Router.navigateTo(Content.Favorites)
                    },
                    label = { Text(text = "Favorites") })
            }
        }

    ) {
        // dva composeabla koji predstavljau tabove: Home i Favorites

        // ovisno o paramteru content pozivas home ili favorites
        if (content == "home") {
            HomeScreen()
        } else if (content == "favorites") {
            Favorites()
        }
    }
}

fun currscreen(): Boolean {
    return return when (Router.currentContent) {
        Content.HomeScreen -> true
        Content.Favorites -> false
        Content.Details -> true
    }
}




