package com.example.inappcall


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class VideoCallActivity : AppCompatActivity() {

    private lateinit var receiverUserId: EditText
    private lateinit var textView: TextView
    private lateinit var videoCallBtn: ZegoSendCallInvitationButton
    private lateinit var audioCallBtn: ZegoSendCallInvitationButton
    private lateinit var buttonLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)

        receiverUserId = findViewById(R.id.receiver_user_id_text_field)
        textView = findViewById(R.id.user_id_text_view)
        videoCallBtn = findViewById(R.id.video_call_btn)
        audioCallBtn = findViewById(R.id.audio_call_btn)
        buttonLayout = findViewById(R.id.buttons_layout)

        val userId = intent.getStringExtra("userID")
        textView.text = "Hi $userId!"

        receiverUserId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val _receiverId = receiverUserId.text.toString()
                Log.v("reciever id" , _receiverId)
                if (_receiverId.isNotEmpty()) {

                    buttonLayout.visibility = View.VISIBLE
                    startVideoCall(_receiverId)
                    startAudioCall(_receiverId)

                }

            }

            override fun afterTextChanged(s: Editable?) {
                // No action needed

            }

        })
    }

    private fun startVideoCall(receiverId: String) {
        videoCallBtn.setIsVideoCall(true)
        videoCallBtn.resourceID = "zego_call"
        videoCallBtn.setInvitees(listOf(ZegoUIKitUser(receiverId)))
    }

    private fun startAudioCall(receiverId: String) {
        audioCallBtn.setIsVideoCall(false)
        audioCallBtn.resourceID = "zego_call"
        audioCallBtn.setInvitees(listOf(ZegoUIKitUser(receiverId)))
    }
}