package com.tianalytics.memorama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.tianalytics.memorama.databinding.ActivityMainBinding
import java.sql.Time
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
	// declaramos ViewBinding
	private lateinit var binding: ActivityMainBinding

	private var listaImageViewRotas = ArrayList<ImageView>()
	private var listaImageView = ArrayList<ImageView>()
	private var listaPosiciones = ArrayList<Int>()
	private var listaClaseImagen = ArrayList<Imagen>()

	private var imagenUno = Imagen()
	private var imagenDos = Imagen()


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
		 * @fun mostrarImagenes()
		 * Nos permite visualizar las imagenes en forma aleatoria
		 */
		//mostrarImagenes()

	}
//mostrar el inicio del juego

	private fun ocultarImagenes() {
		for (i in 0..7) {
			listaImageViewRotas[i].visibility = View.VISIBLE
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
		 * add images to view
		 */
		listaImageView[posiciones].setImageResource(idDrawable)
		val objetoImagen = Imagen().apply { this.id_vector = idDrawable }

		/**
		 * We place each image in its position
		 */
		listaClaseImagen[posiciones] = objetoImagen
	}
}

	 fun procesarImagen(imagenView: View){
		var posicionSeleccionada:Int = imagenView.tag.toString().toInt()
		var id:String =imagenView.resources.getResourceEntryName(imagenView.id)
		/**
		 * Show images on click
		 */
		if(imagenView is ImageView){
			when (id){
				"img0Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img1Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img2Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img3Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img4Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img5Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img6Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img7Rota" -> {
					mostrarOcultarImagen(posicionSeleccionada,true)
				}
				"img0" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img1" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img2" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img3" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img4" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img5" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img6" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
				"img7" -> {
					mostrarOcultarImagen(posicionSeleccionada,false)
				}
			}
		}
		 asignarImagen(posicionSeleccionada,true)
	}

	private fun mostrarOcultarImagen(posicion:Int,mostrar:Boolean){
		if (mostrar){
			listaImageViewRotas[posicion].visibility = View.INVISIBLE
			listaImageView[posicion].visibility = View.VISIBLE
		}
		else{
			listaImageViewRotas[posicion].visibility = View.VISIBLE
			listaImageView[posicion].visibility = View.INVISIBLE
		}
	}

	private fun asignarImagen(posicion: Int,mostrar: Boolean){
		if (imagenUno.asignada){
			imagenDos = listaClaseImagen[posicion]
			imagenDos.posicion = posicion
			imagenDos.asignada = true

			if(imagenUno.id_vector == imagenDos.id_vector){
				mostrarMensaje("Seleccionaste el Correcto")
			}else{
				mostrarMensaje("Fallaste Intenta de Nuevo")
				//TimeUnit.SECONDS.sleep(30)
				Handler(Looper.getMainLooper()).postDelayed({
				mostrarOcultarImagen(imagenUno.posicion,false)
				mostrarOcultarImagen(imagenDos.posicion,false)
				},400)

			}
			imagenUno.asignada = false
			imagenDos.asignada = false

		}else{
			imagenUno = listaClaseImagen[posicion]
			imagenUno.asignada = true
			imagenUno.posicion = posicion
		}
	}

	private fun mostrarMensaje(msg:String){
		Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
	}

	private fun reiniciarJuego(view: View){
		var intent = getIntent()
		finish()
		startActivity(intent)
	}
}