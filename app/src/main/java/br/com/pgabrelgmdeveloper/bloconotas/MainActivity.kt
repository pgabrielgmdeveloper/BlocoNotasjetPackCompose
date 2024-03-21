package br.com.pgabrelgmdeveloper.bloconotas

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.pgabrelgmdeveloper.bloconotas.ui.theme.BlocoNotasTheme
import br.com.pgabrelgmdeveloper.bloconotas.ui.theme.GOLD

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlocoNotasTheme {
                BlocoDeNotas()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlocoDeNotas() {
    var notas by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
        TopAppBar(
            title = { Text("Bloco de notas", color = Color.Black, fontWeight = FontWeight.Bold)},
            colors = TopAppBarDefaults.topAppBarColors(containerColor = GOLD))
        },
        containerColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = GOLD,
                elevation =  FloatingActionButtonDefaults.elevation(8.dp),
                
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic__save_24), contentDescription = "Icone da save", tint = Color.White)
            }
        }
    )
    {
        TextField(
            value = notas, 
            onValueChange = {
            notas = it
        },
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            label = { Text("Digite sua anotação...")},
            colors = TextFieldDefaults.colors(focusedLabelColor = Color.White)
        )
    }
}