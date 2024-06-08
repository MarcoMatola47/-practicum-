```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyApplicationTry - README</title>
</head>
<body>
    <h1>MyApplicationTry</h1>
    <p>Welcome to MyApplicationTry, an Android application designed to help users track and manage their screen time activities. This README provides instructions on how to set up, use, and understand the functionality of the application.</p>

    <h2>Table of Contents</h2>
    <ul>
        <li><a href="#introduction">Introduction</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#usage">Usage</a>
            <ul>
                <li><a href="#mainactivity">MainActivity</a></li>
                <li><a href="#mainactivity2">MainActivity2</a></li>
                <li><a href="#mainactivity3">MainActivity3</a></li>
            </ul>
        </li>
        <li><a href="#contributing">Contributing</a></li>
        <li><a href="#license">License</a></li>
    </ul>

    <h2 id="introduction">Introduction</h2>
    <p>MyApplicationTry is a simple Android application that allows users to log and view their daily screen time activities. The purpose of the app is to help users keep track of how much time they spend on their devices each day, split into morning and afternoon sessions. Users can also add notes for each day to provide context or additional details about their screen time usage.</p>

    <h2 id="features">Features</h2>
    <ul>
        <li><strong>MainActivity</strong>: A welcome screen with navigation to the screen time logging screen.</li>
        <li><strong>MainActivity2</strong>: Input fields for date, morning screen time, afternoon screen time, and notes with options to save or clear inputs.</li>
        <li><strong>MainActivity3</strong>: Displays the saved screen time details.</li>
    </ul>

    <h2 id="installation">Installation</h2>
    <p>To set up MyApplicationTry on your local machine:</p>
    <ol>
        <li>Clone the repository:
            <pre><code>git clone https://github.com/yourusername/MyApplicationTry.git</code></pre>
        </li>
        <li>Open the project in Android Studio.</li>
        <li>Build the project and run it on an Android emulator or a physical device.</li>
    </ol>

    <h2 id="usage">Usage</h2>

    <h3 id="mainactivity">MainActivity</h3>
    <p>The main entry point of the application, which displays a welcome screen.</p>
    <ul>
        <li><strong>UI Elements</strong>:
            <ul>
                <li><code>TextView</code>: Displays a welcome message.</li>
                <li><code>Button</code>: Navigates to <code>MainActivity2</code>.</li>
                <li><code>ImageView</code>: Displays an image (can be customized).</li>
            </ul>
        </li>
    </ul>

    <h3 id="mainactivity2">MainActivity2</h3>
    <p>Allows users to input their daily screen time details, including date, morning screen time, afternoon screen time, and notes.</p>
    <ul>
        <li><strong>UI Elements</strong>:
            <ul>
                <li><code>EditText</code>: Input fields for date, morning screen time, afternoon screen time, and notes.</li>
                <li><code>Button</code>: Save the input, clear the input fields, and navigate to <code>MainActivity3</code>.</li>
                <li><code>TextView</code>: Displays messages to the user.</li>
            </ul>
        </li>
    </ul>

    <h4>Explanation:</h4>

    <p>1. <strong>UI Elements Initialization</strong>:</p>
    <pre><code>eDate = findViewById(R.id.eDate)
eMorning = findViewById(R.id.eMorning)
eAfternoon = findViewById(R.id.eAfternoon)
eNotes = findViewById(R.id.eNotes)
saveButton = findViewById(R.id.saveButton)
cleanButton = findViewById(R.id.cleanButton)
nextButton = findViewById(R.id.nextButton)
tvMessage = findViewById(R.id.tvMessage)</code></pre>
    <p>Initializes the UI elements by finding them in the layout.</p>

    <p>2. <strong>Clear Button</strong>:</p>
    <pre><code>cleanButton.setOnClickListener {
    eDate.setText("")
    eMorning.setText("")
    eAfternoon.setText("")
    eNotes.setText("")
}</code></pre>
    <p>Clears all input fields when the "Clean" button is clicked.</p>

    <p>3. <strong>Save Button</strong>:</p>
    <pre><code>saveButton.setOnClickListener {
    val screenTimeDate = eDate.text.toString()
    val screenTimeMorning = eMorning.text.toString()
    val screenTimeAfternoon = eAfternoon.text.toString()
    val screenTimeNote = eNotes.text.toString()

    if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty()) {
        try {
            dateArray.add(screenTimeDate)
            morningArrayTime.add(screenTimeMorning.toFloat())
            afternoonArrayTime.add(screenTimeAfternoon.toFloat())
            notesArray.add(screenTimeNote)
            eDate.text.clear()
            eMorning.text.clear()
            eAfternoon.text.clear()
            eNotes.text.clear()
            tvMessage.text = "Data saved successfully"
        } catch (e: NumberFormatException) {
            tvMessage.text = "Please enter a valid number"
        }
    } else {
        tvMessage.text = "Input cannot be empty"
    }
}</code></pre>
    <p>Saves the input data into corresponding lists if the fields are not empty and the numbers are valid.</p>

    <p>4. <strong>Next Button</strong>:</p>
    <pre><code>nextButton.setOnClickListener {
    val intent = Intent(this, MainActivity3::class.java)
    intent.putExtra("dateArray", dateArray.toTypedArray())
    intent.putExtra("morningArrayTime", morningArrayTime.toFloatArray())
    intent.putExtra("afternoonArrayTime", afternoonArrayTime.toFloatArray())
    intent.putExtra("notesArray", notesArray.toTypedArray())
    startActivity(intent)
}</code></pre>
    <p>Navigates to <code>MainActivity3</code> and passes the collected data through the intent.</p>

    <h3 id="mainactivity3">MainActivity3</h3>
    <p>Displays the saved screen time details.</p>
    <ul>
        <li><strong>UI Elements</strong>:
            <ul>
                <li><code>TextView</code>: Displays the saved dates, morning screen time, afternoon screen time, and notes.</li>
                <li><code>Button</code>: Returns to the previous screen.</li>
            </ul>
        </li>
    </ul>

    <h4>Explanation:</h4>

    <p>1. <strong>UI Elements Initialization</strong>:</p>
    <pre><code>textView2 = findViewById(R.id.textView2)
textView3 = findViewById(R.id.textView3)
textView4 = findViewById(R.id.textView4)
textView5 = findViewById(R.id.textView5)
button3 = findViewById(R.id.button3)</code></pre>
    <p>Initializes the UI elements by finding them in the layout.</p>

    <p>2. <strong>Retrieve Data from Intent</strong>:</p>
    <pre><code>val dateArray = intent.getStringArrayExtra("dateArray")?.toList() ?: emptyList()
val morningArrayTime = intent.getFloatArrayExtra("morningArrayTime")?.toList() ?: emptyList()
val afternoonArrayTime = intent.getFloatArrayExtra("afternoonArrayTime")?.toList() ?: emptyList()
val noteArray = intent.getStringArrayExtra("notesArray")?.toList() ?: emptyList()</code></pre>
    <p>Retrieves the data passed from <code>MainActivity2</code> through the intent.</p>

    <p>3. <strong>Display Data</strong>:</p>
    <pre><code>val dated = StringBuilder()
for ((index, date) in dateArray.withIndex()) {
    dated.append("Day $index: $date \n")
}
val hoursAM = StringBuilder()
for ((index, time) in morningArrayTime.withIndex()) {
    hoursAM.append("Morning $index: $time \n")
}
val hoursPM = StringBuilder()
for ((index, time) in afternoonArrayTime.withIndex()) {
    hoursPM.append("Afternoon $index: $time \n")
}
val noted = StringBuilder()
for ((index, note) in
