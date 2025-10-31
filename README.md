# Install Node.js
```bash
node -v
npm -v


Node.js provides the runtime and npm package manager required to install Appium and its tools.

#Install Appium
*npm install -g appium
  verify
*appium -v

This installs the Appium server globally so you can run the appium command from any terminal. Checking the version confirms the server binary was installed successfully.

#Install and run appium-doctor

*npm install -g appium-doctor
# verify Android environment
*appium-doctor --android

appium-doctor scans your environment (Java, Android SDK, adb, etc.) and reports missing prerequisites.

#Install Java JDK & Android SDK and set environment variables

#Verify Android tools & devices
*adb version
*adb devices

adb version ensures platform-tools are installed and on PATH; adb devices lists connected/emulator devices so Appium can target them. If the device shows unauthorized, accept USB debugging on the device; if no devices appear, start an emulator or connect a phone.

#Start Appium server

*appium
The appium command launches the Appium server that controls mobile devices for testing.
It receives test commands from your script and executes them on the connected Android or iOS device.


