package com.emn.fr.ichat.listener;

public interface TaskListener {

    public void onSuccess();
    public void onFailed();
    public void showProgress(final boolean show);

}
