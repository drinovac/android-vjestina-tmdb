package agency.five.tmdb

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun Try(){
    LazyVerticalGrid(cells = GridCells.Fixed(3), contentPadding = PaddingValues(vertical = 10.dp)) {
        item {
            Column {
                Text(text = "Don Heck", fontWeight = FontWeight.Bold)
                Text(text = "Characters", modifier = Modifier.padding(bottom = 10.dp))
            }
        }
        item {
            Column {
                Text(text = "Jack Kirby", fontWeight = FontWeight.Bold)
                Text(text = "Characters")
            }
        }
        item {
            Column {
                Text(text = "Jon Favreau", fontWeight = FontWeight.Bold)
                Text(text = "Director")
            }
        }
        item {
            Column {
                Text(text = "Don Heck", fontWeight = FontWeight.Bold)
                Text(text = "Screenplay")
            }
        }
        item {
            Column {
                Text(text = "Jack Marcum", fontWeight = FontWeight.Bold)
                Text(text = "Screenplay")
            }
        }
        item {
            Column {
                Text(text = "Matt Holloway", fontWeight = FontWeight.Bold)
                Text(text = "Screenplay")
            }
        }



    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun TryPreview() {
    Try()
}