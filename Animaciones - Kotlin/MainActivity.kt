package es.ua.eps.animaciones

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var like = false

        likeImageView.setOnClickListener{
                like = likeAnimation(likeImageView, R.raw.bandai_dokkan, like)
            }
        }

    private fun likeAnimation(imageView: LottieAnimationView, animation: Int, like: Boolean) : Boolean {

            if (!like) {
                imageView.setAnimation(animation)
                imageView.playAnimation()
            } else {
                imageView.setImageResource(R.drawable.twitter_like)
            }

            return !like

        }
}