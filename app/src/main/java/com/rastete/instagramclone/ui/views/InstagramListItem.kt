package com.rastete.instagramclone.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.rastete.instagramclone.R
import com.rastete.instagramclone.data.Story

@Composable
fun InstagramListItem(story: Story) {
    Column {
        ProfileInfoSection(story)
        InstagramImage(imageId = story.storyImageId)
        InstagramIconSection()
        InstagramLikesSection(story)
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            text = "View all ${story.commentsCount} comments",
            style = typography.caption,
            color = Color.Gray
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 8.dp),
            text = "${story.time} ago",
            style = typography.caption,
            color = Color.Gray
        )
    }
}

@Composable
fun ProfileInfoSection(story: Story) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            painter = rememberImagePainter(data = story.authorImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = story.author,
            style = typography.body1,
            modifier = Modifier
                .padding(8.dp)
                .weight(1f),
            textAlign = TextAlign.Left
        )
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }
}

@Composable
fun InstagramImage(imageId: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp),
        painter = rememberImagePainter(data = imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun InstagramIconSection() {
    Row {
        var isFavorite by remember { mutableStateOf(false) }
        IconToggleButton(checked = isFavorite, onCheckedChange = { isFavorite = it }) {
            val tint = if (isFavorite) Color.Red else MaterialTheme.colors.onBackground
            if (isFavorite)
                Icon(Icons.Default.Favorite, tint = tint, contentDescription = null)
            else
                Icon(Icons.Default.FavoriteBorder, tint = tint, contentDescription = null)
        }
        IconToggleButton(checked = false, onCheckedChange = {}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_chat_bubble_outline_24),
                contentDescription = null
            )
        }

        IconToggleButton(checked = false, onCheckedChange = {}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_near_me_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun InstagramLikesSection(story: Story) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape),
            painter = rememberImagePainter(data = story.authorImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = "Liked by ${story.author} and ${story.likesCount} others",
            style = typography.caption
        )


    }
}
