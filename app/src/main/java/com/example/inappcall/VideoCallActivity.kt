package com.example.inappcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.inappcall.databinding.ActivityMainBinding
import com.example.inappcall.databinding.ActivityVideoCallBinding
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class VideoCallActivity : AppCompatActivity() {

    private lateinit var receiverUserId: EditText
    private lateinit var textView: TextView
    private lateinit var videoCallBtn: ZegoSendCallInvitationButton
    private lateinit var audioCallBtn: ZegoSendCallInvitationButton
    private lateinit var buttonLayout: LinearLayout

    private lateinit var binding: ActivityVideoCallBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receiverUserId = binding.receiverUserIdTextField
        textView = binding.userIdTextView
        videoCallBtn = binding.videoCallBtn
        audioCallBtn = binding.audioCallBtn
        buttonLayout = binding.buttonsLayout

        val userId = intent.getStringExtra("userID")
        textView.text = "Hi $userId!"

        receiverUserId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val _receiverId = receiverUserId.text.toString()
                if (_receiverId.isNotEmpty()) {

                    buttonLayout.visibility = View.VISIBLE
                    startVideoCall(_receiverId)
                    startAudioCall(_receiverId)

                }

            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })

    }



    private fun startVideoCall(receiverId: String) {
        videoCallBtn.setIsVideoCall(true)
        videoCallBtn.resourceID = "zego_uikit_call"
        videoCallBtn.setInvitees(listOf(ZegoUIKitUser(receiverId)))
    }

    private fun startAudioCall(receiverId: String) {
        audioCallBtn.setIsVideoCall(false)
        audioCallBtn.resourceID = "zego_uikit_call"
        audioCallBtn.setInvitees(listOf(ZegoUIKitUser(receiverId)))
    }
}