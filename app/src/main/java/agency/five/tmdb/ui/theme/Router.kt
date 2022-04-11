package agency.five.tmdb.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class Content() {
    object HomeScreen : Content()
    object Favorites : Content()
    object Details : Content()
}

object Router {
    var currentContent : Content by mutableStateOf(Content.HomeScreen)

    fun navigateTo(destination: Content) {
        currentContent = destination
    }
}
