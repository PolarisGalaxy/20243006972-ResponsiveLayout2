package com.example.responsivelayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity - Demonstrates responsive UI layouts in Android
 *
 * Practical 1:
 *   - Part 1: LinearLayout with Weights
 *   - Part 2: ConstraintLayout with Weights
 *
 * Practical 2 (this version - ResponsiveLayout2):
 *   - Part 1: Orientation Qualifier (layout-land/activity_main.xml)
 *       Two-pane horizontal layout that loads automatically when the
 *       device is in landscape orientation.
 *   - Part 2: Smallest Width Qualifier (layout-sw600dp/activity_main.xml)
 *       Two-pane ConstraintLayout that loads automatically on devices
 *       whose smallest dimension is at least 600dp (e.g. 7-inch tablets).
 *
 * The default portrait layout (res/layout/activity_main.xml) is the
 * original vertical LinearLayout from Practical 1, kept as the foundation.
 *
 * Because all three layouts share the same name (activity_main.xml),
 * Android automatically picks the right one based on the device
 * configuration - no Java/Kotlin code changes are needed at runtime.
 *
 * Author: Guo Yuqi
 * Student ID: 20243006972
 */
public class MainActivity extends AppCompatActivity {

    private TextView textHeader;
    private TextView textSubheader;
    private TextView textDescription;
    private TextView textInfo;
    private Button buttonChange;
    private Button buttonCancel;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Android automatically selects the correct activity_main.xml based on
        // device configuration:
        //   - res/layout/activity_main.xml             (default: portrait phone)
        //   - res/layout-land/activity_main.xml        (landscape orientation)
        //   - res/layout-sw600dp/activity_main.xml     (smallest width >= 600dp)
        setContentView(R.layout.activity_main);

        initializeViews();
        setupButtonListeners();
    }

    /**
     * Initialize all views by finding them by ID.
     * All three layouts use the same view IDs so this code works unchanged
     * across the default, landscape and sw600dp layouts.
     */
    private void initializeViews() {
        textHeader = findViewById(R.id.text_header);
        textSubheader = findViewById(R.id.text_subheader);
        textDescription = findViewById(R.id.text_description);
        textInfo = findViewById(R.id.text_info);
        buttonChange = findViewById(R.id.button_change);
        buttonCancel = findViewById(R.id.button_cancel);
    }

    /**
     * Set up click listeners for the buttons.
     */
    private void setupButtonListeners() {
        // Change button - increments the click counter and updates the text
        buttonChange.setOnClickListener(v -> {
            clickCount++;
            updateTextContent();
        });

        // Cancel button - resets the counter
        buttonCancel.setOnClickListener(v -> {
            clickCount = 0;
            resetTextContent();
        });
    }

    /**
     * Update text content based on click count.
     */
    private void updateTextContent() {
        if (textHeader != null) {
            textHeader.setText("Header Updated (" + clickCount + ")");
        }
        if (textSubheader != null) {
            textSubheader.setText("Subheader Clicked: " + clickCount + " times");
        }
    }

    /**
     * Reset text content to original state.
     */
    private void resetTextContent() {
        if (textHeader != null) {
            textHeader.setText(R.string.text_header);
        }
        if (textSubheader != null) {
            textSubheader.setText(R.string.text_subheader);
        }
        if (textDescription != null) {
            textDescription.setText(R.string.text_description);
        }
        if (textInfo != null) {
            textInfo.setText(R.string.text_info);
        }
    }
}