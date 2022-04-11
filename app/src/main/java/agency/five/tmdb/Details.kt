package agency.five.tmdb

import agency.five.tmdb.ui.theme.Content
import agency.five.tmdb.ui.theme.Router
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.draw.shadow
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

    BackPressHandler(onBackPressed = { Router.navigateTo(Content.HomeScreen) })

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF0B253F),
                title = {
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
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable { Router.navigateTo(Content.HomeScreen) },
                        tint = Color(0xFFFFFFFF)
                    )
                }
            )

        }

    ) {

    }
    val ironManOverview =
        "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil."
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 55.dp)
    ) {
        item {
            TopBox(
                id = R.drawable.big_man,
                score = "76%",
                title = "Iron Man (2008)",
                date = "05/02/2008 (US)",
                genre = "Action, Science Fiction, Adventure",
                duration = "2h 6m"
            )
        }
        item {
            Column(modifier = Modifier.padding(start = 25.dp, top = 15.dp)) {
                Subtitle(text = "Overview")
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
            Row {
                Subtitle(text = "Top Billed Cast", modifier = Modifier.padding(start = 25.dp))
                Box(modifier = Modifier
                    .padding(start = 100.dp, bottom = 10.dp)
                    .clickable {}) {
                    Text("Full Cast & Crew")
                }
            }

        }
        item {
            LazyRow(modifier = Modifier.padding(start = 25.dp)) {
                item {
                    ActorCard(actor = R.drawable.actor_image)
                }
                item {
                    ActorCard(actor = R.drawable.actor_image)
                }
                item {
                    ActorCard(actor = R.drawable.actor_image)
                }
            }
        }
        // Ovaj dio dalje koji ide pod "Social" nisam napravio
        // mucilo me to sto se u Previewu prikazuje sav sadrzaj no kad se pokrene u emulatoru fale dijelovi
        // imao sam problem da stavljenjem novog Composablea se nebi prikazao
    }


}


@Composable
fun TopBox(id: Int, score: String, title: String, date: String, genre: String, duration: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = id), contentDescription = title,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x00000000),
                            Color(0xFF000000)
                        )
                    )
                )
        ) {

        }

        Column(Modifier.padding(top = 130.dp, start = 15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.padding(end = 15.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_ellipse_1),
                        contentDescription = ""
                    )
                    Text(
                        text = score,
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFFFFFFFF)
                    )
                }
                Text(text = "User Score", color = Color(0xFFFFFFFF))
            }
            Text(
                title, color = Color(0xFFFFFFFF), fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp, modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(date, color = Color(0xFFFFFFFF))
            Row(modifier = Modifier.padding(bottom = 10.dp)) {
                Text(
                    text = genre,
                    modifier = Modifier.padding(end = 10.dp),
                    color = Color(0xFFFFFFFF)
                )
                Text(text = duration, fontWeight = FontWeight.Bold, color = Color(0xFFFFFFFF))
            }
            Box(modifier = Modifier
                .clip(CircleShape)
                .clickable {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ellipse_1),
                    contentDescription = ""
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}

@Composable
fun Grid1() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 35.dp, top = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .height(55.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = "Don Heck", fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Text(text = "Characters", modifier = Modifier.align(Alignment.CenterStart))
        }

        Box(
            modifier = Modifier
                .height(55.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "Jack Kirby", fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Text(text = "Characters", modifier = Modifier.align(Alignment.CenterStart))
        }


        Box(
            modifier = Modifier
                .height(55.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = "Jon Favreau", fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Text(text = "Director", modifier = Modifier.align(Alignment.CenterStart))
        }
    }


}

@Composable
fun Grid2() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp, top = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .height(55.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = "Don Heck", fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Text(text = "Screenplay", modifier = Modifier.align(Alignment.CenterStart))
        }

        Box(
            modifier = Modifier
                .height(55.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "Jack Marcum", fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Text(text = "Screenplay", modifier = Modifier.align(Alignment.CenterStart))
        }


        Box(
            modifier = Modifier
                .height(55.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = "Matt Holloway", fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Text(text = "Screenplay", modifier = Modifier.align(Alignment.CenterStart))
        }
    }
}


@Composable
fun ActorCard(actor: Int, onActorItemClick: () -> Unit = {}) {

    Box(modifier = Modifier
        .clickable { onActorItemClick() }
        .padding(end = 10.dp, bottom = 10.dp)
        .size(width = 122.dp, height = 220.dp)
        .clip(RoundedCornerShape(10.dp)))
    {
        Column {
            Image(
                painter = painterResource(id = actor),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .height(80.dp)
                .padding(start = 5.dp, top = 5.dp)) {
                Text(text = "Robert Downey Jr.",
                    modifier = Modifier.align(Alignment.TopStart),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text("Tony Stark/Iron Man", modifier = Modifier.align(Alignment.BottomStart),
                fontSize = 10.sp)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun DetalisPreview() {
    Details()
}

