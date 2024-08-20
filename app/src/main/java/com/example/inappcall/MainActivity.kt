package com.example.inappcall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inappcall.databinding.ActivityMainBinding
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService
import android.content.Context



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var nextButton = binding.buttonNext
    var userIdEditText = binding.userIdTextField

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nextButton.setOnClickListener {
            val userId = userIdEditText.text.toString()

            if (userId.isNotEmpty()){
                val intent = Intent(this@MainActivity, VideoCallActivity::class.java)
                intent.putExtra("userID", userId)
                startActivity(intent)

                videoCallServices(userId)

            }
        }
    }



    private fun videoCallServices(userID: String) {
//        val appID: Long = 0L // your App ID of Zoge Cloud
//        val appSign = "" // your App Sign of Zoge Cloud
//        val application = application // Android's application context
//        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
//    //    callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true
//        val notificationConfig = ZegoNotificationConfig()
//        notificationConfig.sound = "zego_uikit_sound_call"
//        notificationConfig.channelID = "CallInvitation"
//        notificationConfig.channelName = "CallInvitation"
//        ZegoUIKitPrebuiltCallInvitationService.init(
//            application,
//            appID,
//            appSign,
//            userID,
//            userID,
//            callInvitationConfig
//        )
    }

    override fun onDestroy() {
        super.onDestroy()
        ZegoUIKitPrebuiltCallInvitationService.unInit()
    }



}