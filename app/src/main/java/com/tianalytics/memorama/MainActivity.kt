package com.tianalytics.memorama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.tianalytics.memorama.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
	// declaramos ViewBinding
	private lateinit var binding: ActivityMainBinding

	private var listaImageViewRotas = ArrayList<ImageView>()
	private var listaImageView = ArrayList<ImageView>()
	private var listaPosiciones = ArrayList<Int>()
	private var listaClaseImagen = ArrayList<Imagen>()


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		//inicializamos viewBinding
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		listaImageView.add(binding.img0)
		listaImageView.add(binding.img1)
		listaImageView.add(binding.img2)
		listaImageView.add(binding.img3)
		listaImageView.add(binding.img4)
		listaImageView.add(binding.img5)
		listaImageView.add(binding.img6)
		listaImageView.add(binding.img7)

		listaImageViewRotas.add(binding.img0Rota)
		listaImageViewRotas.add(binding.img1Rota)
		listaImageViewRotas.add(binding.img2Rota)
		listaImageViewRotas.add(binding.img3Rota)
		listaImageViewRotas.add(binding.img4Rota)
		listaImageViewRotas.add(binding.img5Rota)
		listaImageViewRotas.add(binding.img6Rota)
		listaImageViewRotas.add(binding.img7Rota)


		ocultarImagenes()
		cargarPosicionesRandom()
		/**
		 * Nos permite visualizar las imagenes en forma aleatoria
		 */
		//mostrarImagenes()

	}
//mostrar el inicio del juego

	private fun ocultarImagenes() {
		for (i in 0..7) {
			listaImageViewRotas[i].visibility = View.INVISIBLE
			listaImageView[i].visibility = View.INVISIBLE
		}
	}

	private fun mostrarImagenes() {
		for (i in 0..7) {
			listaImageViewRotas[i].visibility = View.INVISIBLE
			listaImageView[i].visibility = View.VISIBLE
		}
	}

	/**
	 * Mostrar arreglo Ordenado
	 */
	private fun cargarPosicionesRandom() {
		listaPosiciones.add(0)
		listaPosiciones.add(1)
		listaPosiciones.add(2)
		listaPosiciones.add(3)
		listaPosiciones.add(4)
		listaPosiciones.add(5)
		listaPosiciones.add(6)
		listaPosiciones.add(7)
		Log.d("mensaje", "original $listaPosiciones")

		/**
		 * Mostrar Arreglo desordenado
		 */

		Collections.shuffle(listaPosiciones)

		//shuffled(listaPosiciones)
		Log.d("mensaje", "desordenado $listaPosiciones")
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())
		listaClaseImagen.add(Imagen())

		/**
		 * each image should have two random positions
		 */
		for (i in 0..7) {
			val posiciones = listaPosiciones[i]
			var idDrawable = 0

			when (i) {
				0, 1 -> {
					idDrawable = R.drawable.ic_carriola
				}
				2, 3 -> {
					idDrawable = R.drawable.ic_deck
				}
				4, 5 -> {
					idDrawable = R.drawable.ic_station
				}
				6, 7 -> {
					idDrawable = R.drawable.ic_transportation
				}
			}
		/**
		 * agregar imagenes al view
		 */
		listaImageView[posiciones].setImageResource(idDrawable)
		val objetoImagen = Imagen().apply { this.id_vector = idDrawable }

		/**
		 * We place each image in its position
		 */
		listaClaseImagen[posiciones] = objetoImagen
	}
}
}