package com.shethabhish.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberBtns(view: View) {
        if (new) {
            display.setText("")
        }
        new = false

        val select = view as Button
        var click:String = display.text.toString()
        when(select.id) {
            b0.id -> {
                click+= "0"
            }
            b1.id -> {
                click+= "1"
            }
            b2.id -> {
                click+= "2"
            }
            b3.id -> {
                click+= "3"
            }
            b4.id -> {
                click+= "4"
            }
            b5.id -> {
                click+= "5"
            }
            b6.id -> {
                click+= "6"
            }
            b7.id -> {
                click+= "7"
            }
            b8.id -> {
                click+= "8"
            }
            b9.id -> {
                click+= "9"
            }
            bdot.id -> {
                click+= "."
            }
            bplusminus.id -> {
                click = "-" + click
            }
        }
        display.setText(click)
    }

    var op = "*"
    var exist = ""
    var new = true
    fun operations(view: View) {

        val select = view as Button
        when(select.id) {
            bmul.id -> {
                op = "*"
            }
            bdiv.id -> {
                op = "/"
            }
            bsub.id -> {
                op = "-"
            }
            bplus.id -> {
                op = "+"
            }
        }
        exist = display.text.toString()
        new = true
    }

    fun equal(view: View) {
        val newno = display.text.toString()
        var total:Double?=null
        when(op) {
            "*" -> {
            total = exist.toDouble() * newno.toDouble()
        }
            "/" -> {
            total = exist.toDouble() / newno.toDouble()
        }
            "+" -> {
                total = exist.toDouble() + newno.toDouble()
            }
            "-" -> {
                total = exist.toDouble() - newno.toDouble()
            }
        }
        display.setText(total.toString())
        new = true
    }

    fun percent(view: View) {
        val number:Double = display.text.toString().toDouble() / 100
        display.setText(number.toString())
        new = true
    }

    fun clean(view:View) {
        display.setText("0")
        new = true
    }
}
