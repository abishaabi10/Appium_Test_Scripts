# 🚀 Appium Setup Guide

```bash
🧩 1. Install Node.js
node -v
npm -v
Node.js provides the runtime and npm package manager required to install Appium and its tools.

⚙️ 2. Install Appium
npm install -g appium
appium -v
Installs the Appium server globally so you can run the appium command from any terminal.

🩺 3. Install and Run Appium Doctor
npm install -g appium-doctor
appium-doctor --android
Appium Doctor check environment (Java, Android SDK, adb, etc.) and reports missing prerequisites.

☕ 4. Install Java JDK & Android SDK
JAVA_HOME
ANDROID_HOME
ANDROID_SDK_ROOT

📱 5. Verify Android Tools & Devices
adb version
adb devices

🧠 6. Start Appium Server
appium
Starts the Appium server that connects your test scripts with mobile devices.

---

