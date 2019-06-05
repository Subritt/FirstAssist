//package com.example.subritt.firstassist;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.List;
//
//public class MessengerAdapter extends RecyclerView.Adapter<MessengerAdapter.MessageViewHolder>{
//
//    private List<MessengerModel> mMessageList;
//    private DatabaseReference mUserDatabase;
//
//    public MessengerAdapter(List<MessengerModel> mMessageList) {
//
//        this.mMessageList = mMessageList;
//        Log.d("Raaaaaaaaaakhnu parne ", mMessageList.size()+" ");
//
//
//    }
//
//    @NonNull
//    @Override
//    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.single_chat_layout ,parent, false);
//        Log.d("Raaaaaaaaaakhnu parne ", " ");
//
//
//        return new MessageViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
//
//        final MessengerModel mM = mMessageList.get(position);
//        String message = mM.getMessage();
//        String from = mM.getFrom();
//
//        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(from);
//        mUserDatabase = mUserDatabase.push();
//        mUserDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String message = dataSnapshot.child("message").getValue().toString();
//                String from = mM.getKey();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        Log.d("Raaaaaaaaaakhnu parne ", message+" ");
//        holder.messageText.setText("something");
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//
//    public class MessageViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView messageText;
//        public TextView displayName;
//        public MessageViewHolder(View itemView) {
//            super(itemView);
//
//            messageText = (TextView) itemView.findViewById(R.id.message_text_layout);
//            displayName = (TextView) itemView.findViewById(R.id.name_text_layout);
//            Log.d("Raaaaaaaaaakhnu parne ", " ");
//
//
//
//        }
//    }
//}
