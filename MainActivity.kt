// MainActivity.kt
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        val py = Python.getInstance()
        val aiModule = py.getModule("rock_paper_scissors_ai")
        var aiChoice = ""

        revealButton.setOnClickListener {
            aiChoice = aiModule.callAttr("choose_action").toString()
            // Display AI's choice on the screen
            displayHandGesture(aiChoice)
        }

        wonButton.setOnClickListener {
            aiModule.callAttr("record_result", opponentMove, "won")
            // Handle win logic
        }

        lostButton.setOnClickListener {
            aiModule.callAttr("record_result", opponentMove, "lost")
            // Handle loss logic
        }

        endButton.setOnClickListener {
            // Display results
        }
    }

    private fun displayHandGesture(choice: String) {
        when (choice) {
            "rock" -> handImageView.setImageResource(R.drawable.rock)
            "paper" -> handImageView.setImageResource(R.drawable.paper)
            "scissors" -> handImageView.setImageResource(R.drawable.scissors)
        }
    }
}