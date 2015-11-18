package com.emn.fr.ichat.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.emn.fr.ichat.R;
import com.emn.fr.ichat.model.Message;

import java.util.List;

public class MessageAdapter implements ListAdapter {

    private Context context;
    private List<Message> messageList;
    private String login;

    public MessageAdapter(Context context, List<Message> messageList, String login) {
        this.context = context;
        this.messageList = messageList;
        this.login = login;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    static class IncomingViewHolder {
        TextView loginText;
        TextView messageText;
    }

    static class OutgoingViewHolder {
        TextView messageText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(context.LAYOUT_INFLATER_SERVICE);
        String currentLogin = messageList.get(position).getLogin();

        if (!login.equals(currentLogin)) {
            // INCOMING
            View incomingView = layoutInflater.inflate(R.layout.incoming_message, parent, false);
            IncomingViewHolder incomingViewHolder = new IncomingViewHolder();
            incomingViewHolder.loginText = (TextView) incomingView.findViewById(R.id.login_text);
            incomingViewHolder.messageText = (TextView) incomingView.findViewById(R.id.message_text);
            incomingView.setTag(incomingViewHolder);

            convertView = incomingView;
            IncomingViewHolder viewHolder = (IncomingViewHolder) convertView.getTag();
            viewHolder.loginText.setText(currentLogin);
            viewHolder.messageText.setText(messageList.get(position).getMessage());
        } else {
            // OUTGOING
            View outgoingView = layoutInflater.inflate(R.layout.outgoing_message, parent, false);
            OutgoingViewHolder outgoingViewHolder = new OutgoingViewHolder();
            outgoingViewHolder.messageText = (TextView) outgoingView.findViewById(R.id.message_text);
            outgoingView.setTag(outgoingViewHolder);

            convertView = outgoingView;
            OutgoingViewHolder viewHolder = (OutgoingViewHolder) convertView.getTag();
            viewHolder.messageText.setText(messageList.get(position).getMessage());
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return messageList.isEmpty();
    }
}
