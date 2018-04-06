package io.a2xe.experiments.myapplicationdabuttare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openCar()
        turnLightsOn()
    }

    override fun onRestart() {
        super.onRestart()

        engineGoing().let {
           when(it) {
               false -> startEngine()
           }
        }
    }

    override fun onStart() {
        super.onStart()

        startEngine()
        openCar()
    }

    override fun onPause() {
        super.onPause()

        applyFootBrake()
        carInNeutral()
        applyHandBrake()
    }

    override fun onResume() {
        super.onResume()

        applyFootBrake()
        releaseHandBrake()
        carInGear()
        drive()
    }

    override fun onDestroy() {
        super.onDestroy()

        turnLightsOff()
        stopEngine()
    }
}

fun openCar() = println("openCar")
fun startEngine() = println("startEngine")
fun engineGoing() = println("engineGoing")
fun stopEngine() = println("stopEngine")
fun turnLightsOn() = println("turnLightsOn")
fun turnLightsOff() = println("turnLightsOff")
fun applyFootBrake() = println("applyFootBrake")
fun releaseHandBrake() = println("releaseHandBrake")
fun applyHandBrake() = println("applyHandBrake")
fun carInGear() = println("carInGear")
fun carInNeutral() = println("carInNeutral")
fun drive() = println("drive")
