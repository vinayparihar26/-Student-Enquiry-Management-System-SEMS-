package com.example.customalertdialogboxtask

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogBox : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Are You Sure")
                .setPositiveButton("Yes"){
                        dialog, id -> requireActivity().finish()
                }
                .setNegativeButton("No"){
                        dialog, id-> dialog.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}