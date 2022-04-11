package agency.five.tmdb

import agency.five.tmdb.ui.theme.Content
import agency.five.tmdb.ui.theme.Router
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {

    val streamingItems = listOf(
        R.drawable.iron_man_1,
        R.drawable.gattaca,
        R.drawable.lion_king
    )
    val freeMovies = listOf(
        R.drawable.floppy_love,
        R.drawable.jungle_beat,
        R.drawable.captain_america
    )
    val trendingToday = listOf(
        R.drawable.iron_man2,
        R.drawable.godzilla,
        R.drawable.gattaca
    )
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 25.dp)
            .fillMaxWidth()
    ) {
        item {
            SearchBar()
        }

        item {
            Subtitle(text = "What's popular")
        }
        item {
            Whatspopular()
        }
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                items(streamingItems.size) { index ->
                    MovieCard(film = streamingItems[index])
                }
            }
        }
        item {
            Subtitle(text = "Free to Watch")
        }
        item {
            FreeToWatch()
        }
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                items(freeMovies.size) { index ->
                    MovieCard(film = freeMovies[index])
                }
            }
        }
        item {
            Subtitle(text = "Trending")
        }
        item {
            TrendingBar()
        }
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                items(trendingToday.size) { index ->
                    MovieCard(film = trendingToday[index])
                }
            }
        }
    }
}

@Composable
fun MovieCard(
    onMovieItemClick: () -> Unit = {
        Router.navigateTo(Content.Details)
    },
    film: Int
) {


    Box(modifier = Modifier
        .clickable { onMovieItemClick() }
        .padding(end = 10.dp, bottom = 10.dp)
    ) {
        Image(
            painter = painterResource(id = film),
            contentDescription = "",
            modifier = Modifier
                .size(width = 122.dp, height = 179.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )

        FavoriteButton()
    }
}


@Composable
fun FavoriteButton() {

    Box(modifier = Modifier
        .clip(CircleShape)
        .clickable {}
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_ellipse_1),
            contentDescription = ""
        )
        Image(
            painter = painterResource(
                id = R.drawable.like
            ),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
    }
    //nije implementirana mogucnost lajkanja kartice filma
}

@Composable
fun Subtitle(text: String) {
    Box(modifier = Modifier.padding(vertical = 1.dp)) {
        Text(
            text = text, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
            color = Color(0xFF0B253F)
        )

    }
}
@Composable
fun Subtitle(text: String, modifier:Modifier = Modifier) {
    Box(modifier = Modifier.padding(vertical = 1.dp).padding(start = 25.dp)) {
        Text(
            text = text, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
            color = Color(0xFF0B253F)
        )

    }
}

@Composable
fun Whatspopular() {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf("Streaming", "On TV", "For Rent", "In theaters")
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color(0xFFFFFFFF),
            contentColor = Color(0xFF0B253F),
            modifier = Modifier
                .height(25.dp)
                .clip(RoundedCornerShape(5.dp))
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title, fontSize = 9.sp, softWrap = false) })
            }
        }
    }


    //ovaj TabRow nisam znao kako skalirati da ne zauzima citavu siritu zaslona,
    //takoder kada bih povecao font slova u tabu dio teksta se nebi prikazao

    /*when (tabIndex) {
        0 ->
        1 ->
        2 ->
        3 ->
    }*/

}

@Composable
fun SearchBar() {
    TextField(
        value = "Search", onValueChange = {},
        modifier = Modifier
            .width(340.dp)
            .padding(bottom = 10.dp),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.loop),
                contentDescription = "loop"
            )
        },
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun FreeToWatch() {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf("Movies", "TV")
    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color(0xFFFFFFFF),
        contentColor = Color(0xFF0B253F),
        modifier = Modifier
            .height(25.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        tabTitles.forEachIndexed { index, title ->
            Tab(selected = tabIndex == index,
                onClick = { tabIndex = index },
                text = { Text(text = title, fontSize = 9.sp, softWrap = false) })
        }
    }
    /*when (tabIndex) {
        0 ->
        1 ->
    }*/
}


@Composable
fun TrendingBar() {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf("Today", "This week")
    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color(0xFFFFFFFF),
        contentColor = Color(0xFF0B253F),
        modifier = Modifier
            .height(25.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        tabTitles.forEachIndexed { index, title ->
            Tab(selected = tabIndex == index,
                onClick = { tabIndex = index },
                text = { Text(text = title, fontSize = 9.sp, softWrap = false) })
        }
    }
    /*when (tabIndex) {
        0 ->
        1 ->
    }*/
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
