package com.hyperdesign.moviesapp.common.ui.messages

import com.hyperdesign.moviesapp.common.ui.errorhandling.model.UIText

sealed interface IMessageEvent {
    val message: UIText
    val messageType: MessageType

    data class Toast(
        override val message: UIText,
        override val messageType: MessageType = MessageType.DEFAULT
    ) : IMessageEvent
}