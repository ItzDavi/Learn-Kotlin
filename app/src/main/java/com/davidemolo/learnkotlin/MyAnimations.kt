package com.davidemolo.learnkotlin

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils

class MyAnimations {

    companion object {
        //Costanti da usare
        const val slideInRight = R.anim.slide_in_right
        const val slideInUp = R.anim.slide_in_up
        const val slideInDown = R.anim.slide_in_down
        const val slideInLeft = R.anim.slide_in_left

        const val fastFadeIn = R.anim.fast_fade_in
        const val fastFadeOut = R.anim.fast_fade_out

        fun myAnimate(view: View, animation: Int, context: Context, visibility: Int ?= null) {
            val anim = AnimationUtils.loadAnimation(context, animation)
            view.startAnimation(anim)

            // Se la view non si vede, mettila visibile
            if (view.visibility == View.GONE || view.visibility == View.INVISIBLE) {
                view.visibility = View.VISIBLE

            // Se le view si vede, ma deve tornare INVISIBILE
            // (es. LessonDialog è l'unico file che richiede INVISIBLE anziché GONE perché sennò si bugga)
            // Qua uso "visibility" passata nei parametri così da capire se deve tornare INVISBILE o GONE
            } else if (view.visibility == View.VISIBLE && visibility == View.INVISIBLE) {
                view.visibility = View.INVISIBLE

            // Parte due del commento sopra
            } else if (view.visibility == View.VISIBLE && visibility == View.GONE) {
                view.visibility = View.GONE
            }
            // P.S. visibility è nullable ed è inizializzato a null, cosi non si deve per forza specificare
            // nelle varie activity il parametro "visibility" (viene usato solo una volta tipo nel LessonDialog con i testi)
            // !!! Quando hai letto e hai capito cosa fa sta roba cancella pure i commenti <3
        }
    }
}