package generalassembly.yuliyakaleda.startercode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

  EditText mEnterWishEdittext;
  Button mAddAWishButton;
  TextView mPreviousWishTextview;
  ListView mWishesListview;
  LinkedList<String> mWishesList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: set up all the view and event listeners.
    mEnterWishEdittext = (EditText)findViewById(R.id.enter_wish_edittext);
    mAddAWishButton = (Button)findViewById(R.id.add_a_wish_button);
    mPreviousWishTextview = (TextView)findViewById(R.id.previous_wish_textview);
    mWishesListview = (ListView)findViewById(R.id.wishes_listview);
    mWishesList = new LinkedList<String>();

    mAddAWishButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //button clicked
            //textview text changes
            //textview text rotates in animation runs where textview is
            //textview text added to list
            //animation ends
            //textview text set to recently added list
            mPreviousWishTextview.setText(mEnterWishEdittext.getText().toString());
            //Animation
            Animation wishAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
            mAddAWishButton.startAnimation(wishAnimation);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, mWishesList);
            mWishesList.add(mEnterWishEdittext.getText().toString());
            mWishesListview.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
            mEnterWishEdittext.setText("");

        }
    });
  }



//  @Override
//  public void onClick(View v) {
    // TODO: 1. get the text from the input field
    //       2. animate it in the center of the screen
    //       3. add it to the list wish
    //       4. clear the input field
//  }
}
