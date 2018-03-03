package io.a2xe.experiments.selfielifecycle.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.a2xe.experiments.selfielifecycle.R
import kotlinx.android.synthetic.main.activity_main.*
import android.provider.MediaStore
import android.content.Intent
import android.graphics.Bitmap
import io.a2xe.experiments.selfielifecycle.SelfieLifecycle
import io.a2xe.experiments.selfielifecycle.utilities.swipeOrTap

class MainActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val takePicture = fun() {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

        val dismissData = fun() {
            imageView.setImageBitmap(null)
            overlayText.text = ""
        }

        root_layout.swipeOrTap(dismissData, takePicture)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            data?.extras?.let {
                val imageBitmap = it.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
                overlayText.text = (application as SelfieLifecycle).lifecycleLogs.all
            }
        }
    }
}
