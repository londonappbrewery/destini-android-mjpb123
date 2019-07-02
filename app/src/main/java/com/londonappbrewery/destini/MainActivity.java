package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton, mBottomButton;
    int mCurrentStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);

        mCurrentStory = 1;
        if (savedInstanceState != null)
            mCurrentStory = savedInstanceState.getInt("bCurrentStory");

        switch (mCurrentStory) {
            case 1:
                updateDisplays(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);
                break;
            case 2:
                updateDisplays(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                break;
            case 3:
                updateDisplays(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                break;
            case 4:
                updateDisplays(R.string.T4_End);
                break;
            case 5:
                updateDisplays(R.string.T5_End);
                break;
            case 6:
                updateDisplays(R.string.T6_End);
                break;
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mCurrentStory) {
                    case 1:
                    case 2:
                        mCurrentStory = 3;
                        updateDisplays(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                        break;
                    case 3:
                        mCurrentStory = 6;
                        updateDisplays(R.string.T6_End);
                        break;
                    default:
                        mCurrentStory = 1;
                        updateDisplays(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);
                        break;
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mCurrentStory) {
                    case 1:
                        mCurrentStory = 2;
                        updateDisplays(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                        break;
                    case 2:
                        mCurrentStory = 4;
                        updateDisplays(R.string.T4_End);
                        break;
                    case 3:
                        mCurrentStory = 5;
                        updateDisplays(R.string.T5_End);
                        break;
                    default:
                        mCurrentStory = 1;
                        updateDisplays(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);
                        break;
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("bCurrentStory", mCurrentStory);
    }

    public void updateDisplays(int pStory, int pTopButton, int pBottomButton) {
        mStoryTextView.setText(pStory);
        mTopButton.setText(pTopButton);
        mBottomButton.setText(pBottomButton);
    }

    public void updateDisplays(int pStory) {
        mStoryTextView.setText(pStory);
        mTopButton.setText("Try Again");
        mBottomButton.setText("Time Warp");
    }
}
