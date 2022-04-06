package agency.five.tmdb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(content) { //content moze biti home ili favorites

    var streamingItems = listOf(
        R.drawable.iron_man_1,
        R.drawable.gattaca,
        R.drawable.lion_king
    )
    var freeMovies = listOf(
        R.drawable.floppy_love,
        R.drawable.jungle_beat,
        R.drawable.captain_america
    )
    var trendingToday = listOf(
        R.drawable.iron_man2,
        R.drawable.godzilla,
        R.drawable.gattaca
    )
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF0B253F)
            ) {
                // ili s boxom rijesiti centriranje ili provjeriti Image parametre (content align itd)
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    Modifier
                        .size(143.dp)
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                contentColor = Color(0xFF0B253F),
                backgroundColor = Color(0xFFFFFFFF),
                elevation = 15.dp
            ) {
                BottomNavigationItem(selected = true, icon = {
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = "Home button"
                    )
                },
                    onClick = {},
                    label = { Text(text = "Home") })
                BottomNavigationItem(selected = false, icon = {
                    Icon(
                        painterResource(id = R.drawable.like),
                        contentDescription = "Favorites button"
                    )
                },
                    onClick = {},
                    label = { Text(text = "Favorites") })
            }
        }

    ) {
        // dva composeabla koji predstavljau tabove: Home i Favorites

        // ovisno o paramteru content pozivas home ili favorites
    }

    LazyColumn(
        modifier = Modifier
            .padding(vertical = 80.dp, horizontal = 25.dp)
            .fillMaxWidth()
    ) {
        item {
            SearchBar()
        }

        item {
            Subtitle(tekst = "What's popular")
        }
        item {
            WhatspopularBar()
        }
        item {
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)) {
                items(streamingItems.size) { index ->
                    MovieCard(film = streamingItems.get(index))
                }
            }
        }
        item {
            Subtitle(tekst = "Free to Watch")
        }
        item {
            FreeToWatchBar()
        }
        item {
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)) {
                items(freeMovies.size) { index ->
                    MovieCard(film = freeMovies.get(index))
                }
            }
        }
        item {
            Subtitle(tekst = "Trending")
        }
        item {
            TrendingBar()
        }
        item {
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)) {
                items(trendingToday.size) { index ->
                    MovieCard(film = trendingToday.get(index))
                }
            }
        }
    }
}

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    onMovieItemClick: () -> Unit = {},
    movie: Movie //data class sa propertiji
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

        FavoriteButton(
            modifier = Modifier
                .padding(start = 9.dp, top = 9.dp)
        )
    }
}

@Composable
fun FavoriteButton(modifier: Modifier) {
    Box(modifier = Modifier
        .clip(CircleShape)
        .clickable {}
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_ellipse_1),
            contentDescription = ""
        )
        Image(
            painter = painterResource(id = R.drawable.like),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun Subtitle(tekst: String) {
    Box(modifier = Modifier.padding(vertical = 1.dp)) {
        Text(
            text = tekst, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
            color = Color(0xFF0B253F)
        )

    }
}

@Composable
fun Subtitle(tekst: String, modifier: Modifier) {
    Box(modifier = Modifier.padding(vertical = 1.dp)) {
        Text(
            text = tekst, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
            color = Color(0xFF0B253F)
        )

    }
}

@Composable
fun WhatspopularBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.clickable { }) {
            Text(
                "Streaming", style = TextStyle(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.Bold
            )
        }
        Box(modifier = Modifier.clickable { }) {
            Text(
                "On TV",
                fontWeight = FontWeight.Bold
            )
        }
        Box(modifier = Modifier.clickable { }) {
            Text(
                "For Rent",
                fontWeight = FontWeight.Bold
            )
        }
        Box(modifier = Modifier.clickable { }) {
            Text(
                "In theaters",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "Search", onValueChange = {},
        modifier = Modifier.width(340.dp),
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
fun FreeToWatchBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier.clickable { }) {
            Text(
                "Movies", style = TextStyle(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            "TV", modifier = Modifier.padding(start = 25.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TrendingBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier.clickable { }) {
            Text(
                "Today", style = TextStyle(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            "This week", modifier = Modifier.padding(start = 25.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
