package com.emn.fr.ichat.listener;

import com.emn.fr.ichat.model.Message;

import java.util.List;

public interface LoadMessageListener extends TaskListener {

    public void onSuccess(List<Message> messages);

}
