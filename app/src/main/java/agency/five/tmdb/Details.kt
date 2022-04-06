package agency.five.tmdb

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun Details() {
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
                        .offset(60.dp))
                },
                navigationIcon = { Icon(painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "back", modifier = Modifier.padding(start = 16.dp), tint = Color(0xFFFFFFFF))}
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
    val ironManOverview = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil."
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 55.dp)) {
        item{
            TopBox(id = R.drawable.big_man, score = "76%", title = "Iron Man (2008)", date = "05/02/2008 (US)",
                genre = "Action, Science Fiction, Adventure", duration = "2h 6m")
        }
        item {
            Column(modifier = Modifier.padding(start = 25.dp, top = 15.dp)) {
                Subtitle(tekst = "Overview")
                Text(text = ironManOverview, modifier = Modifier.padding(top = 15.dp))
            }

        }
        item {
            Row(modifier = Modifier.padding(start = 25.dp)) {
                Grid1()
            }
        }
        item {
            Row(modifier = Modifier.padding(start = 25.dp)) {
                Grid2()
            }
        }
        item {
            Subtitle(tekst = "Top Billed Cast", modifier = Modifier.padding(start = 25.dp))
        }
    }


}

/**
 * commitat promjene na lokalni branch:
 * git add .
 * git commit -m "Rijesio yadacu"
 * git push origin develop
 *
 *
 */

@Composable
fun TopBox(id:Int, score: String, title: String, date: String, genre: String, duration: String) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)) {
        Image(painter = painterResource(id = id), contentDescription = title,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop)
        Box(modifier = Modifier
            .matchParentSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0x00000000),
                        Color(0xFF000000)
                    )
                )
            )){

        }

        Column(Modifier.padding(top = 130.dp, start = 15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.padding(end = 15.dp)) {
                    Image(painter = painterResource(id = R.drawable.ic_ellipse_1),
                        contentDescription = "")
                    Text(text = score,
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFFFFFFFF))
                }
                Text(text = "User Score", color = Color(0xFFFFFFFF));
            }
            Text(title, color = Color(0xFFFFFFFF), fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp, modifier = Modifier.padding(bottom = 5.dp))
            Text(date, color = Color(0xFFFFFFFF))
            Row(modifier = Modifier.padding(bottom = 10.dp)) {
                Text(text = genre, modifier = Modifier.padding(end = 10.dp)
                    , color = Color(0xFFFFFFFF))
                Text(text = duration, fontWeight = FontWeight.Bold , color = Color(0xFFFFFFFF)  )
            }
            Box(modifier = Modifier
                .clip(CircleShape)
                .clickable {}
            ) {
                Image(painter = painterResource(id = R.drawable.ic_ellipse_1),
                    contentDescription = "")
                Image(painter = painterResource(id = R.drawable.star),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}

@Composable
fun Grid1() {
    Column {
        Text(text = "Don Heck", fontWeight = FontWeight.Bold)
        Text(text = "Characters", modifier = Modifier.padding(bottom = 10.dp))
    }

    Column {
        Text(text = "Jack Kirby", fontWeight = FontWeight.Bold)
        Text(text = "Characters")
    }


    Column {
        Text(text = "Jon Favreau", fontWeight = FontWeight.Bold)
        Text(text = "Director")
    }

}
@Composable
fun Grid2() {
    Column {
        Text(text = "Don Heck", fontWeight = FontWeight.Bold)
        Text(text = "Screenplay")
    }

    Column {
        Text(text = "Jack Marcum", fontWeight = FontWeight.Bold)
        Text(text = "Screenplay")
    }

    Column {
        Text(text = "Matt Holloway", fontWeight = FontWeight.Bold)
        Text(text = "Screenplay")
    }
}
@ExperimentalFoundationApi
@Preview
@Composable
fun DetalisPreview() {
    //TopBox(id = R.drawable.iron_man_1, score = 76, title = "Iron Man (2008)", date = "05/02/2008 (US)",
        //genre = "Action, Science Fiction, Adveture", duration = "2h 6m")
    Details()
}