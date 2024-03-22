package com.company.velogswitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.velogswitch.ui.theme.VelogSwitchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VelogSwitchTheme {
                SwitchStudy()

            }
        }
    }
}

// 스위치에 대한 정보를 담고 있는 데이터 클래스를 선언한다. 이 데이터 클래스의 객체를 스위치로 생각해도 된다.
data class SwithchInfo(
    var isChecked: Boolean,
    var text: String
)

@Composable
fun SwitchStudy() {
    // remember 키워드를 사용해서 switch 변수에 저장된 값은 컴포즈가 추적 할 수 있게 해준다.
    var switch by remember {
        mutableStateOf(
            SwithchInfo(
                isChecked = false,
                text = "독립형 옵션 또는 더 자세한 옵션"
            )
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(switch.text, Modifier.padding(start = 8.dp))
        Spacer(modifier = Modifier.weight(1f))
        // Switch를 활용해서 스위치를 만들 수 있다.
        Switch(
            checked = switch.isChecked,
            onCheckedChange = { isChecked ->
                switch = switch.copy(isChecked = isChecked)
            },
            Modifier.padding(end = 8.dp),
            // thumbContent의 람다식에 Icon을 넣어서 Switch에 아이콘을 넣을 수 있따.(Material3에서 새롭게 추가된 기능)
            thumbContent = {
                Icon(
                    imageVector = if(switch.isChecked) Icons.Default.Delete else Icons.Default.Lock,
                    contentDescription = null
                )
            }
            )
    }
}






















