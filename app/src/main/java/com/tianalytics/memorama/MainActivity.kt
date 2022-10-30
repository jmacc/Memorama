package com.tianalytics.memorama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

	var listaImageViewRotas = ArrayList<ImageView>()
	var listaImageView = ArrayList<ImageView>()
	var listaPosiciones = ArrayList<Int>()
	var listaClaseImagen = ArrayList<Imagen>()


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		listaImageView.add(img0)
		listaImageView.add(img1)
		listaImageView.add(img2)
		listaImageView.add(img3)
		listaImageView.add(img4)
		listaImageView.add(img5)
		listaImageView.add(img6)
		listaImageView.add(img7)
		listaImageView.add(img8)

		listaImageViewRotas.add(img0Rota)
		listaImageViewRotas.add(img1Rota)
		listaImageViewRotas.add(img2Rota)
		listaImageViewRotas.add(img3Rota)
		listaImageViewRotas.add(img4Rota)
		listaImageViewRotas.add(img5Rota)
		listaImageViewRotas.add(img6Rota)
		listaImageViewRotas.add(img7Rota)
		listaImageViewRotas.add(img8Rota)

		ocultarImagenes()
		cargarPosicionesRandom()

	}
//mostrar el inicio del juego

	fun ocultarImagenes(){
		for (i in 0..7){
			listaImageViewRotas[i].visibility = View.VISIBLE
			listaImageView[i].visibility = View.INVISIBLE
		}
	}

	/**
	  * Mostrar arreglo Ordenado
	 */
		fun cargarPosicionesRandom(){
			listaPosiciones.add(0)
			listaPosiciones.add(2)
			listaPosiciones.add(3)
			listaPosiciones.add(4)
			listaPosiciones.add(5)
			listaPosiciones.add(6)
			listaPosiciones.add(7)
			Log.d("mensaje","original $listaPosiciones")
		/**
		 * Mostrar Arreglo desordenado
		 */
		Collection.shuffle(listaPosiciones)
		Log.d("mensaje","original $listaPosiciones")

		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())

		/**
		 * Cada imagen debe de tener dos posiciones random
		 */
		for(i in 0..7)
		var posicion = listaPosiciones[i]
			var id_vector = 0

		when(i){
			0,1 -> { id_vector = R.drawable.ic_carriola}
			2,3 -> {id_vector = R.drawable.ic_deck}
			4,5 -> {id_vector = R.drawable.ic_station}
			6,7 -> {id_vector =R.drawable.ic_transportation}
		}

	}
}