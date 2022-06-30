package com.example.lab07_sensores

import android.content.Intent
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//ACELEROMETRO
class Sensor1 : AppCompatActivity(),SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var textX:TextView
    private lateinit var textY:TextView
    private lateinit var textZ:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor1)

        // BUSQUEDA
         textX = findViewById(R.id.gradoX)
         textY = findViewById(R.id.gradoY)
         textZ = findViewById(R.id.gradoZ)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        //SENSOR
        setUpSensor()
        val btnBack: Button = findViewById(R.id.buttonBack)


        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setUpSensor(){
        //INICIALIZACION DE SENSOR
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        // DEFINICION DE TIPO DE SENSOR
        sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL,SensorManager.SENSOR_DELAY_NORMAL)
        }

    }
    override fun onSensorChanged(event: SensorEvent?) {
        //CONDICIONAL QUE INDICA SI SE ELIGIO EL SENSOR ACELEROMETRO
        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
            // ASIGNACION
            textX.text = ("X: "+("%.2f".format(x).toDouble()).toString()+"\nX: "+x.toInt().toString())
            textY.text = ("Y: "+("%.2f".format(y).toDouble()).toString()+"\nY: "+y.toInt().toString())
            textZ.text = ("Z: "+("%.2f".format(z).toDouble()).toString()+"\nZ: "+z.toInt().toString())
        }
        if(event?.sensor?.type == Sensor.TYPE_MAGNETIC_FIELD){
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            // ASIGNACION
            textX.text = ("X: "+("%.2f".format(x).toDouble()).toString()+"\nX: "+x.toInt().toString())
            textY.text = ("Y: "+("%.2f".format(y).toDouble()).toString()+"\nY: "+y.toInt().toString())
            textZ.text = ("Z: "+("%.2f".format(z).toDouble()).toString()+"\nZ: "+z.toInt().toString())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener((this))
        super.onDestroy()
    }
}