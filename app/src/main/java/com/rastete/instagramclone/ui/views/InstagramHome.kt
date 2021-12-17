package com.rastete.instagramclone.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rastete.instagramclone.R
import com.rastete.instagramclone.data.DataDummy

@Composable
fun InstagramHome() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Instagram") },
                backgroundColor = Color.White,
                elevation = 8.dp,
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_instagram),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_send),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            )
        },
        content = {
            InstagramHomeContent()
        }
    )
}

@Composable
fun InstagramHomeContent() {
    Column {
        InstagramStories()
        Divider()
        InstagramPostList()
    }
}

@Composable
fun InstagramPostList() {
    val stories = remember { DataDummy.storyList.filter { it.storyImageId != 0 } }
    LazyColumn {
        items(
            items = stories,
            itemContent = {
                InstagramListItem(story = it)
            }
        )
    }
}
