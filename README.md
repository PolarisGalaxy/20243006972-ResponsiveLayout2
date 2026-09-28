# Responsive Layout 2

## Android Application - Alternative Responsive Layouts

**Student:** Guo Yuqi  
**Student ID:** 20243006972  
**Practical:** 2 - Implementing Alternative Responsive Layouts

---

## Project Overview

This Android application extends the responsive UI from Practical 1 with
**alternative layouts** that are loaded based on the device configuration.

The application uses Android's resource qualifier system to automatically
pick the correct layout file at runtime - no Java code changes are needed
when the device rotates or when running on a tablet.

### Layouts Provided

| Layout file                                  | When it is used                                          |
| -------------------------------------------- | -------------------------------------------------------- |
| `res/layout/activity_main.xml`               | Default - portrait phone (LinearLayout, vertical)        |
| `res/layout-land/activity_main.xml`          | Landscape orientation (LinearLayout, two-pane horizontal) |
| `res/layout-sw600dp/activity_main.xml`       | Smallest width >= 600dp (ConstraintLayout, two-pane)     |

### Part 1 - Orientation Qualifier (Landscape)

- Resource directory: `res/layout-land/`
- Loads automatically when the device is rotated to landscape
- Uses a **horizontal LinearLayout** to take advantage of the wider screen
- Left pane  : header, subheader, description text
- Right pane : info text and the two action buttons
- All sizes use `0dp` + `layout_weight`, `wrap_content`, and `dp/sp` units
- No hard-coded pixel dimensions

### Part 2 - Smallest Width Qualifier (`sw600dp`)

- Resource directory: `res/layout-sw600dp/`
- Loads automatically on 7-inch (or larger) tablets
- Uses a **ConstraintLayout** with a vertical guideline at 40% of the width
- Left pane  : title, subtitle, and description (60% of the width)
- Right pane : info text and the two action buttons (40% of the width)
- Larger text sizes and padding for a tablet-friendly feel
- No hard-coded pixel dimensions

---

## How the Resource System Works

All three layouts use the **same file name** (`activity_main.xml`) so
`setContentView(R.layout.activity_main)` always loads the right one:

```
Portrait phone      -> res/layout/activity_main.xml
Landscape phone     -> res/layout-land/activity_main.xml
Tablet (>= 600dp)   -> res/layout-sw600dp/activity_main.xml
```

When several qualifier folders could match (e.g. landscape tablet), Android
picks the most specific one. No Java code changes are required when the
device rotates - the activity is recreated and the right XML is inflated
automatically.

---

## Project Structure

```
20243006972-ResponsiveLayout2/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/responsivelayout/
│   │   │   └── MainActivity.java
│   │   ├── res/
│   │   │   ├── layout/                 (default - portrait phone)
│   │   │   │   └── activity_main.xml
│   │   │   ├── layout-land/            (landscape orientation)
│   │   │   │   └── activity_main.xml
│   │   │   ├── layout-sw600dp/         (smallest width >= 600dp)
│   │   │   │   └── activity_main.xml
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── themes.xml
│   │   │   ├── drawable/
│   │   │   └── mipmap-*/
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
├── gradle.properties
└── .gitignore
```

---

## Requirements

- Android Studio (Arctic Fox or later)
- Android SDK (API Level 24 or higher)
- JDK 8 or higher

---

## Building the Project

1. Open Android Studio
2. Select **Open an existing project**
3. Navigate to and select the `20243006972-ResponsiveLayout2` folder
4. Wait for Gradle sync to complete
5. Run the app on an emulator or device

---

## Testing the Alternative Layouts

### Landscape orientation (Part 1)

1. Run the app on a **phone** emulator
2. Rotate the emulator using `Ctrl + Left/Right Arrow`
   (or use the rotation button in the emulator toolbar)
3. Verify that the two-pane landscape layout is loaded

### Tablet / smallest width (Part 2)

1. Open the **Device Manager** in Android Studio
2. Create a **tablet** virtual device (e.g. Pixel C or Nexus 7)
3. Run the app on this tablet emulator
4. Verify that the two-pane ConstraintLayout is loaded instead of the
   default portrait layout

---

## Important Rules Followed

- All XML was written manually - no drag-and-drop UI construction
- No hard-coded pixel dimensions - only `0dp`, `match_parent`,
  `wrap_content`, `dp` and `sp` are used
- Tested on both a phone (portrait + landscape) and a tablet emulator

---

## GitHub Repository

Repository: `20243006972-ResponsiveLayout2`