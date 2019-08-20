package com.lambdaschool.basilssprint2challengedemonstration.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.basilssprint2challengedemonstration.R
import com.lambdaschool.basilssprint2challengedemonstration.adapter.ListAdapter
import com.lambdaschool.basilssprint2challengedemonstration.data.DataConstants
import com.lambdaschool.basilssprint2challengedemonstration.model.Unsplash
import com.lambdaschool.basilssprint2challengedemonstration.util.NotificationMaker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val fullList = mutableListOf<Unsplash>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_notify.setOnClickListener {
            NotificationMaker.notify(this)
        }

        button_share.setOnClickListener {

            var inviteToParty: String = ""

            fullList.forEach {
                if (it.isInvited)
                    inviteToParty += it.name + " "
            }

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Invited to the party: $inviteToParty")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Send Party List"))
        }


        DataConstants.EACH_ID.forEachIndexed { index, i ->
            fullList.add(Unsplash(i, DataConstants.EACH_NAME.get(index)))
        }

        recycler_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view.layoutManager = manager

        val adapter = ListAdapter(fullList)
        recycler_view.adapter = adapter
    }
}
