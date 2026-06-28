# android-automation-training

📦 Setup & Requirements

To run this project successfully, make sure you have the following tools and dependencies installed:

✅ Prerequisites
| Tool / Application         | Version     | Description                                                                            |
| -------------------------- | ----------- | -------------------------------------------------------------------------------------- |
| **Java JDK**               | 21          | Required to compile and run the test suite. Make sure `JAVA_HOME` is properly set.     |
| **Android Studio**         | 2020.3+     | Required for managing Android SDKs and emulators.                                      |
| **Android SDK**            | API 30+     | Required to run Android tests on emulators or devices.                                 |
| **Appium Server**          | 2.x         | The mobile automation framework. Can be installed via NPM or Appium Desktop.           |
| **Node.js**                | 14+         | Needed for installing Appium and related tools.                                        |
| **Gradle**                 | 8+          | Build tool used to manage dependencies and run test tasks.                             |
| **Git**                    | Any         | Used for version control and cloning the repository.                                   |
| **Real Device / Emulator** | Android 10+ | Required to execute the tests. Ensure USB debugging is enabled if using a real device. |

Note: You can use Appium Inspector to inspect elements on your Android app for locator strategy development. You can install the tool from this repository https://github.com/appium/appium-inspector.

🔧 Installation Steps
1. Clone the Repository: git clone https://github.com/kahfilafath/demo-android-automation-test.git
2. Set JAVA_HOME and ANDROID_HOME to your shell profile (.zshrc / .bashrc) for Mac users, and in the Environment variable for Windows users.
3. Install appium by running this command : npm install -g appium
4. Run from terminal: appium
5. Connect a Device or Launch Emulator. For real device, make sure to enable USB debugging in developer mode option.

✅ Run Test 

Open Terminal > input command " ./gradlew test -Dcucumber.filter.tags='@TCID'"
OR just input scenario tag in cucumberRunner.java OR click play button on .feature file

