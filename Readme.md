# Android Task Flow Lab

A practical Android learning project focused on understanding how Android manages Activities, Lifecycles, Tasks, Back Stack behavior, and Launch Modes internally.

This repository is part of a larger educational journey where every Android concept is learned through:

* Theory
* Real implementation
* Lifecycle observation
* Logcat analysis

---

# What This Project Covers

## Core Concepts

This project demonstrates and explains:

* Activities
* Activity Lifecycle
* Intents
* Back Stack
* Tasks
* Launch Modes

  * standard
  * singleTop
  * singleTask
  * singleInstance

The project uses:

* Kotlin
* Jetpack Compose
* Android Logcat
* Multiple Activities
* Real navigation scenarios

---

# Why This Project Matters

Many beginners learn Android by building UI only.

However, real Android development requires understanding:

* how screens are created
* how Android manages memory
* how navigation works internally
* how Activities are reused
* how Tasks behave
* what happens when the user presses Back
* what happens when Activities are relaunched

Without understanding these concepts, developers often:

* create navigation bugs
* break app flow
* misuse launch modes
* leak memory
* accidentally duplicate Activities
* misunderstand lifecycle behavior

This project focuses on understanding Android system behavior first.

---

# Project Structure

```text
app/
 └── src/
     └── main/
         ├── java/
         │   └── com.example.androidtaskflowlab/
         │       ├── MainActivity.kt
         │       ├── SecondActivity.kt
         │       └── ThirdActivity.kt
         │
         ├── res/
         │
         └── AndroidManifest.xml
```

---

# Understanding Activities

## What is an Activity?

An Activity represents a single screen in an Android application.

Examples:

* Login screen
* Home screen
* Settings screen
* Profile screen

Every screen the user interacts with is usually an Activity.

Activities are managed completely by the Android operating system.

Android decides:

* when to create Activities
* when to pause them
* when to destroy them
* when to restore them

This is why understanding lifecycle behavior is extremely important.

---

# Activity Lifecycle

The Activity Lifecycle describes the different states an Activity goes through during its existence.

In this project, every lifecycle callback is logged using Logcat.

Example:

```kotlin
override fun onStart() {
    super.onStart()
    Log.d("LIFECYCLE", "SecondActivity onStart")
}
```

---

# Lifecycle States

## onCreate()

Called when the Activity is first created.

Usually used for:

* initializing UI
* setting content
* creating objects
* preparing state

This is where the Activity starts existing.

---

## onStart()

The Activity becomes visible to the user.

The Activity is now entering the foreground.

---

## onResume()

The Activity becomes interactive.

The user can now:

* click
* type
* interact with the screen

The Activity is now fully active.

---

## onPause()

Called when another Activity partially covers the current Activity.

The Activity may still be partially visible.

Used for:

* pausing animations
* saving temporary state
* stopping lightweight operations

---

## onStop()

The Activity is no longer visible.

Usually triggered when:

* another Activity fully covers it
* the app goes to background

Heavy resources should be released here.

---

## onRestart()

Called when a stopped Activity returns again.

Example:

* User presses Back from another Activity

The Activity is restarted instead of recreated.

---

## onDestroy()

The Activity is being destroyed.

Possible reasons:

* finish() called
* configuration changes
* system removes Activity
* app closes

The Activity instance is removed from memory.

---

# Understanding the Back Stack

Android stores Activities inside a stack called the Back Stack.

The stack works using:

* LIFO (Last In, First Out)

Example flow:

```text
MainActivity
    ↓
SecondActivity
    ↓
ThirdActivity
```

Back Stack:

```text
TOP
ThirdActivity
SecondActivity
MainActivity
BOTTOM
```

When the user presses Back:

* ThirdActivity is destroyed
* SecondActivity becomes visible again

Android automatically restores the previous Activity from the stack.

---

# Understanding Tasks

A Task is a collection of Activities working together.

Think of a Task as:

* an application navigation session

Each app usually has its own Task.

The Android Recents Screen displays Tasks, not Activities.

A Task contains:

* a Back Stack
* multiple Activities

Understanding Tasks is essential because launch modes directly affect Task behavior.

---

# Launch Modes

Launch Modes control how Android creates and reuses Activities.

Defined inside:

```xml
AndroidManifest.xml
```

Example:

```xml
<activity
    android:name=".SecondActivity"
    android:launchMode="singleTop" />
```

---

# 1. standard

## Default Behavior

Every time the Activity is launched:

* Android creates a NEW instance

Example:

```text
MainActivity
    ↓
SecondActivity
    ↓
SecondActivity
    ↓
SecondActivity
```

Each launch creates another copy.

---

## Important Characteristics

* default launch mode
* unlimited instances
* multiple copies allowed
* each instance added to Back Stack

---

## Real Usage

Most Activities use:

* standard

because normal navigation usually requires separate instances.

---

# 2. singleTop

## Behavior

If the Activity is already at the TOP of the stack:

* Android reuses it

Instead of creating a new instance.

If not on top:

* a new instance is created

---

## Example

Current stack:

```text
MainActivity
SecondActivity
```

Launching SecondActivity again:

```text
MainActivity
SecondActivity
```

No new instance created.

---

## Why It Matters

Prevents duplicate screens when:

* repeatedly clicking notifications
* repeatedly pressing buttons
* reopening the same top screen

---

# 3. singleTask

## Behavior

Only ONE instance of the Activity exists inside the Task.

If the Activity already exists:

* Android brings it to front
* destroys Activities above it

---

## Example

Before:

```text
MainActivity
SecondActivity
ThirdActivity
```

Launching SecondActivity again:

```text
MainActivity
SecondActivity
```

ThirdActivity gets destroyed.

---

## Why It Matters

Useful for:

* Home screens
* Main dashboards
* Root navigation screens

Prevents deep duplicate navigation chains.

---

# 4. singleInstance

## Behavior

The Activity exists completely alone inside its own Task.

No other Activities can exist in the same Task.

This is the most isolated launch mode.

---

## Important Characteristics

* separate Task
* isolated Activity
* highly specialized behavior

---

## Real Usage

Rarely used.

Historically used for:

* call screens
* system-level interfaces
* assistant overlays
* highly isolated flows

---

# Comparing Launch Modes

| Launch Mode    | Multiple Instances | Reuses Existing | Separate Task |
| -------------- | ------------------ | --------------- | ------------- |
| standard       | Yes                | No              | No            |
| singleTop      | Sometimes          | Only if top     | No            |
| singleTask     | No                 | Yes             | No            |
| singleInstance | No                 | Yes             | Yes           |

---

# What Was Practiced in This Project

This project includes:

* navigating between multiple Activities
* lifecycle logging
* launch mode experiments
* back stack observation
* task behavior testing
* activity recreation testing
* real Logcat analysis

Every behavior was tested practically using:

* emulator
* button navigation
* repeated launches
* back navigation
* Activity relaunching

---

# Key Learning Outcome

The most important lesson from this project is:

Android is not only UI.

Android is a system that actively manages:

* memory
* processes
* screens
* navigation
* lifecycle state
* task management

Understanding these internal mechanics is one of the biggest differences between:

* beginner Android developers
* professional Android engineers

---

# Educational Goal

This repository is part of a long-term educational roadmap.

The final goal is to create:

* a practical Android learning index
* beginner-friendly repositories
* concept-focused examples
* real implementation labs
* documented Android experiments

Every repository focuses on:

1. theory
2. implementation
3. experimentation
4. system behavior observation
5. documented findings
