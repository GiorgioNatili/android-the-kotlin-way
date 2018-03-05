package io.a2xe.experiments.selfielifecycle.views

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import io.a2xe.experiments.selfielifecycle.R
import io.a2xe.experiments.selfielifecycle.SelfieLifecycle
import io.a2xe.experiments.selfielifecycle.utilities.setupPermissions
import io.a2xe.experiments.selfielifecycle.utilities.swipeOrTap
import io.a2xe.experiments.selfielifecycle.utilities.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root_layout.swipeOrTap({
            resetView()
        }, {
            setupPermissions(Manifest.permission.CAMERA, CAMERA_ACCESS) {
                takePicture()
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            CAMERA_ACCESS -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    getString(R.string.permissions_denied).toast(this)
                } else {
                    takePicture()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when(requestCode == IMAGE_CAPTURE && resultCode == RESULT_OK) {
            true -> {
                renderImage(data)
                overlayText.text = SelfieLifecycle.lifecycleLogs.all
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun resetView() {
        imageView.setImageBitmap(null)
        overlayText.text = ""
    }

    private fun renderImage(data: Intent?) {
        data?.extras?.let {
            val imageBitmap = it.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    private fun takePicture() {

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1)
        intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", 1)

        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, IMAGE_CAPTURE)
        }
    }
}
