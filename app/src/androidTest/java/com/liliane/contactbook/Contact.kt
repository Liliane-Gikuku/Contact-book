package com.liliane.contactbook

import android.provider.ContactsContract

data class Contact(
    var name:String,
    var phone:String,
    var email: String,
    var address:String,
)
