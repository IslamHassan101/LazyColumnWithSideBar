package com.islam.lazycolumnwithsidebar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.billythelittle.lazycolumns.LazyColumnScrollbarSettings
import com.billythelittle.lazycolumns.LazyColumnWithScrollbar
import com.islam.lazycolumnwithsidebar.ui.theme.LazyColumnWithSideBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExLazyColumnWithScrollBar(data = listOf(1,2,3,4,5,7,5,45,514,12354,5646,1,2,3,4,5,7,5,45,514,12354,5646))
        }
    }
}


@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun ExLazyColumnWithScrollBar(data: List<Int>) {
    val scrollbarSetting = remember {
        mutableStateOf(LazyColumnScrollbarSettings())
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumnWithScrollbar(
            data = data,
            settings = scrollbarSetting.value,
            modifier = Modifier.height(500.dp)
        ) {
            items(data) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable { }, elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column {
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = it.toString(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
        }
        Row {

        }

    }

}
