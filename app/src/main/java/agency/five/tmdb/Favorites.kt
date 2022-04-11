package agency.five.tmdb

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

    Column(modifier = Modifier.padding(top = 20.dp, start = 25.dp)) {
        Subtitle(text = "Favorites")
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