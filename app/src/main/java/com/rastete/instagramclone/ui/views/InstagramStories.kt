package com.rastete.instagramclone.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.rastete.instagramclone.data.DataDummy
import com.rastete.instagramclone.data.Story
import com.rastete.instagramclone.ui.theme.instagramGradient

@Composable
fun InstagramStories() {

    val stories = remember { DataDummy.storyList }

    LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
        items(stories) {
            StoryListItem(story = it)
        }
    }
}

@Composable
fun StoryListItem(story: Story) {

    val borderStroke =
        if (story.id == 1) {
            BorderStroke(
                width = 3.dp,
                color = Color.LightGray
            )
        } else {
            BorderStroke(
                width = 3.dp,
                brush = Brush.linearGradient(
                    colors = instagramGradient,
                    start = Offset(0f, 0f),
                    end = Offset(100f, 100f)
                )
            )
        }

    val imageModifier = Modifier
        .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        .height(60.dp)
        .width(60.dp)
        .clip(CircleShape)
        .border(
            shape = CircleShape,
            border = borderStroke
        )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberImagePainter(data = story.authorImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Text(
            text = story.author,
            style = typography.caption,
            textAlign = TextAlign.Center
        )
    }
}