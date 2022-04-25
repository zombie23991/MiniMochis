package com.example.minimochis;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Chat extends Fragment {

    private RecyclerView chatRV;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFAB;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<ChatModal>chatModalArrayList;
    private ChatRVAdapter chatRVAdapter;
    //GifImageView gifProta;

    //per ensenyar minimochi
    public personatge peronatge = new personatge (1);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_chat, container, false);
        //http://api.brainshop.ai/get?bid=164802&key=8KdAkVbIJld0MFxj&uid=[uid]&msg=
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        userMsgEdt =  getView().findViewById(R.id.idEdtMsg);
        chatRV = getView().findViewById(R.id.idRvChat);
        sendMsgFAB = getView().findViewById(R.id.idFABSend);
        chatModalArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatModalArrayList, chatRV.getContext());
        LinearLayoutManager manager = new LinearLayoutManager(chatRV.getContext());
        chatRV.setLayoutManager(manager);
        chatRV.setAdapter(chatRVAdapter);
        //GIF
        /*gifProta = getView().findViewById(R.id.gifProta);
        gifProta.setImageResource(R.drawable.minimochirosa);*/

        //pposar imatge a personatge
        /*if(peronatge.getEleccio() == 1){
            gifProta.setImageResource(R.drawable.minimochiblanc);
        }else if(peronatge.getEleccio() == 2){
            gifProta.setImageResource(R.drawable.minimochirosa);
        }else if(peronatge.getEleccio() == 3){
            gifProta.setImageResource(R.drawable.minimochiblau);
        }*/



        sendMsgFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userMsgEdt.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(),"Please enter your message",Toast.LENGTH_SHORT).show();
                return;
                }
                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");
            }
        });
    }
    private void getResponse(String message) {
        chatModalArrayList.add(new ChatModal(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url ="http://api.brainshop.ai/get?bid=164802&key=8KdAkVbIJld0MFxj&uid=[uid]&msg=" + message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterficieEndpoints retrofitAPI = retrofit.create(InterficieEndpoints.class);
        Call<MsgModal>call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<MsgModal>() {
            @Override
            public void onResponse(Call<MsgModal> call, Response<MsgModal> response) {
                if (response.isSuccessful()) {
                    MsgModal modal = response.body();
                    chatModalArrayList.add(new ChatModal(modal.getCnt(),BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<MsgModal> call, Throwable t) {
            chatModalArrayList.add(new ChatModal("Please revert your Questions", BOT_KEY));
            }
        });
        }
   }
