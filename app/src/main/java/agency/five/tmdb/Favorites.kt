package agency.five.tmdb

import android.view.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun Favorites() {

    val favoriteMovies = listOf(
        R.drawable.iron_man_1,
        R.drawable.gattaca,
        R.drawable.lion_king,
        R.drawable.floppy_love,
        R.drawable.jungle_beat,
        R.drawable.captain_america
    )

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar (
                backgroundColor = Color(0xFF0B253F),
                title = { Image(painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    Modifier
                        .size(143.dp)
                        .offset(109.dp))
                },

                )
        },
        bottomBar = {
            BottomNavigation(
                contentColor = Color(0xFF0B253F),
                backgroundColor = Color(0xFFFFFFFF),
                elevation = 15.dp) {
                BottomNavigationItem(selected = false, icon = {
                    Icon(
                        painterResource(id = R.drawable.home),
                    contentDescription = "")
                },
                    onClick = {},
                    label = { Text(text = "Home") })
                BottomNavigationItem(selected = true, icon = {
                    Icon(
                        painterResource(id = R.drawable.fullheart),
                    contentDescription = "")
                },
                    onClick = {},
                    label = { Text(text = "Favourites") })


            }
        }

    ) {}

    Column(modifier = Modifier.padding(top = 70.dp, start = 25.dp)) {
        Subtitle(tekst = "Favorites")
        LazyVerticalGrid(cells = GridCells.Fixed(3), contentPadding = PaddingValues(vertical = 10.dp)) {
            items(favoriteMovies.size) {
                    index ->  MovieCard(film = favoriteMovies.get(index))
            }
        }
    }

}




@ExperimentalFoundationApi
@Preview
@Composable
fun FavoritesPreview() {
    Favorites()
}