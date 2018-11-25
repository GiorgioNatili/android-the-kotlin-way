package io.a2xe.experiments.loginandbrowse.transformers

import com.google.gson.internal.LinkedTreeMap
import io.a2xe.experiments.loginandbrowse.model.entities.MediaEntity

fun toMediaEntity(entities: LinkedTreeMap<*, *>) : MediaEntity {

    return ((entities["extended_entities"] as LinkedTreeMap<*, *>)["media"] as ArrayList<*>)[0].let {

        val data = it as LinkedTreeMap<*, *>
        MediaEntity(data["id_str"] as String,
                data["media_url"] as String,
                data["type"] as String)
    }
}