package com.davidemolo.learnkotlin

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils

class MyAnimations {

    companion object {
        const val slideInRight = R.anim.slide_in_right
        const val slideInUp = R.anim.slide_in_up
        const val slideInDown = R.anim.slide_in_down
        const val slideInLeft = R.anim.slide_in_left

        const val fastFadeIn = R.anim.fast_fade_in
        const val fastFadeOut = R.anim.fast_fade_out

        fun myAnimate(view: View, animation: Int, context: Context, visibility: Int ?= null) {
            val anim = AnimationUtils.loadAnimation(context, animation)
            view.startAnimation(anim)

            //Change to VISIBLE
            if (view.visibility == View.GONE || view.visibility == View.INVISIBLE) view.visibility = View.VISIBLE

            //If it is VISIBLE and it was INVISIBLE before, set to INVISIBLE
            else if (view.visibility == View.VISIBLE && visibility == View.INVISIBLE) view.visibility = View.INVISIBLE

            //If it is VISIBLE and it was GONE before, set to GONE
            else if (view.visibility == View.VISIBLE && visibility == View.GONE) view.visibility = View.GONE
        }
    }
}