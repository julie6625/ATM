package com.example.klps_.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    int [] numbers = {19,20,21,22,23,24,25,26};
    String [] rainbow = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        rainbow = getResources().getStringArray(R.array.rainbow);

        RecyclerView recyclerView = findViewById(R.id.AgeCycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());


    }

    public void next(View view) {
        int age = Integer.parseInt(((EditText)findViewById(R.id.ed_age)).getText().toString());
        user.setAge(age);//從BaseActivity呼叫user還有set方法即可
        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);

    }

    public void back(View view){
        finish();
    }

    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHolder>{

        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);

            return new AgeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder holder, final int position) {
            holder.AgeText.setText(numbers[position]+"");
            holder.itemView.setBackgroundColor(Color.parseColor(rainbow[position%7]));
            /*if(numbers[position] == 19){
                holder.AgeText.setTextColor(Color.RED);
            }*/

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("AgeActivity", "onClick: "+numbers[position]/*會自動更改position屬性為 final int*/);
                    TextView AgeText = findViewById(R.id.ed_age);
                    AgeText.setText(numbers[position]+"");
                }
            });
        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }

        class AgeHolder extends RecyclerView.ViewHolder{//alt+enter解決
            TextView AgeText;
            public AgeHolder(View itemView) {
                super(itemView);
                AgeText = itemView.findViewById(R.id.tv_age);
            }
        }
    }
}
