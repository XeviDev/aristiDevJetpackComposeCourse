package com.example.jetpackcomponentscatalog

import android.content.ClipData.Item
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Xevi", "Pepe", "Manolo", "Juan")
    LazyColumn {
        //Los recyclerView sólo reciben datos de tipo item
        item { Text(text = "Header") }

        items(myList) {
            Text(text = "hola me llamo $it")
        }
        item { Text(text = "Footer") }

    }
}

@ExperimentalFoundationApi
@Composable
fun SuperHeroStickyView() {
    //El context hay que tenerlo fuera de la función
    val context = LocalContext.current
    //Con esto lo que dice que si el publisher es MArvel, va a coger todos los objetos
    // que tengan de publisher MArvel
    val superHero: Map<String, List<SuperHero>> = getSuperHeroes().groupBy { it.publisher }
    //El spacedBy se encarga que entre los elementos haya el espacio dado
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHero.forEach { (publisher, mySuperHero) ->
            stickyHeader {
                Text(
                    text = publisher, modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green), fontSize = 16.sp, color = Color.White
                )
            }
            items(mySuperHero) {

                //Esto es para renombrar it
                    superhero ->
                //Al ponerle llaves es la lambda
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }

        }


    }
}

@Composable
fun SuperHeroView() {
    //El context hay que tenerlo fuera de la función
    val context = LocalContext.current
    //El spacedBy se encarga que entre los elementos haya el espacio dado
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) {
            //Esto es para renombrar it
                superhero ->
            //Al ponerle llaves es la lambda
            ItemHero(superHero = superhero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroWithSpecialControsView() {
    //El context hay que tenerlo fuera de la función
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    Column {
        //El spacedBy se encarga que entre los elementos haya el espacio dado
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) {
                //Esto es para renombrar it
                    superhero ->
                //Al ponerle llaves es la lambda
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        //Recordar de importar el runtime.*
        val showButton by remember {
            //Si no ponemos el derivedStateOf, lo que haría sería que
            //cada vez que se mueve un pixel, haría la comprobación.
            // Y ESO NO ES ÓPTIMO.

            //Es un estado intermedio que lo simplifica
            derivedStateOf { rvState.firstVisibleItemIndex > 0 }
        }
        if (showButton) {
            Button(
                onClick = {
                    coroutinesScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un Boton molon")
            }
        }
    }

}

@Composable
fun SuperHeroGridView() {
    //El context hay que tenerlo fuera de la función
    val context = LocalContext.current
    //El spacedBy se encarga que entre los elementos haya el espacio dado
    //El content padding pone padding alrededor del grid, NO entre elementos
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        content = {
            items(getSuperHeroes()) {
                //Esto es para renombrar it
                    superhero ->
                //Al ponerle llaves es la lambda
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        })
}

@Composable
//Le pasamos el evento del item selected y hacemos que en la lambda queremos que devuelva
// el objeto SuperHero
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "superHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(4.dp)
            )
        }

    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Logan", "Logan", "Logan", R.drawable.logan),
        SuperHero("Batman", "Batman Parker", "Marvel", R.drawable.batman),
        SuperHero("Thor", "Thor", "Thor", R.drawable.thor),
        SuperHero("Flash", "Flash", "Flash", R.drawable.flash),
        SuperHero("Green Lantern", "Green Lantern", "Marvel", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Wonder Woman", "Wonder Woman", R.drawable.wonder_woman)
    )
}