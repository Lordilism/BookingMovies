package com.example.moviesbookingapp.activities

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesbookingapp.R
import com.example.moviesbookingapp.activities.adapters.FoodAndBeverageAdapter
import com.example.moviesbookingapp.activities.adapters.FoodAndBeverageInsideAdapter
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.dialog_ticket_cancelion_policy.*

class CheckOutActivity : AppCompatActivity() {
    lateinit var mFoodAndBeverageAdapter: FoodAndBeverageAdapter
    lateinit var mFoodAndBeverageInsideAdapter: FoodAndBeverageInsideAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CheckOutActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        setUpcheckoutRecyclerview()
        setUpCancelionPolicy()
        setUpBookingSuccess()
        setupNavigate()
    }

    private fun setupNavigate() {

    }

    private fun setUpBookingSuccess() {
//        val builder = AlertDialog.Builder(this,R.style.myFullscreenAlertDialogStyle)
//        val inflater = this.layoutInflater
//        builder.setView(inflater.inflate(R.layout.booking_success,null))
//        builder.setCancelable(false)
//        val dialog=builder.create()
        ivBtnContinue.setOnClickListener {

//            dialog.show()
            startActivity(PaymentActivity.newIntent(this))
            this.finish()
//            Handler().postDelayed(Runnable {
//                dialog.dismiss()
//
//            },3000)


        }

    }

    private fun setUpCancelionPolicy() {
        tvTicketCancelionPolicy.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_ticket_cancelion_policy)
            dialog.btnCloseDialog.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }

    private fun setUpcheckoutRecyclerview() {
        mFoodAndBeverageInsideAdapter = FoodAndBeverageInsideAdapter()
        mFoodAndBeverageAdapter = FoodAndBeverageAdapter(mFoodAndBeverageInsideAdapter, this)
        rvCheckoutOutter.adapter = mFoodAndBeverageAdapter
        rvCheckoutOutter.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}