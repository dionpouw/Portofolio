package com.jeflette.affirmation.data.remote.response

import com.google.gson.annotations.SerializedName

data class NewResponse(

	@field:SerializedName("phrase")
	val phrase: String? = null
)
