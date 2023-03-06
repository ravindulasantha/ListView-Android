package com.test.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] fruitsname = {"\"Love is not about possession. Love is about appreciation.\" - Osho",
            "\"The best love is the kind that awakens the soul and makes us reach for more, that plants a fire in our hearts and brings peace to our minds.\" - Nicholas Sparks",
            "\"Love is composed of a single soul inhabiting two bodies.\" - Aristotle",
            "\n" +
                    "\"I have waited for this opportunity for more than half a century, to repeat to you once again my vow of eternal fidelity and everlasting love.\" - Gabriel Garcia Marquez",


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        CustomerAdapter customerAdapter = new CustomerAdapter();
        listView.setAdapter(customerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ListdataActivity.class);
                intent.putExtra("name",fruitsname[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomerAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fruitsname.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            TextView name = view1.findViewById(R.id.friut);

            name.setText(fruitsname[i]);
            return view1;
        }
    }
}